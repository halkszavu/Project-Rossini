package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
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

    @ManyToOne
    private Ingredient source;
    @ManyToOne
    private Ingredient substitute;
}
