package com.firex.firex.repository;


import com.firex.firex.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByPaymentDate(LocalDate date);
    List<Ticket> findByPaymentDateBetween(LocalDate start, LocalDate end);
}
