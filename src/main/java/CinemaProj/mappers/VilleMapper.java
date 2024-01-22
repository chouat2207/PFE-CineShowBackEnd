package CinemaProj.mappers;

import CinemaProj.dtos.VilleDto;
import CinemaProj.entite.Ville;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component

public class VilleMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;






    public Ville convertDtoToEntity(VilleDto villeDto){
        Ville ville = dozerBeanMapper.map(villeDto,Ville.class);
        return ville;

    }

    public VilleDto convertEntityToDto(Ville ville){
        VilleDto villeDto = dozerBeanMapper.map(ville,VilleDto.class);
        return villeDto;
    }

    public List<Ville> convertListDtoToListEntity (List<VilleDto> villeDtoList){
        List<Ville>villeList = new ArrayList<>();
        villeDtoList.forEach(Agadir->villeList.add(convertDtoToEntity(Agadir)));
        return villeList;

    }
    public List<VilleDto> convertListEntityToListDto(List<Ville>villeList){
        List<VilleDto> villeDtoList= new ArrayList<>();
        villeList.forEach(Agadir->villeDtoList.add(convertEntityToDto(Agadir)));
        return villeDtoList;
    }



}
