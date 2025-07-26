package com.firex.firex.services;

import com.firex.firex.models.Ticket;
import com.firex.firex.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements RestServiceInterface<Ticket> {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket create(Ticket data) {
        return ticketRepository.save(data);
    }

    @Override
    public Ticket update() {
        return null;
    }

    @Override
    public Ticket read() {
        return null;
    }

    @Override
    public Ticket delete() {
        return null;
    }
}
