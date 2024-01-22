package CinemaProj.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(length = 75)
    private String nomClient;
    private double prix;
    @Column(unique = false,nullable = true)
    private Integer codePayement;
    private boolean reservee;
    @ManyToOne(cascade = CascadeType.ALL)
    private Place place;
    @ManyToOne(cascade = CascadeType.ALL)
    private Projection projection;
}
