package CinemaProj.service;

import CinemaProj.dtos.CategorieFilmDto;


import java.util.List;

public interface CategorieFilmService {

    CategorieFilmDto save(CategorieFilmDto categorieFilmDto);

    void delete(Long id);

    List<CategorieFilmDto> findAll();

    CategorieFilmDto update(CategorieFilmDto categorieFilmDto,Long id);




}
