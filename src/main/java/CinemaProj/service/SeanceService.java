package CinemaProj.service;


import CinemaProj.dtos.SeanceDto;

import java.util.List;

public interface SeanceService {

    SeanceDto save(SeanceDto seanceDto);

    void delete(Long id);

    List<SeanceDto> findAll();

    SeanceDto update(SeanceDto seanceDto,Long id);







}
