package ppkeitkhalkszavu.projectrossini.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "findByRecipeId", query = "SELECT i FROM Ingredient i WHERE i.recipe.id = ?1")
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
    @JoinColumn(name = "material_id")
    private Material material;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;
}
