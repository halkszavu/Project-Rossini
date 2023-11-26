package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

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
    @Column
    private String name;
    @Column
    private int methodTime;
    @Column
    private int restTime;
    @Column
    private int serves;
    @Column
    private String methodDescr;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
}
