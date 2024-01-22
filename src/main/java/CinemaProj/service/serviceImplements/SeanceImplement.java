package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.SeanceDto;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.mappers.SeanceMapper;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.repository.SeanceRepository;
import CinemaProj.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceImplement implements SeanceService {


    @Autowired
    SeanceRepository seanceRepository;

    @Autowired
    SeanceMapper seanceMapper;

    @Override
    public SeanceDto save(SeanceDto seanceDto) {
        return seanceMapper.convertEntityToDto(seanceRepository.save(seanceMapper.convertDtoToEntity(seanceDto)));

    }

    @Override
    public void delete(Long id) {
        boolean exists = seanceRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        seanceRepository.deleteById(id);

    }

    @Override
    public List<SeanceDto> findAll() {
        return seanceMapper.convertListEntityToListDto(seanceRepository.findAll());

    }

    @Override
    public SeanceDto update(SeanceDto seanceDto, Long id) {
        boolean exists = seanceRepository.existsById(id);
        if (exists){
            save(seanceDto);
        }


        return seanceDto;
    }
}
