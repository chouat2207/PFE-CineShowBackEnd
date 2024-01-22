package CinemaProj.mappers;

import CinemaProj.dtos.CategorieFilmDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.entite.CategorieFilm;
import CinemaProj.entite.Ville;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CategorieFilmMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    public CategorieFilm convertDtoToEntity(CategorieFilmDto categorieFilmDto){
        CategorieFilm categorieFilm = dozerBeanMapper.map(categorieFilmDto,CategorieFilm.class);
        return categorieFilm;
    }

    public CategorieFilmDto convertEntityToDto(CategorieFilm categorieFilm){
        CategorieFilmDto categorieFilmDto = dozerBeanMapper.map(categorieFilm,CategorieFilmDto.class);
        return categorieFilmDto;
    }

    public List<CategorieFilm> convertListDtoToListEntity (List<CategorieFilmDto> categorieFilmDtoList){
        List<CategorieFilm>categorieFilmList = new ArrayList<>();
        categorieFilmDtoList.forEach(Fiction->categorieFilmList.add(convertDtoToEntity(Fiction)));
        return categorieFilmList;
    }

    public List<CategorieFilmDto> convertListEntityToListDto(List<CategorieFilm>categorieFilmList){
        List<CategorieFilmDto> categorieFilmDtoList= new ArrayList<>();
        categorieFilmList.forEach(Fiction->categorieFilmDtoList.add(convertEntityToDto(Fiction)));
        return categorieFilmDtoList;
    }

}
