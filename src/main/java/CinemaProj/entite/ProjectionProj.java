package CinemaProj.entite;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;
//@Projection : est utilisée pour définir une projection. Une projection
// permet de spécifier les propriétés spécifiques d'une entité à inclure lorsqu'une requête est exécutée.
@Projection(name = "p1", types = {CinemaProj.entite.Projection.class})
public interface ProjectionProj  {
    public Long getId();
    public Date getDateProjection();
    public double getPrix();
    public Salle getSalle();
    public Film getFilm();
    public Seance getSeance();
    public Collection<Ticket> getTickets();


}
