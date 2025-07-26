package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Seat;
import com.firex.firex.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/all")
    public List<Seat> createAll(List<Seat> seat){
        return seatService.createAll(seat);
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
    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable long id) {

        seatService.delete(id);
        return Map.of("result", "Sucess");
    }
}
