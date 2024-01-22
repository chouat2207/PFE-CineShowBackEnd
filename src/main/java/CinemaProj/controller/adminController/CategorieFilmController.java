package CinemaProj.controller.adminController;

import CinemaProj.dtos.CategorieFilmDto;
import CinemaProj.service.CategorieFilmService;
import CinemaProj.service.serviceImplements.CategorieFilmImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/CategorieFilmAdmin")
public class CategorieFilmController {

    private final CategorieFilmService categorieFilmService;

    @Autowired
    public CategorieFilmController(CategorieFilmImplement categorieFilmImplement) {this.categorieFilmService = categorieFilmImplement;}


    @PostMapping("/addCategorieFilm")
    public CategorieFilmDto addCategorieFilms(@RequestBody CategorieFilmDto categorieFilmDto){
        return categorieFilmService.save(categorieFilmDto);
    }


    @GetMapping("/GetCategorieFilm")
    public List<CategorieFilmDto> findCategorieFilm(){
        return categorieFilmService.findAll();
    }

    @DeleteMapping("/DeleteCategorieFilm/{id}")
    public void deleteCategorieFilm(@PathVariable("id") long id ){
        categorieFilmService.delete(id);
    }


    @PutMapping("/UpdateCategorieFilm/{id}")
    public CategorieFilmDto updateCategorieFilm(@PathVariable("id") Long id,@RequestBody CategorieFilmDto categorieFilmDto){
        return categorieFilmService.update(categorieFilmDto,id);
    }







}
