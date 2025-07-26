package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Seat;
import com.firex.firex.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements RestServiceInterface<Seat> {

    @Autowired
    private SeatRepository seatRepository;



    @Override
    public Seat create(Seat data) {
        return seatRepository.save(data);
    }

    public List<Seat> createAll(List<Seat> seat){
        return seatRepository.saveAll(seat);
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
