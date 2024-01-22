package CinemaProj.controller.adminController;

import CinemaProj.dtos.SeanceDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.service.SalleService;
import CinemaProj.service.SeanceService;
import CinemaProj.service.serviceImplements.SalleImplement;
import CinemaProj.service.serviceImplements.SeanceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/SeanceAdmin")
public class SeanceController {

    private final SeanceService seanceService;

    @Autowired
    public SeanceController(SeanceImplement seanceImplement) {this.seanceService = seanceImplement;}


    @PostMapping("/addSeance")
    public SeanceDto addSeances(@RequestBody SeanceDto seanceDto){
        return seanceService.save(seanceDto);
    }


    @GetMapping("/GetSeance")
    public List<SeanceDto> findSeance(){
        return seanceService.findAll();
    }

    @DeleteMapping("/DeleteSeance/{id}")
    public void deleteSeance(@PathVariable("id") long id ){
        seanceService.delete(id);
    }


    @PutMapping("/UpdateSeance/{id}")
    public SeanceDto updateSeance(@PathVariable("id") Long id,@RequestBody SeanceDto seanceDto){
        return seanceService.update(seanceDto,id);
    }



}
