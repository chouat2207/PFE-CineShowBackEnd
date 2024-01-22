package CinemaProj.service.serviceImplements;

import CinemaProj.dtos.TicketDto;
import CinemaProj.mappers.CinemaAdminMapper;
import CinemaProj.mappers.TicketMapper;
import CinemaProj.repository.CinemaRepository;
import CinemaProj.repository.TicketRepository;
import CinemaProj.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketImplement implements TicketService {


    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketMapper ticketMapper;



    @Override
    public TicketDto save(TicketDto ticketDto) {
        return ticketMapper.convertEntityToDto(ticketRepository.save(ticketMapper.convertDtoToEntity(ticketDto)));

    }

    @Override
    public void delete(Long id) {
        boolean exists = ticketRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "type with id "+id+"does not exist");
        }
        ticketRepository.deleteById(id);

    }

    @Override
    public List<TicketDto> findAll() {
        return ticketMapper.convertEntityListToDtoList(ticketRepository.findAll());

    }

    @Override
    public TicketDto update(TicketDto ticketDto, Long id) {
        boolean exists = ticketRepository.existsById(id);
        if (exists){
            save(ticketDto);
        }


        return ticketDto;
    }
}
