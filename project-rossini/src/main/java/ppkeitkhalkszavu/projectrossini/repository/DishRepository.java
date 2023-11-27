package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppkeitkhalkszavu.projectrossini.domain.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    
}
