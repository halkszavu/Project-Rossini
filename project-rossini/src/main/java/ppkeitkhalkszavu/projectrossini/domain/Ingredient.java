package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private float amount;
    @Column
    private String prepDescr;
    @Column(nullable = false)
    private int prepTime = 0;
    @Column(nullable = false)
    private Boolean isSubstitute = false;

    @ManyToOne
    private Material material;
    @ManyToOne
    private Recipe recipe;
}
