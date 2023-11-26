package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "materials")
public class Material {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private UnitOfMeasure unit;

    @OneToMany
    private List<Benefit> benefit;
}

enum UnitOfMeasure {
    GRAM,
    LITER,
    PIECE,
}
