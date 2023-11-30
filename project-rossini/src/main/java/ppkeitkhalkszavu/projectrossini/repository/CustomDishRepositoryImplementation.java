package ppkeitkhalkszavu.projectrossini.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ppkeitkhalkszavu.projectrossini.domain.Dish;
import ppkeitkhalkszavu.projectrossini.domain.User;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomDishRepositoryImplementation implements CustomDishRepository{

    @PersistenceContext
    private EntityManager entityManager;
    private final UserRepository userRepository;
    private final DishRepository dishRepository;

    @Override
    @Transactional
    public Dish saveDish(String dishName, int userId) {

        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new NoSuchElementException("User with id " + userId + " not found");
        //Check if the dish already exists

        Optional<Dish> existingDish = entityManager.createQuery("SELECT d FROM Dish d WHERE d.name = :name", Dish.class)
                .setParameter("name", dishName)
                .getResultStream()
                .findFirst();
        if(existingDish.isPresent())
            return existingDish.get();
        else{
            Dish dish = new Dish();
            dish.setOwner(user.get());
            dish.setName(dishName);
            entityManager.persist(dish);
            return dish;
        }
    }

    @Override
    @Transactional
    public void deleteDish(int id) {
        Optional<Dish> dish = dishRepository.findById(id);
        if(dish.isEmpty())
            throw new NoSuchElementException("Dish with id " + id + " not found");
        entityManager.remove(dish.get());
    }
}
