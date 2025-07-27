package com.firex.firex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder(toBuilder = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rows;
    @Column(nullable = false)
    private int columns;

    @ManyToOne
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "ticket_id") // <- new foreign key to Ticket
    private Ticket ticket;
}

