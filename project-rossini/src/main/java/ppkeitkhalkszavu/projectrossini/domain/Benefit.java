package ppkeitkhalkszavu.projectrossini.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "benefits")
public class Benefit {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String effect;
}
