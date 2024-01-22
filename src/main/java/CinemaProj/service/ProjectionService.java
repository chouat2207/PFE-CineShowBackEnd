package CinemaProj.service;


import CinemaProj.dtos.ProjectionDto;

import java.util.List;

public interface ProjectionService {


    ProjectionDto save(ProjectionDto projectionDto);

    void delete(Long id);

    List<ProjectionDto> findAll();

    ProjectionDto update(ProjectionDto projectionDto,Long id);


}
