package CinemaProj.mappers;

import CinemaProj.dtos.SeanceDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.entite.Seance;
import CinemaProj.entite.Ville;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeanceMapper {


    @Autowired
    DozerBeanMapper dozerBeanMapper;



    public Seance convertDtoToEntity(SeanceDto seanceDto){
        Seance seance = dozerBeanMapper.map(seanceDto,Seance.class);
        return seance;

    }

    public SeanceDto convertEntityToDto(Seance seance){
        SeanceDto seanceDto = dozerBeanMapper.map(seance,SeanceDto.class);
        return seanceDto;
    }

    public List<Seance> convertListDtoToListEntity (List<SeanceDto> seanceDtoList){
        List<Seance>seanceList = new ArrayList<>();
        seanceDtoList.forEach(AAA->seanceList.add(convertDtoToEntity(AAA)));
        return seanceList;

    }
    public List<SeanceDto> convertListEntityToListDto(List<Seance>seanceList){
        List<SeanceDto> seanceDtoList= new ArrayList<>();
        seanceList.forEach(AAA->seanceDtoList.add(convertEntityToDto(AAA)));
        return seanceDtoList;
    }




}
