package ppkeitkhalkszavu.projectrossini.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private String id;
    private int amount;
    private String prepDescr;
    private int prepTime;

    private Material material;
    private Recipe recipe;
}
