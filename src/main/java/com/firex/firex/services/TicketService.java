package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.*;
import com.firex.firex.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class TicketService implements RestServiceInterface<Ticket> {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TicketSeatRepository ticketSeatRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Ticket create(Ticket data) {
        return ticketRepository.save(data);
    }

    // ✅ Booking for customer
    public Ticket bookTicket(Long showId, List<Long> seatIds, Long userId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show Not Found"));

        boolean anyBooked = ticketSeatRepository.existsBySeatIdInAndTicket_ShowId(seatIds, showId);
        if (anyBooked) {
            throw new RuntimeException("One or more seats already booked");
        }

        Customer customer = customerRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        // Award points
        customer.setPoints(customer.getPoints() + 10);
        customerRepository.save(customer);

        Ticket ticket = new Ticket();
        ticket.setShow(show);
        ticket.setCustomer(customer);
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

    // ✅ Booking for admin (without awarding points)
    public Ticket bookTicketAdmin(Long showId, List<Long> seatIds, Long adminId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show Not Found"));

        boolean anyBooked = ticketSeatRepository.existsBySeatIdInAndTicket_ShowId(seatIds, showId);
        if (anyBooked) {
            throw new RuntimeException("One or more seats already booked");
        }

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin Not Found"));

        Ticket ticket = new Ticket();
        ticket.setShow(show);
        ticket.setCustomer(admin);
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

    @Override
    public Ticket update(long id, Ticket data) {
        // Updates not allowed after booking, return fake class
        return new Ticket();
    }

    @Override
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
