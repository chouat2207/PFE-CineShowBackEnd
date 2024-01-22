package CinemaProj.mappers;

import CinemaProj.dtos.CinemaDto;
import CinemaProj.dtos.FilmDto;
import CinemaProj.entite.Cinema;
import CinemaProj.entite.Film;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class FilmMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    CategorieFilmMapper categorieFilmMapper;





    public Film convertDtoToEntity (FilmDto filmDto){
        Film film = dozerBeanMapper.map(filmDto,Film.class);
        if (film.getCategorieFilm()!=null) {
            film.setCategorieFilm(categorieFilmMapper.convertDtoToEntity(filmDto.getCategorieFilm()));
        }
        return film;
    }

    public FilmDto convertEntityToDto(Film film){

        FilmDto filmDto = dozerBeanMapper.map(film,FilmDto.class);

        if (filmDto.getCategorieFilm()!=null){
            filmDto.setCategorieFilm(categorieFilmMapper.convertEntityToDto(film.getCategorieFilm()));
        }
        return filmDto;
    }



    public List<Film> convertDtoListToEntityList(List<FilmDto>filmDtoList){
        List<Film> filmList = new ArrayList<>();
        filmDtoList.forEach(SpiderMan->filmList.add(convertDtoToEntity(SpiderMan)));
        return filmList;
    }



    public List<FilmDto> convertEntityListToDtoList(List<Film>filmList){
        List<FilmDto>filmDtoList =new ArrayList<>();
        filmList.forEach(SpiderMan->filmDtoList.add(convertEntityToDto(SpiderMan)));
        return filmDtoList;
    }



}
