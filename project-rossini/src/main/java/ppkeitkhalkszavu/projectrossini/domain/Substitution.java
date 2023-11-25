package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "substitutions")
public class Substitution {
    @Id
    @GeneratedValue
    private String id;

    private Ingredient source;
    private Ingredient substitute;
}
