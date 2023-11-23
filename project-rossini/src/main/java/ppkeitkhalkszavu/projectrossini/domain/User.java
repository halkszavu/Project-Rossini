package ppkeitkhalkszavu.projectrossini.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Role role;
}

enum Role {
    ADMIN,
    USER,
    CHEF,
    DIETITIAN,
}
