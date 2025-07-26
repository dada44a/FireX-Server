package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Ticket;
import com.firex.firex.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable long id) {

        ticketService.delete(id);
        return Map.of("result", "Sucess");
    }
}
