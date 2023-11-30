package ppkeitkhalkszavu.projectrossini.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private int id;
    @Column(nullable = false)
    private String effect;
}
