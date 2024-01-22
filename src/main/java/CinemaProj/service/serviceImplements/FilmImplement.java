package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.FilmDto;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.mappers.FilmMapper;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.repository.FilmRepository;
import CinemaProj.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FilmImplement implements FilmService {


    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmMapper filmMapper;


    @Override
    public FilmDto save(FilmDto filmDto) {

        return filmMapper.convertEntityToDto(filmRepository.save(filmMapper.convertDtoToEntity(filmDto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = filmRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        filmRepository.deleteById(id);

    }

    @Override
    public List<FilmDto> findAll() {
        return filmMapper.convertEntityListToDtoList(filmRepository.findAll());
    }

    @Override
    public FilmDto update(FilmDto filmDto, Long id) {


        boolean exists = filmRepository.existsById(id);
        if (exists){
            save(filmDto);
        }


        return filmDto;
    }
}
