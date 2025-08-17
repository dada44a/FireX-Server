package com.firex.firex.services;


import com.firex.firex.models.*;
import com.firex.firex.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TicketSeatRepository ticketSeatRepository;

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private SeatRepository seatRepository;


    public Ticket create(Ticket data) {
        return ticketRepository.save(data);
    }

    // ✅ Booking for customer
    @Transactional
    public Ticket bookTicket(Long showId, List<Long> seatIds, Long UsersId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show Not Found"));

        boolean anyBooked = ticketSeatRepository.existsBySeatIdInAndTicket_ShowId(seatIds, showId);
        if (anyBooked) {
            throw new RuntimeException("One or more seats already booked");
        }

        Users users = UserRepository.findById(UsersId)
                .orElseThrow(() -> new RuntimeException("Users Not Found"));

        // Award points
        users.setPoints(users.getPoints() + 10);
        UserRepository.save(users);

        Ticket ticket = new Ticket();
        ticket.setShow(show);
        ticket.setCustomer(users);
        ticket.setPaymentDate(LocalDate.now());

        List<Seat> seats = seatRepository.findAllById(seatIds);
        List<TicketSeat> ticketSeats = seats.stream().map(seat -> {
            TicketSeat ts = new TicketSeat();
            ts.setSeat(seat);
            ts.setTicket(ticket);
            return ts;
        }).toList();

        ticket.setTicketSeats(ticketSeats);
        return ticketRepository.save(ticket);
    }


    public Ticket update(long id, Ticket data) {
        // Updates not allowed after booking
        return new Ticket(); // or throw exception if preferred
    }


    public Ticket read(long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket Not Found"));
    }

    public List<Ticket> getByDate(LocalDate date) {
        return ticketRepository.findByPaymentDate(date);
    }

    public List<Ticket> getShowsInDateRange(LocalDate start, LocalDate end) {
        return ticketRepository.findByPaymentDateBetween(start, end);
    }


    public Map<String, String> delete(long id) {
        ticketRepository.deleteById(id);
        return Map.of("result", "Success");
    }
}
