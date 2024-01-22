package CinemaProj.entite;

import org.springframework.data.rest.core.config.Projection;

//@Projection : est utilisée pour définir une projection. Une projection
// permet de spécifier les propriétés spécifiques d'une entité à inclure lorsqu'une requête est exécutée.
@Projection(name = "ticketProj",types = {CinemaProj.entite.Ticket.class})
public interface TicketProjection {

    public Long getId();
    public String getNomClient();
    public Double getPrix();
    public Integer getCodePayement();
    public Boolean getReservee();
    public Place getPlace();
}