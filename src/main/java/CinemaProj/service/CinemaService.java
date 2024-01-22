package CinemaProj.service;

import CinemaProj.entite.*;

import java.util.List;

public interface CinemaService {

    public void initVilles();

    public List<Film> initCinemas();
    //public void initCinemas();
    public void initSalles();
    public void initPlaces();
    public void initSeances();

    public void initCategorieFilms();
    public void initfilms();
    public void initProjection();
    public void initTickets();


    List<Ville> getVilles();
    List<Cinema> getCinemas();
    List<CategorieFilm> getCategories();
    List<Film> getFilms();
    List<Place> getPlaces();
    List<Projection> getProjections();
    List<Salle> getSalles();
    List<Seance> getSeances();
    List<Ticket> getTickets();

}