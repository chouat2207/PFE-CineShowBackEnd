package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.SalleDto;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.mappers.SalleMapper;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.repository.SalleRepository;
import CinemaProj.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleImplement implements SalleService {

    @Autowired
    SalleRepository salleRepository;

    @Autowired
    SalleMapper salleMapper;


    @Override
    public SalleDto save(SalleDto salleDto) {
        return salleMapper.convertEntityToDto(salleRepository.save(salleMapper.convertDtoToEntity(salleDto)));

    }

    @Override
    public void delete(Long id) {
        boolean exists = salleRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        salleRepository.deleteById(id);

    }

    @Override
    public List<SalleDto> findAll() {
        return salleMapper.convertEntityListToDtoList(salleRepository.findAll());

    }

    @Override
    public SalleDto update(SalleDto salleDto, Long id) {
        boolean exists = salleRepository.existsById(id);
        if (exists){
            save(salleDto);
        }


        return salleDto;
    }
}
