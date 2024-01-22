package CinemaProj.service;

import CinemaProj.dtos.FilmDto;

import java.util.List;

public interface FilmService {

    FilmDto save(FilmDto filmDto);

    void delete(Long id);

    List<FilmDto> findAll();

    FilmDto update(FilmDto filmDto,Long id);



}
