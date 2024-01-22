package CinemaProj.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CinemaDto {

    private Long id;

    private String name;

    private double longitude,latitude,altitude;

    private int nombreSalles;

    private VilleDto ville;






}
