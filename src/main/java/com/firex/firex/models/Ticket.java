package com.firex.firex.models;

import com.firex.firex.models.Customer;
import com.firex.firex.models.Show;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String paymentDate;


    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    @Column(name = "seat_ids")
    @ElementCollection
    private List<Integer> seatIds;
}
