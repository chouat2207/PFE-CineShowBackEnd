package CinemaProj.mappers;

import CinemaProj.dtos.CinemaDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.entite.Cinema;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class CinemaAdminMapper {
    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    VilleMapper villeMapper;





    public Cinema convertDtoToEntity (CinemaDto cinemaDto){
        Cinema cinema = dozerBeanMapper.map(cinemaDto,Cinema.class);
        if (cinema.getVille()!=null) {
            cinema.setVille(villeMapper.convertDtoToEntity(cinemaDto.getVille()));
        }
        return cinema;
    }

    public CinemaDto convertEntityToDto(Cinema cinema){

        CinemaDto cinemaDto = dozerBeanMapper.map(cinema,CinemaDto.class);

        if (cinemaDto.getVille()!=null){
            cinemaDto.setVille(villeMapper.convertEntityToDto(cinema.getVille()));
        }
        return cinemaDto;
    }



    public List<Cinema> convertDtoListToEntityList(List<CinemaDto>cinemaDtoList){
        List<Cinema> cinemaList = new ArrayList<>();
        cinemaDtoList.forEach(Chahrazad->cinemaList.add(convertDtoToEntity(Chahrazad)));
        return cinemaList;
    }



    public List<CinemaDto> convertEntityListToDtoList(List<Cinema>cinemaList){
        List<CinemaDto>cinemaDtoList =new ArrayList<>();
        cinemaList.forEach(Chahrazad->cinemaDtoList.add(convertEntityToDto(Chahrazad)));
        return cinemaDtoList;
    }








}
