package com.firex.firex.controllers;


import com.firex.firex.models.Ticket;
import com.firex.firex.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // ✅ General creation (not typically used in production)

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket data) {
        return ticketService.create(data);
    }

    // ✅ Book ticket as Users
    @Transactional
    @PostMapping("/book/Users")
    public Ticket bookTicketAsUsers(
            @RequestParam Long showId,
            @RequestBody List<Long> seatIds,
            @RequestAttribute Long id
    ) {
        return ticketService.bookTicket(showId, seatIds, id);
    }



    @PutMapping("/{id}")
    public Ticket update(@PathVariable long id, @RequestBody Ticket data) {
        return ticketService.update(id, data); // Returns fake object
    }

    // ✅ Read single ticket

    @GetMapping("/{id}")
    public Ticket read(@PathVariable long id) {
        return ticketService.read(id);
    }

    // ✅ Delete ticket

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable long id) {
        return ticketService.delete(id);
    }

    // ✅ Get tickets for a specific date
    @GetMapping("/date")
    public List<Ticket> getByDate(@RequestParam LocalDate date) {
        return ticketService.getByDate(date);
    }

    // ✅ Get tickets between two dates
    @GetMapping("/range")
    public List<Ticket> getByDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end
    ) {
        return ticketService.getShowsInDateRange(start, end);
    }
}
