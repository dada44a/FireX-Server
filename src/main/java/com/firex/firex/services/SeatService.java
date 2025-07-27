package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Seat;
import com.firex.firex.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeatService implements RestServiceInterface<Seat> {

    @Autowired
    private SeatRepository seatRepository;



    @Override
    public Seat create(Seat data) {
        return seatRepository.save(data);
    }

    @Override
    public Seat update(long id, Seat data) {
        return null;
    }

    @Override
    public Seat read(long id) {
        return null;
    }

    public List<Seat> createAll(List<Seat> seat){
        return seatRepository.saveAll(seat);
    }


    @Override
    public Map<String,String> delete(long id) {

        seatRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
