package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    private int id;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
}
