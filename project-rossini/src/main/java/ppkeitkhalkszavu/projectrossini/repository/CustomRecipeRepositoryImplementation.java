package ppkeitkhalkszavu.projectrossini.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ppkeitkhalkszavu.projectrossini.controller.dto.RecipeDTO;
import ppkeitkhalkszavu.projectrossini.domain.Ingredient;
import ppkeitkhalkszavu.projectrossini.domain.Material;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class CustomRecipeRepositoryImplementation implements CustomRecipeRepository{

    private EntityManager entityManager;
    private final DishRepository dishRepository;
    private final MaterialRepository materialRepository;
    private final CustomMaterialRepository customMaterialRepository;
    private final CustomIngredientRepository customIngredientRepository;
    private final RecipeRepository recipeRepository;

    @Transactional
    @Override
    public Recipe save(int dishId, RecipeDTO recipeDTO) {
        Recipe recipe = recipeDTO.toSimpleRecipe(dishId, dishRepository);
        entityManager.persist(recipe);

        for (Ingredient i: recipeDTO.getIngredients()) {
            Material material;
            if(materialRepository.findByName(i.getMaterial().getName()).isEmpty())
                material = customMaterialRepository.save(i.getMaterial().getName(), i.getMaterial().getUnit());
            else
                material = materialRepository.findByName(i.getMaterial().getName()).get();

            i.setMaterial(material);
            i.setRecipe(recipe);

            customIngredientRepository.save(i);
        }

        return recipeRepository.findById(recipe.getId()).get();
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
