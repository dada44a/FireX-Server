package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Seat;
import com.firex.firex.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seat")
public class SeatController implements RestControllerInterface<Seat> {

    @Autowired
    private SeatService seatService;

    @PostMapping
    @Override
    public Seat create(Seat data) {
        return seatService.create(data);
    }

    @Override
    public Seat update() {
        return null;
    }

    @Override
    public Seat read() {
        return null;
    }

    @Override
    public Seat delete() {
        return null;
    }
}
