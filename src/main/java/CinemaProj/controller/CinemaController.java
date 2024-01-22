package CinemaProj.controller;

import CinemaProj.entite.Film;
import CinemaProj.entite.Ticket;
import CinemaProj.repository.FilmRepository;
import CinemaProj.repository.TicketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")

public class CinemaController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;


    @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name = "id") Long id) throws Exception {
        // Récupérer l'objet Film depuis le référentiel en fonction de l'ID fourni
        Film f=filmRepository.findById(id).get();

        // Obtenir le nom de la photo depuis l'objet Film
        String photoName= f.getPhoto();

        // Créer un objet File représentant l'emplacement du fichier image
        File file= new File(System.getProperty("user.home")+"/Desktop/projet_fin_d'etude/FULLSTACKCINE/images/"+photoName);

        // Obtenir l'objet Path à partir du fichier et convertit ensuite l'objet File en un objet Path
        Path path= Paths.get(file.toURI());

        // Lire les octets du fichier image et les renvoyer comme réponse
        return Files.readAllBytes(path);
    }

//    L'objet Path en Java est une interface du package java.nio.file qui représente un chemin système de fichiers.
//    Elle est utilisée pour manipuler des chemins de fichiers et de
//    répertoires de manière indépendante du système d'exploitation, ce qui la rend portable entre les différents environnements.

    @PostMapping("/payerTickets")
//    @Transactional: Cette annotation indique que la méthode est exécutée dans une transaction. Si une exception se produit,
//    la transaction sera annulée , et les modifications apportées à la base de données seront annulées (rollback).
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){

        List<Ticket> ticketList=new ArrayList<>();

        // Pour chaque ID de ticket fourni dans ticketForm
        ticketForm.getTickets().forEach(idTicket->{
            //System.out.println(idTicket);
            // Récupérer le ticket à partir de la base de données en utilisant l'ID
            Ticket ticket=ticketRepository.findById(idTicket).get();

            // Mettre à jour les détails du ticket avec les informations du formulaire
            ticket.setNomClient(ticketForm.getNomClient());
            ticket.setReservee(true);
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticketRepository.save(ticket);
            ticketList.add(ticket);
        });
        return ticketList;

    }
    @GetMapping("/getTicket")
    public Ticket getTickets(){

        return this.ticketRepository.findById(Long.valueOf(5639)).get();
    }

}
@Data
class TicketForm{
    private String nomClient;
    private int codePayement;
    private  List<Long> tickets=new ArrayList<>();
}
