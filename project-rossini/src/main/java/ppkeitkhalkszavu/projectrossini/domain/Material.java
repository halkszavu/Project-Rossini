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
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unit = UnitOfMeasure.PIECE;

    @OneToMany
    private List<Benefit> benefit;
}

enum UnitOfMeasure {
    GRAM,
    LITRE,
    PIECE,
}
