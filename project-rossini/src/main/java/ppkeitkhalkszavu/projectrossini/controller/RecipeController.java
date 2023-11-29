package ppkeitkhalkszavu.projectrossini.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;
import ppkeitkhalkszavu.projectrossini.repository.RecipeRepository;

import java.util.List;

@RestController
@Tag(name = "Recipe")
@Slf4j
@RequestMapping(value = "/recipes", produces = "application/json")
public class RecipeController {

    RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
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
}
