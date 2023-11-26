package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private float amount;
    @Column
    private String prepDescr;
    @Column
    private int prepTime;

    @ManyToOne
    private Material material;
}
