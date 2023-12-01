package ppkeitkhalkszavu.projectrossini.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ppkeitkhalkszavu.projectrossini.domain.Ingredient;

@Repository
@RequiredArgsConstructor
public class CustomIngredientRepositoryImplementation implements CustomIngredientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ingredient save(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return ingredient;
    }
}
