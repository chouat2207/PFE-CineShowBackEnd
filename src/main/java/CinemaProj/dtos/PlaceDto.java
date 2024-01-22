package CinemaProj.dtos;

import CinemaProj.entite.Salle;
import CinemaProj.entite.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PlaceDto {

    private Long id;

    private int numero;

    private double longitude,latitude,altitude;

    private SalleDto salle;


}
