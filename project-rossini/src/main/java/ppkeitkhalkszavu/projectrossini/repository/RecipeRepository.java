package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppkeitkhalkszavu.projectrossini.domain.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findAllByName(String recipeName);
    Optional<Recipe> findById(int id);
}
