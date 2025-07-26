package com.firex.firex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int rows;
    @Column(nullable = false)
    private int columns;
    @Column(columnDefinition = "boolean default false")
    private Boolean status;

    @ManyToOne
    private Screen screen;
}

