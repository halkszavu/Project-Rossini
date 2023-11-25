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
    private String id;
    @Column
    private int amount;
    @Column
    private String prepDescr;
    @Column
    private int prepTime;

    @ManyToOne
    private Material material;
    @OneToMany
    @JoinColumn (name = "recipe_id")
    private Recipe recipe;
}
