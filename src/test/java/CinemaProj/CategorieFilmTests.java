package CinemaProj;

import CinemaProj.controller.adminController.CategorieFilmController;
import CinemaProj.dtos.CategorieFilmDto;
import CinemaProj.service.CategorieFilmService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CategorieFilmTests {

    @Autowired

    CategorieFilmController categorieFilmController;
    @Autowired
    CategorieFilmService categorieFilmService;

    @Test
    void contextLoads() {
    }


    @Test
    public void updateCategorieFilmTest() {
        CategorieFilmDto categorieFilm = new CategorieFilmDto(null, "Comedie");
        CategorieFilmDto categorieFilm1 = categorieFilmService.save(categorieFilm);
        categorieFilm1.setName("Action");
        categorieFilmService.update(categorieFilm1, categorieFilm1.getId());
        Assert.assertEquals(categorieFilm1.getName(), "Action");
    }
    @Test
    public void addCategorieFilmTest() {
        CategorieFilmDto categorieFilm = new CategorieFilmDto(null, "Comedie");
        CategorieFilmDto categorieFilm1 = categorieFilmService.save(categorieFilm);
        List<CategorieFilmDto> categorieFilms = categorieFilmController.findCategorieFilm();
        Assert.assertTrue(categorieFilms.contains(categorieFilm1));
    }
    @Test
    public void deleteCategorieFilmTest() {
        CategorieFilmDto categorieFilm = new CategorieFilmDto(null, "Comedie");
        CategorieFilmDto categorieFilm1 = categorieFilmService.save(categorieFilm);
        categorieFilmController.deleteCategorieFilm(categorieFilm1.getId());
        List<CategorieFilmDto> categorieFilms = categorieFilmController.findCategorieFilm();
        Assert.assertFalse(categorieFilms.contains(categorieFilm1));
    }
    @Test
    public void findCategorieFilmTest(){
        List<CategorieFilmDto> categorieFilms = categorieFilmController.findCategorieFilm();
        Assert.assertNotNull(categorieFilms);
    }
}
