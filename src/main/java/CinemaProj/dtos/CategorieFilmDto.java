package CinemaProj.dtos;

import CinemaProj.entite.CategorieFilm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CategorieFilmDto {

    private Long id;

    private String name;




}
