package ppkeitkhalkszavu.projectrossini.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonIgnore
    private int id;
    @Column(nullable = false)
    private float amount;
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String prepDescr;
    @Column(nullable = false)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int prepTime = 0;
    @Column(nullable = false)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Boolean isSubstitute = false;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;
}
