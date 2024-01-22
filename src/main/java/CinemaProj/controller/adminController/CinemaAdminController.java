package CinemaProj.controller.adminController;


import CinemaProj.dtos.CinemaDto;
import CinemaProj.service.CinemaAdminService;
import CinemaProj.service.serviceImplements.CinemaAdminImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/CinemaAdmin")
public class CinemaAdminController {

    private final CinemaAdminService cinemaAdminService;

    @Autowired
    public CinemaAdminController(CinemaAdminImplement cinemaAdminImplement) {this.cinemaAdminService = cinemaAdminImplement;}


    @PostMapping("/addCinema")
    public CinemaDto addCinemas(@RequestBody CinemaDto cinemaDto){
        return cinemaAdminService.save(cinemaDto);
    }


    @GetMapping("/GetCinema")
    public List<CinemaDto> findCinema(){
        return cinemaAdminService.findAll();
    }

    @DeleteMapping("/DeleteCinema/{id}")
    public void deleteCinema(@PathVariable("id") long id ){
        cinemaAdminService.delete(id);
    }


    @PutMapping("/UpdateCinema/{id}")
    public CinemaDto updateCinema(@PathVariable("id") Long id,@RequestBody CinemaDto cinemaDto){
        return cinemaAdminService.update(cinemaDto,id);
    }





}
