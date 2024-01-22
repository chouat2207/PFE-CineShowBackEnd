package CinemaProj.controller.adminController;

import CinemaProj.dtos.ProjectionDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.service.PlaceService;
import CinemaProj.service.ProjectionService;
import CinemaProj.service.serviceImplements.PlaceImplement;
import CinemaProj.service.serviceImplements.ProjectionImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/ProjectionAdmin")
public class ProjectionController {

    private final ProjectionService projectionService;

    @Autowired
    public ProjectionController(ProjectionImplement projectionImplement) {this.projectionService = projectionImplement;}



    @PostMapping("/addProjection")
    public ProjectionDto addProjections(@RequestBody ProjectionDto projectionDto){
        return projectionService.save(projectionDto);
    }


    @GetMapping("/GetProjection")
    public List<ProjectionDto> findProjection(){
        return projectionService.findAll();
    }

    @DeleteMapping("/DeleteProjection/{id}")
    public void deleteProjection(@PathVariable("id") long id ){
        projectionService.delete(id);
    }


    @PutMapping("/UpdateProjection/{id}")
    public ProjectionDto updateProjection(@PathVariable("id") Long id,@RequestBody ProjectionDto projectionDto){
        return projectionService.update(projectionDto,id);
    }


}
