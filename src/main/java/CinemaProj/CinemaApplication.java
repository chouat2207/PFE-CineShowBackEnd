package CinemaProj;

import CinemaProj.entite.*;
import CinemaProj.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class CinemaApplication implements CommandLineRunner {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private CinemaService cinemaService;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
		System.out.println("connected");

	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class, Cinema.class, CategorieFilm.class,Projection.class,Place.class,Seance.class,Ville.class);

		if (cinemaService.getVilles().isEmpty()){
			cinemaService.initVilles();
		}

		if (cinemaService.getCinemas().isEmpty()){
			cinemaService.initCinemas();
		}
		if (cinemaService.getSalles().isEmpty()){
			cinemaService.initSalles();
		}

		if (cinemaService.getPlaces().isEmpty()){
			cinemaService.initPlaces();
		}

		if (cinemaService.getSeances().isEmpty()){
			cinemaService.initSeances();
		}
		if (cinemaService.getCategories().isEmpty()){
			cinemaService.initCategorieFilms();
		}

		if (cinemaService.getFilms().isEmpty()){
			cinemaService.initfilms();
		}

		if (cinemaService.getProjections().isEmpty()){
			cinemaService.initProjection();
		}

		if (cinemaService.getTickets().isEmpty()){
			cinemaService.initTickets();
		}
	}
}

