package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Ticket;
import com.firex.firex.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketController implements RestControllerInterface<Ticket> {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    @Override
    public Ticket create(Ticket data) {
        return ticketService.create(data);
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
