package CinemaProj.dtos;

import CinemaProj.entite.Cinema;
import CinemaProj.entite.Place;
import CinemaProj.entite.Projection;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SalleDto {

    private Long id;

    private String name;

    private int nombrePlace;

    private CinemaDto cinema;



}
