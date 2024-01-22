package CinemaProj.dtos;

import CinemaProj.entite.Place;
import CinemaProj.entite.Projection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TicketDto {

    private Long id;

    private String nomClient;

    private double prix;

    private Integer codePayement;

    private boolean reservee;

    private PlaceDto place;

    private ProjectionDto projection;
}
