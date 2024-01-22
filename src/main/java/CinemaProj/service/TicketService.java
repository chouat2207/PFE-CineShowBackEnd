package CinemaProj.service;


import CinemaProj.dtos.TicketDto;

import java.util.List;

public interface TicketService {


    TicketDto save(TicketDto ticketDto);

    void delete(Long id);

    List<TicketDto> findAll();

    TicketDto update(TicketDto ticketDto,Long id);


}
