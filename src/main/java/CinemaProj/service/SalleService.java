package CinemaProj.service;

import CinemaProj.dtos.SalleDto;

import java.util.List;

public interface SalleService {


    SalleDto save(SalleDto salleDto);

    void delete(Long id);

    List<SalleDto> findAll();

    SalleDto update(SalleDto salleDto,Long id);




}
