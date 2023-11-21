package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.stereotype.Repository;
import ppkeitkhalkszavu.projectrossini.domain.Dish;

import java.util.List;

@Repository
public class DishRepository {

    public List<Dish> getDishes() {
        return List.of(
            new Dish("1", "Pizza"),
            new Dish("2", "Pasta"),
            new Dish("3", "Salad")
        );
    }
}
