package CinemaProj.mappers;

import CinemaProj.dtos.ProjectionDto;
import CinemaProj.entite.Projection;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectionMapper {



    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    SalleMapper salleMapper;

    @Autowired
    FilmMapper filmMapper;

    @Autowired
    SeanceMapper seanceMapper;


    public Projection convertDtoToEntity(ProjectionDto projectionDto){
        Projection projection = dozerBeanMapper.map(projectionDto,Projection.class);
        if (projection.getSalle() != null && projection.getFilm() != null && projection.getSeance() != null ){

            projection.setSalle(salleMapper.convertDtoToEntity(projectionDto.getSalle()));
            projection.setFilm(filmMapper.convertDtoToEntity(projectionDto.getFilm()));
            projection.setSeance(seanceMapper.convertDtoToEntity(projectionDto.getSeance()));
        }
        return projection;
    }



    public ProjectionDto convertEntityToDto(Projection projection){
        ProjectionDto projectionDto = dozerBeanMapper.map(projection,ProjectionDto.class);
        if (projectionDto.getSalle() != null && projectionDto.getFilm() != null && projectionDto.getSeance() != null ){

            projectionDto.setSalle(salleMapper.convertEntityToDto(projection.getSalle()));
            projectionDto.setFilm(filmMapper.convertEntityToDto(projection.getFilm()));
            projectionDto.setSeance(seanceMapper.convertEntityToDto(projection.getSeance()));
        }
        return projectionDto;
    }


    public List<Projection> convertDtoListToEntityList(List<ProjectionDto> projectionDtoList){
        List<Projection> projectionList = new ArrayList<>();
        projectionDtoList.forEach(projectionX->projectionList.add(convertDtoToEntity(projectionX)));
        return projectionList;
    }


    public List<ProjectionDto> convertEntityListToDtoList(List<Projection> projectionList) {
        List<ProjectionDto> projectionDtoList = new ArrayList<>();
        projectionList.forEach(projectionX -> projectionDtoList.add(convertEntityToDto(projectionX)));
        return projectionDtoList;
    }

















}
