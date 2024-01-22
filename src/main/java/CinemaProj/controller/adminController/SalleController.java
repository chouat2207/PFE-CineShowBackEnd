package CinemaProj.controller.adminController;

import CinemaProj.dtos.SalleDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.service.ProjectionService;
import CinemaProj.service.SalleService;
import CinemaProj.service.serviceImplements.ProjectionImplement;
import CinemaProj.service.serviceImplements.SalleImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/SalleAdmin")
public class SalleController {

    private final SalleService salleService;

    @Autowired
    public SalleController(SalleImplement salleImplement) {this.salleService = salleImplement;}


    @PostMapping("/addSalle")
    public SalleDto addSalles(@RequestBody SalleDto salleDto){
        return salleService.save(salleDto);
    }


    @GetMapping("/GetSalle")
    public List<SalleDto> findSalle(){
        return salleService.findAll();
    }

    @DeleteMapping("/DeleteSalle/{id}")
    public void deleteSalle(@PathVariable("id") long id ){
        salleService.delete(id);
    }


    @PutMapping("/UpdateSalle/{id}")
    public SalleDto updateSalle(@PathVariable("id") Long id,@RequestBody SalleDto salleDto){
        return salleService.update(salleDto,id);
    }




}
