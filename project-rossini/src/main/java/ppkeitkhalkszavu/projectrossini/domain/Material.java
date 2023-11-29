package ppkeitkhalkszavu.projectrossini.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unit = UnitOfMeasure.PIECE;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany
    private List<Benefit> benefit;
}

enum UnitOfMeasure {
    GRAM,
    LITRE,
    PIECE,
}
