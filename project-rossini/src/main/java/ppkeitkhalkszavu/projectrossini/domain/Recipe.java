package ppkeitkhalkszavu.projectrossini.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int methodTime;
    @Column(nullable = false)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int restTime = 0;
    @Column(nullable = false)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int serves = 1;
    @Column(nullable = false)
    private String methodDescr;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    @JsonBackReference
    private Dish dish;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ingredient> ingredients;
}
