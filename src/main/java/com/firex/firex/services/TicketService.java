package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Show;
import com.firex.firex.models.Ticket;
import com.firex.firex.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
        return ticketRepository.findById(id).orElseThrow(()->new RuntimeException("Ticket Not Found"));
    }

    public List<Ticket> getByDate(LocalDate data) {
        return ticketRepository.findByPaymentDate(data);
    }

    public List<Ticket> getShowsInDateRange(LocalDate start, LocalDate end) {
        return ticketRepository.findByPaymentDateBetween(start, end);
    }




    public Map<String,String> delete(long id) {

        ticketRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
