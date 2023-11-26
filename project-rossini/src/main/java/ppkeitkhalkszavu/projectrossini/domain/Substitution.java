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
    @JoinColumn (name = "source_id")
    private Ingredient source;
    @ManyToOne
    @JoinColumn (name = "substitute_id")
    private Ingredient substitute;
}
