package CinemaProj.service;

import CinemaProj.dtos.CinemaDto;
import CinemaProj.entite.Film;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CinemaAdminService {

   CinemaDto save(CinemaDto cinemaDto);

   void delete(Long id);

   List<CinemaDto> findAll();

   CinemaDto update(CinemaDto cinemaDto,Long id);


}
