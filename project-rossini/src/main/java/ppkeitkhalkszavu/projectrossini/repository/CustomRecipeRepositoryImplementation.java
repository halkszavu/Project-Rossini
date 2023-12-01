package ppkeitkhalkszavu.projectrossini.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ppkeitkhalkszavu.projectrossini.controller.dto.RecipeDTO;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class CustomRecipeRepositoryImplementation implements CustomRecipeRepository{

    private EntityManager entityManager;
    private DishRepository dishRepository;

    @Transactional
    @Override
    public Recipe save(int dishId, RecipeDTO recipeDTO) {
        Recipe recipe = recipeDTO.toRecipe(dishId, dishRepository);
        entityManager.persist(recipe);
        return recipe;
    }

    @Transactional
    @Override
    public Recipe modify(RecipeDTO recipeDTO) {
        Optional<Recipe> optionalRecipe = entityManager.createQuery("SELECT r FROM Recipe r WHERE r.id = :id", Recipe.class)
                .setParameter("id", recipeDTO.getId())
                .getResultStream()
                .findFirst();
        if(optionalRecipe.isEmpty())
            throw new IllegalArgumentException("Recipe with id " + recipeDTO.getId() + " not found");
        else{
            Recipe recipe = optionalRecipe.get();
            recipe.setName(recipeDTO.getName());
            recipe.setMethodTime(recipeDTO.getMethodTime());
            recipe.setRestTime(recipeDTO.getRestTime());
            recipe.setServes(recipeDTO.getServes());
            recipe.setMethodDescr(recipeDTO.getMethodDescr());
            recipe.setIngredients(recipeDTO.getIngredients());
            entityManager.persist(recipe);
            return recipe;
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
         Optional<Recipe> recipe = entityManager.createQuery("SELECT r FROM Recipe r WHERE r.id = :id", Recipe.class)
                    .setParameter("id", id)
                    .getResultStream()
                    .findFirst();

         if(recipe.isPresent())
             entityManager.remove(recipe.get());
    }
}
