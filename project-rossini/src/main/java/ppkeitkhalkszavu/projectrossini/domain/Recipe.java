package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int methodTime;
    @Column(nullable = false)
    private int restTime = 0;
    @Column(nullable = false)
    private int serves = 1;
    @Column(nullable = false)
    private String methodDescr;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
    @OneToMany
    @JoinColumn(name = "ingredient_id")
    private List<Ingredient> ingredients;
}
