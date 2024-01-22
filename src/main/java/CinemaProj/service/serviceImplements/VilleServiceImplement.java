package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.VilleDto;
import CinemaProj.mappers.VilleMapper;
import CinemaProj.repository.VilleRepository;
import CinemaProj.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleServiceImplement implements VilleService {

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    VilleMapper villeMapper;


    @Override
    public VilleDto save(VilleDto villeDto) {

        return villeMapper.convertEntityToDto(villeRepository.save(villeMapper.convertDtoToEntity(villeDto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = villeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        villeRepository.deleteById(id);

    }

    @Override
    public List<VilleDto> findAll() {
        return villeMapper.convertListEntityToListDto(villeRepository.findAll());
    }

    @Override
    public VilleDto update(VilleDto villeDto, Long id) {

        boolean exists = villeRepository.existsById(id);
        if (exists){
            save(villeDto);
        }


        return villeDto;

    }
}
