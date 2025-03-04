package CinemaProj.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class Ville implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 75)
    private String name;
    private double longitude,latitude,altitude;
    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private Collection<Cinema> cinemas;
}
