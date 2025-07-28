package com.firex.firex.repository;


import com.firex.firex.models.TicketSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketSeatRepository extends JpaRepository<TicketSeat, Long> {
    boolean existsBySeatIdInAndTicket_ShowId(List<Long> seatIds, Long showId);
}
