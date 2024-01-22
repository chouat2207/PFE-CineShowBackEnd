package CinemaProj.service;

import CinemaProj.dtos.VilleDto;
import org.springframework.stereotype.Service;

import java.util.List;



public interface VilleService {

    VilleDto save(VilleDto villeDto);

    void  delete(Long id);

    List<VilleDto> findAll();

    VilleDto update(VilleDto villeDto, Long id);





}
