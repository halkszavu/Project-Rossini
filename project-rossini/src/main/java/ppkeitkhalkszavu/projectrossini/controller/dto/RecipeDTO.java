package ppkeitkhalkszavu.projectrossini.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppkeitkhalkszavu.projectrossini.domain.Dish;
import ppkeitkhalkszavu.projectrossini.domain.Ingredient;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private int id;
    private String name;
    private int methodTime;
    private int restTime = 0;
    private int serves = 1;
    private String methodDescr;

    private Dish dish;
    private List<Ingredient> ingredients;

    public Recipe toRecipe() {
        return new Recipe(id, name, methodTime, restTime, serves, methodDescr, dish, ingredients);
    }
}
