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
    @Column
    private String name;
    @Column
    private String role;
}
