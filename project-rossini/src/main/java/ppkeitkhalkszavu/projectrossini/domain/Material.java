package ppkeitkhalkszavu.projectrossini.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Material {
    private String id;
    private String name;
    private UnitOfMeasure unit;

    private Benefit benefit;
}

enum UnitOfMeasure {
    GRAM,
    LITER,
    PIECE,
}
