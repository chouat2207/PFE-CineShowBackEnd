package CinemaProj.service.serviceImplements;


import CinemaProj.dtos.CinemaDto;
import CinemaProj.entite.Ville;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.service.CinemaAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaAdminImplement implements CinemaAdminService {

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    CinemaAdminMapper cinemaAdminMapper;



    @Override
    public CinemaDto save(CinemaDto cinemaDto) {

        return cinemaAdminMapper.convertEntityToDto(cinemaRepository.save(cinemaAdminMapper.convertDtoToEntity(cinemaDto)));
    }

    @Override
    public void delete(Long id) {

        boolean exists = cinemaRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        cinemaRepository.deleteById(id);

    }

    @Override
    public List<CinemaDto> findAll() {
        return cinemaAdminMapper.convertEntityListToDtoList(cinemaRepository.findAll());
    }

    @Override
    public CinemaDto update(CinemaDto cinemaDto, Long id) {

        boolean exists = cinemaRepository.existsById(id);
        if (exists){
            save(cinemaDto);
        }
        return cinemaDto;
    }
}
