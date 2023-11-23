package ppkeitkhalkszavu.projectrossini.domain;

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
