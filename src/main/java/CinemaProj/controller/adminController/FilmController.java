package CinemaProj.controller.adminController;

import CinemaProj.dtos.FilmDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.service.CategorieFilmService;
import CinemaProj.service.FilmService;
import CinemaProj.service.serviceImplements.CategorieFilmImplement;
import CinemaProj.service.serviceImplements.FilmImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/FilmAdmin")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmImplement filmImplement) {this.filmService = filmImplement;}


    @PostMapping("/addFilm")
    public FilmDto addFilms(@RequestBody FilmDto filmDto){
        return filmService.save(filmDto);
    }


    @GetMapping("/GetFilm")
    public List<FilmDto> findFilm(){
        return filmService.findAll();
    }

    @DeleteMapping("/DeleteFilm/{id}")
    public void deleteFilm(@PathVariable("id") long id ){
        filmService.delete(id);
    }


    @PutMapping("/UpdateFilm/{id}")
    public FilmDto updateFilm(@PathVariable("id") Long id,@RequestBody FilmDto filmDto){
        return filmService.update(filmDto,id);
    }





}
