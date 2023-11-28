package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String role = "ROLE_USER";
}
