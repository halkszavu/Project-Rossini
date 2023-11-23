package ppkeitkhalkszavu.projectrossini.domain;

import lombok.Data;

@Data
public class Recipe {
    private String id;
    private String name;
    private int methodTime;
    private int restTime;
    private int serves;
    private String methodDescr;

    private User owner;
    private Dish dish;
}
