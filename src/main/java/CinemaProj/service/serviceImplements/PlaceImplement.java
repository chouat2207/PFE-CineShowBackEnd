package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.PlaceDto;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.mappers.PlaceMapper;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.repository.PlaceRepository;
import CinemaProj.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceImplement implements PlaceService {


    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceMapper placeMapper;

    @Override
    public PlaceDto save(PlaceDto placeDto) {

        return placeMapper.convertEntityToDto(placeRepository.save(placeMapper.convertDtoToEntity(placeDto)));
    }

    @Override
    public void delete(Long id) {

        boolean exists = placeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        placeRepository.deleteById(id);


    }

    @Override
    public List<PlaceDto> findAll() {

        return placeMapper.convertEntityListToDtoList(placeRepository.findAll());
    }

    @Override
    public PlaceDto update(PlaceDto placeDto, Long id) {
        boolean exists = placeRepository.existsById(id);
        if (exists){
            save(placeDto);
        }


        return placeDto;
    }
}
