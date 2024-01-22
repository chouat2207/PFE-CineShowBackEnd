package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.CategorieFilmDto;
import CinemaProj.mappers.CategorieFilmMapper;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.repository.CategorieFilmRepository;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.service.CategorieFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategorieFilmImplement implements CategorieFilmService {


    @Autowired
    CategorieFilmRepository categorieFilmRepository;

    @Autowired
    CategorieFilmMapper categorieFilmMapper;


    @Override
    public CategorieFilmDto save(CategorieFilmDto categorieFilmDto) {
        // Convertir l'objet DTO en entité JPA
        return categorieFilmMapper.convertEntityToDto(categorieFilmRepository.save(categorieFilmMapper.convertDtoToEntity(categorieFilmDto)));

    }

    @Override
    public void delete(Long id) {

        boolean exists = categorieFilmRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        categorieFilmRepository.deleteById(id);

    }

    @Override
    public List<CategorieFilmDto> findAll() {

        return categorieFilmMapper.convertListEntityToListDto(categorieFilmRepository.findAll());


    }

    @Override
    public CategorieFilmDto update(CategorieFilmDto categorieFilmDto, Long id) {
        boolean exists = categorieFilmRepository.existsById(id);
        if (exists){
            save(categorieFilmDto);
        }


        return categorieFilmDto;

    }
}
