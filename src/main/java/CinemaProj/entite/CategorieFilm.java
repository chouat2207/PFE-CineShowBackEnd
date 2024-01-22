package CinemaProj.entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


// @Entity indique que la classe est une classe Java persistante
// @Table fournit la table qui mappe cette entité.
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategorieFilm implements Serializable {
    // @Id annotation is for the primary key.
// L'annotation @GeneratedValue est utilisée pour définir la stratégie de génération de la clé primaire. GenerationType.AUTO signifie champ d'incrémentation automatique.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column est utilisée pour définir la colonne de la base de données qui mappe le champ annoté.
    @Column(length = 76)
    private String name;
    @OneToMany(mappedBy = "categorieFilm")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Film> films;


}
