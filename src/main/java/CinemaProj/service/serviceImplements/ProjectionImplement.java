package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.ProjectionDto;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.mappers.ProjectionMapper;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.repository.ProjectionRepository;
import CinemaProj.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionImplement implements ProjectionService {

    @Autowired
    ProjectionRepository projectionRepository;

    @Autowired
    ProjectionMapper projectionMapper;


    @Override
    public ProjectionDto save(ProjectionDto projectionDto) {
        return projectionMapper.convertEntityToDto(projectionRepository.save(projectionMapper.convertDtoToEntity(projectionDto)));

    }

    @Override
    public void delete(Long id) {
        boolean exists = projectionRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        projectionRepository.deleteById(id);

    }

    @Override
    public List<ProjectionDto> findAll() {
        return projectionMapper.convertEntityListToDtoList(projectionRepository.findAll());
    }

    @Override
    public ProjectionDto update(ProjectionDto projectionDto, Long id) {
        boolean exists = projectionRepository.existsById(id);
        if (exists){
            save(projectionDto);
        }


        return projectionDto;
    }
}
