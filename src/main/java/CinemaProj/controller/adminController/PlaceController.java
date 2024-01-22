package CinemaProj.controller.adminController;

import CinemaProj.dtos.PlaceDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.service.FilmService;
import CinemaProj.service.PlaceService;
import CinemaProj.service.serviceImplements.FilmImplement;
import CinemaProj.service.serviceImplements.PlaceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/PlaceAdmin")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceImplement placeImplement) {this.placeService = placeImplement;}


    @PostMapping("/addPlace")
    public PlaceDto addPlaces(@RequestBody PlaceDto placeDto){
        return placeService.save(placeDto);
    }


    @GetMapping("/GetPlace")
    public List<PlaceDto> findPlace(){
        return placeService.findAll();
    }

    @DeleteMapping("/DeletePlace/{id}")
    public void deletePlace(@PathVariable("id") long id ){
        placeService.delete(id);
    }


    @PutMapping("/UpdatePlace/{id}")
    public PlaceDto updatePlace(@PathVariable("id") Long id,@RequestBody PlaceDto placeDto){
        return placeService.update(placeDto,id);
    }





}
