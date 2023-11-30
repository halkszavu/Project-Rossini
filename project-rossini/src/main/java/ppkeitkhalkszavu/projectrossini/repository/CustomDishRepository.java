package ppkeitkhalkszavu.projectrossini.repository;

import ppkeitkhalkszavu.projectrossini.domain.Dish;

public interface CustomDishRepository {
    Dish saveDish(String dishName, int userId);
    void deleteDish(int id);
}
