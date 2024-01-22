package CinemaProj.configuration;

import CinemaProj.entite.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    // Configurations spécifiques à Spring Security
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().and()      //permettant ou refusant les requêtes provenant de domaines différents
                .csrf().disable()  //désactive la protection contre les attaques CSRF (Cross-Site Request Forgery).
                .authorizeRequests()   //autoriser les requetes correspondantes au antMatchers declaré en dessous
                .antMatchers("/VilleAdmin/**").permitAll() // autorise toutes les requêtes qui correspondent à l'URL "/VilleAdmin/**"
                // sans nécessiter d'authentification.
                .and().httpBasic();  //active l'authentification HTTP de base

    }
    @Override
    //pour mettre des identifiants
    // Configuration de l'authentification (avec un utilisateur en mémoire)
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("cinemaTunis1")
                .password(pswdEncd().encode("123")).roles("ADMIN")
                .and().withUser("cinemaTunis2").password(pswdEncd().encode("123")).roles("ADMIN");
    }


    @Bean
    PasswordEncoder pswdEncd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200"));

//        Autorisation de toutes les méthodes HTTP (GET, POST, PUT, DELETE, etc.) depuis le frontend.
        configuration.addAllowedMethod("*");

//        Autorisation de tous les en-têtes HTTP dans les requêtes.
        configuration.addAllowedHeader("*");

//        Autorisation de l'envoi des informations d'authentification (cookies, credentials) avec la requête.
        configuration.setAllowCredentials(true);

//         Création d'un objet UrlBasedCorsConfigurationSource qui représente la source de configuration CORS basée sur des URL.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

//        Enregistrement de la configuration CORS pour toutes les URL (chemins) de votre application, représenté par "/*".
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
//En résumé, cette configuration CORS permet à une application frontend exécutée sur "http://localhost:4200"
// d'effectuer des requêtes vers votre backend Java Spring,
// en autorisant toutes les méthodes, en-têtes, et en permettant l'envoi de cookies avec les requêtes.

}