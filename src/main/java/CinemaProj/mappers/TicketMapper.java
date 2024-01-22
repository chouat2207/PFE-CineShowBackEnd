package CinemaProj.mappers;

import CinemaProj.dtos.TicketDto;
import CinemaProj.entite.Ticket;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketMapper {


    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    PlaceMapper placeMapper;

    @Autowired
    ProjectionMapper projectionMapper;


    public Ticket convertDtoToEntity(TicketDto ticketDto){
        Ticket ticket = dozerBeanMapper.map(ticketDto,Ticket.class);
        if (ticket.getPlace() != null && ticket.getProjection() != null ){

            ticket.setPlace(placeMapper.convertDtoToEntity(ticketDto.getPlace()));
            ticket.setProjection(projectionMapper.convertDtoToEntity(ticketDto.getProjection()));
        }
        return ticket;
    }



    public TicketDto convertEntityToDto(Ticket ticket){
        TicketDto ticketDto = dozerBeanMapper.map(ticket,TicketDto.class);
        if (ticketDto.getPlace() != null && ticketDto.getProjection() != null ){

            ticketDto.setPlace(placeMapper.convertEntityToDto(ticket.getPlace()));
            ticketDto.setProjection(projectionMapper.convertEntityToDto(ticket.getProjection()));
        }
        return ticketDto;
    }


    public List<Ticket> convertDtoListToEntityList(List<TicketDto> ticketDtoList){
        List<Ticket> ticketList = new ArrayList<>();
        ticketDtoList.forEach(ticketX->ticketList.add(convertDtoToEntity(ticketX)));
        return ticketList;
    }


    public List<TicketDto> convertEntityListToDtoList(List<Ticket> ticketList) {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        ticketList.forEach(ticketX -> ticketDtoList.add(convertEntityToDto(ticketX)));
        return ticketDtoList;
    }









}
