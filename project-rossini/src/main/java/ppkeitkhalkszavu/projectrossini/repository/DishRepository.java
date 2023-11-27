package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ppkeitkhalkszavu.projectrossini.domain.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    Page<Dish> findAll(Pageable pageable);
}
