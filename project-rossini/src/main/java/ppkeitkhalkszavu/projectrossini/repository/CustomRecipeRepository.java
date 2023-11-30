package ppkeitkhalkszavu.projectrossini.repository;

import ppkeitkhalkszavu.projectrossini.controller.dto.RecipeDTO;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;

public interface CustomRecipeRepository {
    Recipe save(int ownerId, RecipeDTO recipeDTO);
    Recipe modify(RecipeDTO recipeDTO);
    void delete(int id);
}
