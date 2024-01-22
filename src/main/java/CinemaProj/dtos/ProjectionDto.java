package CinemaProj.dtos;

import CinemaProj.entite.Film;
import CinemaProj.entite.Salle;
import CinemaProj.entite.Seance;
import CinemaProj.entite.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class ProjectionDto {

    private Long id;
    private Date dateProjection;

    private double prix;

    private SalleDto salle;

    private FilmDto film;

    private SeanceDto seance;
}
