package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "materials")
public class Material {
    @Id
    @GeneratedValue
    private String id;
    @Column
    private String name;
    @Column
    private UnitOfMeasure unit;

    @OneToMany
    private Benefit benefit;
}

enum UnitOfMeasure {
    GRAM,
    LITER,
    PIECE,
}
