package CinemaProj.service;

import CinemaProj.dtos.PlaceDto;

import java.util.List;

public interface PlaceService {

    PlaceDto save(PlaceDto placeDto);

    void delete(Long id);

    List<PlaceDto> findAll();

    PlaceDto update(PlaceDto placeDto,Long id);


}
