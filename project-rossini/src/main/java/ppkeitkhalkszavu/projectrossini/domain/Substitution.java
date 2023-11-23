package ppkeitkhalkszavu.projectrossini.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Substitution {
    private String id;
    private Ingredient source;
    private Ingredient substitute;
}
