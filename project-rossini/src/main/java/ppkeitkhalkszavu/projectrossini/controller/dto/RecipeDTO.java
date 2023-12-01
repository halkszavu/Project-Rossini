package ppkeitkhalkszavu.projectrossini.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppkeitkhalkszavu.projectrossini.domain.Dish;
import ppkeitkhalkszavu.projectrossini.domain.Ingredient;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;
import ppkeitkhalkszavu.projectrossini.repository.DishRepository;

import java.util.List;
import java.util.Optional;

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

    private List<Ingredient> ingredients;

    public Recipe toRecipe(int dishId, DishRepository dishRepository) throws IllegalArgumentException {
        Optional<Dish> d = dishRepository.findById(dishId);
        if(d.isPresent())
            return new Recipe(id, name, methodTime, restTime, serves, methodDescr, d.get(), ingredients);
        else
            throw new IllegalArgumentException("Invalid dish id supplied");
    }

    public Recipe toSimpleRecipe(int dishId, DishRepository dishRepository) throws IllegalArgumentException {
        Optional<Dish> d = dishRepository.findById(dishId);
        if(d.isPresent())
            return new Recipe(id, name, methodTime, restTime, serves, methodDescr, d.get(), null);
        else
            throw new IllegalArgumentException("Invalid dish id supplied");
    }
}
