package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

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
    @Column
    private Boolean isSubstitue;

    @ManyToOne
    private Material material;
}
