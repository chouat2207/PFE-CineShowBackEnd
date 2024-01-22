package CinemaProj.controller.adminController;

import CinemaProj.dtos.TicketDto;
import CinemaProj.dtos.VilleDto;
import CinemaProj.service.SeanceService;
import CinemaProj.service.TicketService;
import CinemaProj.service.serviceImplements.SeanceImplement;
import CinemaProj.service.serviceImplements.TicketImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/TicketAdmin")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketImplement ticketImplement) {this.ticketService = ticketImplement;}


    @PostMapping("/addTicket")
    public TicketDto addTickets(@RequestBody TicketDto ticketDto){
        return ticketService.save(ticketDto);
    }


    @GetMapping("/GetTicket")
    public List<TicketDto> findTicket(){
        return ticketService.findAll();
    }

    @DeleteMapping("/DeleteTicket/{id}")
    public void deleteTicket(@PathVariable("id") long id ){
        ticketService.delete(id);
    }


    @PutMapping("/UpdateTicket/{id}")
    public TicketDto updateTicket(@PathVariable("id") Long id,@RequestBody TicketDto ticketDto){
        return ticketService.update(ticketDto,id);
    }



}
