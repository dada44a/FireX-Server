package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Ticket;
import com.firex.firex.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TicketService implements RestServiceInterface<Ticket> {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket create(Ticket data) {
        return ticketRepository.save(data);
    }

    @Override
    public Ticket update(long id, Ticket data) {
        return null;
    }

    @Override
    public Ticket read(long id) {
        return null;
    }


    public Map<String,String> delete(long id) {

        ticketRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
