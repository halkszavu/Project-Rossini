package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.stereotype.Repository;
import ppkeitkhalkszavu.projectrossini.domain.Dish;
import ppkeitkhalkszavu.projectrossini.domain.User;

import java.util.List;

@Repository
public class MockDishRepository {

    User owner = new User(1, "John", "admin");

    public List<Dish> getDishes() {
        return List.of(
            new Dish(1, "Pizza", owner),
            new Dish(2, "Pasta", owner),
            new Dish(3, "Salad", owner)
        );
    }
}
