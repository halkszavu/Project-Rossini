package ppkeitkhalkszavu.projectrossini.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ppkeitkhalkszavu.projectrossini.domain.Ingredient;

import java.util.List;

@RestController
@Tag(name = "Grocery")
@Slf4j
public class GroceryController {

    @Operation(summary = "Get grocery list for a given dish by dish id")
    @GetMapping("/grocery/dish/{dishId}")
    public List<Ingredient> getGroceryList(int dishId){
        return null;
    }

    @Operation(summary = "Get grocery list for a given recipe by recipe id")
    @GetMapping("/grocery/recipe/{recipeId}")
    public List<Ingredient> getGroceryListByRecipe(int recipeId){
        return null;
    }
}
