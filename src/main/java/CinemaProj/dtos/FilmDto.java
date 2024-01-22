package CinemaProj.dtos;

import CinemaProj.entite.CategorieFilm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FilmDto {

    private Long id;

    private String titre;

    private String description;

    private String realisateur;

    private Date dateSortie;

    private double duree;

    private String photo;

    private CategorieFilmDto categorieFilm;






}
