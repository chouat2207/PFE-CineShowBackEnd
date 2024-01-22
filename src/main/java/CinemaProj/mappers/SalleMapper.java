package CinemaProj.mappers;

import CinemaProj.dtos.CinemaDto;
import CinemaProj.dtos.SalleDto;
import CinemaProj.entite.Cinema;
import CinemaProj.entite.Salle;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SalleMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    CinemaAdminMapper cinemaAdminMapper;





    public Salle convertDtoToEntity (SalleDto salleDto){
        Salle salle = dozerBeanMapper.map(salleDto,Salle.class);
        if (salle.getCinema()!=null) {
            salle.setCinema(cinemaAdminMapper.convertDtoToEntity(salleDto.getCinema()));
        }
        return salle;
    }

    public SalleDto convertEntityToDto(Salle salle){

        SalleDto salleDto = dozerBeanMapper.map(salle,SalleDto.class);

        if (salleDto.getCinema()!=null){
            salleDto.setCinema(cinemaAdminMapper.convertEntityToDto(salle.getCinema()));
        }
        return salleDto;
    }



    public List<Salle> convertDtoListToEntityList(List<SalleDto>salleDtoList){
        List<Salle> salleList = new ArrayList<>();
        salleDtoList.forEach(A->salleList.add(convertDtoToEntity(A)));
        return salleList;
    }



    public List<SalleDto> convertEntityListToDtoList(List<Salle>salleList){
        List<SalleDto>salleDtoList =new ArrayList<>();
        salleList.forEach(A->salleDtoList.add(convertEntityToDto(A)));
        return salleDtoList;
    }






}
