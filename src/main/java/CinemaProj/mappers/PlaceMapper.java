package CinemaProj.mappers;

import CinemaProj.dtos.CinemaDto;
import CinemaProj.dtos.PlaceDto;
import CinemaProj.entite.Cinema;
import CinemaProj.entite.Place;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    SalleMapper salleMapper;





    public Place convertDtoToEntity (PlaceDto placeDto){
        Place place = dozerBeanMapper.map(placeDto,Place.class);
        if (place.getSalle()!=null) {
            place.setSalle(salleMapper.convertDtoToEntity(placeDto.getSalle()));
        }
        return place;
    }

    public PlaceDto convertEntityToDto(Place place){

        PlaceDto placeDto = dozerBeanMapper.map(place,PlaceDto.class);

        if (placeDto.getSalle()!=null){
            placeDto.setSalle(salleMapper.convertEntityToDto(place.getSalle()));
        }
        return placeDto;
    }



    public List<Place> convertDtoListToEntityList(List<PlaceDto>placeDtoList){
        List<Place> placeList = new ArrayList<>();
        placeDtoList.forEach(placeX->placeList.add(convertDtoToEntity(placeX)));
        return placeList;
    }



    public List<PlaceDto> convertEntityListToDtoList(List<Place>placeList){
        List<PlaceDto>placeDtoList =new ArrayList<>();
        placeList.forEach(placeX->placeDtoList.add(convertEntityToDto(placeX)));
        return placeDtoList;
    }





}
