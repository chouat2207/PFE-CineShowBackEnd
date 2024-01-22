package CinemaProj.controller.adminController;


import CinemaProj.dtos.CinemaDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.service.CinemaAdminService;
import CinemaProj.service.VilleService;
import CinemaProj.service.serviceImplements.CinemaAdminImplement;
import CinemaProj.service.serviceImplements.VilleServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/VilleAdmin")

public class VilleAdminController {

    private final VilleService villeService;

    @Autowired
    public VilleAdminController(VilleServiceImplement villeServiceImplement) {this.villeService = villeServiceImplement;}


    @PostMapping("/addVille")
    public VilleDto addVilles(@RequestBody VilleDto villeDto){
        return villeService.save(villeDto);
    }


    @GetMapping("/GetVille")
    public List<VilleDto> findVille(){
        return villeService.findAll();
    }

    @DeleteMapping("/DeleteVille/{id}")
    public void deleteVille(@PathVariable("id") long id ){
        villeService.delete(id);
    }


    @PutMapping("/UpdateVille/{id}")
    public VilleDto updateVille(@PathVariable("id") Long id,@RequestBody VilleDto villeDto){
        return villeService.update(villeDto,id);
    }





}
