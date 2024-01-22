package CinemaProj.repository;

import CinemaProj.dtos.CategorieFilmDto;
import CinemaProj.entite.CategorieFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface CategorieFilmRepository extends JpaRepository<CategorieFilm,Long> {

}
