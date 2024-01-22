package CinemaProj.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VilleDto {

    private Long id;

    private String name;

    private double longitude,latitude,altitude;


}
