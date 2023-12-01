package ppkeitkhalkszavu.projectrossini.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ppkeitkhalkszavu.projectrossini.controller.dto.RecipeDTO;
import ppkeitkhalkszavu.projectrossini.domain.Dish;
import ppkeitkhalkszavu.projectrossini.domain.Ingredient;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;
import ppkeitkhalkszavu.projectrossini.repository.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Recipe")
@Slf4j
@RequestMapping(value = "/recipes", produces = "application/json")
public class RecipeController {

    RecipeRepository recipeRepository;
    CustomRecipeRepository customRecipeRepository;
    DishRepository dishRepository;
    UserRepository userRepository;
    MaterialRepository materialRepository;
    CustomMaterialRepository customMaterialRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository, CustomRecipeRepository customRecipeRepository, DishRepository dishRepository, UserRepository userRepository, MaterialRepository materialRepository, CustomMaterialRepository customMaterialRepository) {
        this.recipeRepository = recipeRepository;
        this.customRecipeRepository = customRecipeRepository;
        this.dishRepository = dishRepository;
        this.userRepository = userRepository;
        this.materialRepository = materialRepository;
        this.customMaterialRepository = customMaterialRepository;
    }

    @Operation(summary = "Get the recipes that match the name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found recipes"),
            @ApiResponse(responseCode = "400", description = "Invalid url parameters supplied"),
    })
    @GetMapping("/name/{name}")
    @ResponseBody
    public List<Recipe> getRecipeByName(@PathVariable("name") String name) {
        log.info("Calling GET /recipes/name/{} endpoint", name);

        return recipeRepository.findAllByName(name);
    }

    @Operation(summary = "Get a recipe by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the recipe"),
            @ApiResponse(responseCode = "400", description = "Invalid url parameters supplied"),
    })
    @GetMapping("/{id}")
    @ResponseBody
    public Recipe getRecipeById(@PathVariable("id") Integer id) {
        log.info("Calling GET /recipes/{} endpoint", id);

        return recipeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid recipe id supplied"));
    }

    @Operation(summary = "Create a new recipe with a given user as owner and dish, which it belongs to")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the recipe"),
            @ApiResponse(responseCode = "400", description = "Invalid url parameters supplied"),
    })
    @PutMapping("/dish={dishId}")
    @ResponseBody
    public Recipe createRecipe(@PathVariable("dishId") Integer dishId, @RequestBody RecipeDTO recipeDto) {
        log.info("Calling PUT /recipes endpoint");

        Optional<Dish> d = dishRepository.findById(dishId);
        if(d.isEmpty())
            throw new IllegalArgumentException("Invalid dish id supplied");

        for (Ingredient i: recipeDto.getIngredients()) {
            if(materialRepository.findByName(i.getMaterial().getName()).isEmpty())
                customMaterialRepository.save(i.getMaterial().getName(), i.getMaterial().getUnit());
        }


        return recipeRepository.save(recipeDto.toRecipe(dishId, dishRepository));
    }

    @Operation(summary = "Delete a recipe by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the recipe"),
            @ApiResponse(responseCode = "400", description = "Invalid url parameters supplied"),
    })
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteRecipeById(@PathVariable("id") Integer id) {
        log.info("Calling DELETE /recipes/{} endpoint", id);

        customRecipeRepository.delete(id);
    }

    @Operation(summary = "Update a recipe by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the recipe"),
            @ApiResponse(responseCode = "400", description = "Invalid url parameters supplied"),
    })
    @PostMapping("/{id}")
    @ResponseBody
    public Recipe updateRecipeById(@PathVariable("id") Integer id, @RequestBody RecipeDTO recipeDto) {
        log.info("Calling POST /recipes/{} endpoint", id);

        Recipe recipe = customRecipeRepository.modify(recipeDto);

        return recipe;
    }
}
