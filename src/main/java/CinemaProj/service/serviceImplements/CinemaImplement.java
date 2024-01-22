package CinemaProj.service.serviceImplements;

import CinemaProj.entite.*;
import CinemaProj.repository.*;
import CinemaProj.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaImplement implements CinemaService {

    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private CategorieFilmRepository categorieFilmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ville> getVilles() {
        return villeRepository.findAll();
    }

    @Override
    public List<Cinema> getCinemas() {
        return cinemaRepository.findAll();
    }
    @Override
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }
    @Override
    public List<CategorieFilm> getCategories() {
        return categorieFilmRepository.findAll();
    }
    @Override
    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }
    @Override
    public List<Projection> getProjections() {
        return projectionRepository.findAll();
    }
    @Override
    public List<Salle> getSalles() {
        return salleRepository.findAll();
    }
    @Override
    public List<Seance> getSeances() {
        return seanceRepository.findAll();
    }
    @Override
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }




     @Override
    public void initVilles() {
          Stream.of("Tunis","Sousse","Djerba","Hammamet").forEach(nameVille->{
            Ville ville=new Ville();
          ville.setName(nameVille);
        villeRepository.save(ville);
        });

    }


    @Override
    public List<Film> initCinemas() { //dans chaque ville on a ajouté des cinemas
        villeRepository.findAll().forEach(v->{
            Stream.of("La Palace","Colisée","CinéMadart","L'Agora").forEach(nameCinema->{
                Cinema cinema=new Cinema();
                cinema.setName(nameCinema);
                cinema.setNombreSalles(3+(int)( Math.random()*7));
                cinema.setVille(v); // v ==> ville
                cinemaRepository.save(cinema);
            });
        });

        return null;
    }

    @Override
    public void initSalles() {  //dans chaque cinéma on a ajouté des salles
        cinemaRepository.findAll().forEach(cinema -> {
            for(int i=0;i<cinema.getNombreSalles();i++){
                Salle salle=new Salle();
                salle.setName("Salle"+(i+1));
                salle.setCinema(cinema);
                salle.setNombrePlace(15+(int) (Math.random()*20));
                salleRepository.save(salle);

            }


        });



    }

    @Override
    public void initPlaces() { //dans chaque salle on a ajouté des places
        salleRepository.findAll().forEach(salle -> {
            for(int i=0;i<salle.getNombrePlace();i++){
                Place place=new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });

    }

    @Override
    public void initSeances() {
        DateFormat dateFormat= new SimpleDateFormat("HH:mm");
        Stream.of("12:00","17:00","21:00","22:00").forEach(s -> {
            Seance seance = new Seance();
            try {
                seance.setHeureDebut(dateFormat.parse(s));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    public void initCategorieFilms() {
        Stream.of("Comédie","Guerre","Histoire","Aventure","Fantastique").forEach(cat->{
            CategorieFilm categorieFilm =new CategorieFilm();
            categorieFilm.setName(cat);
            categorieFilmRepository.save(categorieFilm);
        });

    }

    @Override
    public void initfilms() {
        double[] durees= new double[]{1,1.5,2,2.5,3};
        List<CategorieFilm> categorieFilms=categorieFilmRepository.findAll();
        Stream.of("Avengers","Copains pour toujours","les deguns","Venom","Inferno").forEach(titreFilm->{
            Film film=new Film();
            film.setTitre(titreFilm);
            film.setDuree(durees[new Random().nextInt(durees.length)]);
            film.setPhoto(titreFilm.replace(" ","")+".jpg");
            film.setCategorieFilm(categorieFilms.get(new Random().nextInt(categorieFilms.size())));
            filmRepository.save(film);

        });

    }

    @Override
    public void initProjection() {
        double[] prix= new double[]{30,40,50,70,50};
        List<Film> films= filmRepository.findAll();
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    int index= new Random().nextInt(films.size());
                    Film film=films.get(index);
                        seanceRepository.findAll().forEach(seance -> {
                            Projection projection =new Projection();
                            projection.setDateProjection(new Date());
                            projection.setFilm(film);
                            projection.setPrix(prix [new Random().nextInt(prix.length)]);
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projectionRepository.save(projection);
                        });

                });
            });
        });

    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(projection -> {
            projection.getSalle().getPlaces().forEach(place -> {
                Ticket ticket=new Ticket();
                ticket.setPlace(place);
                ticket.setPrix(projection.getPrix());
                ticket.setProjection(projection);
                ticket.setReservee(false);
                ticketRepository.save(ticket);
            });

        });

    }
}
