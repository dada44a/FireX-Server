package com.firex.firex.services;

import com.firex.firex.models.Seat;
import com.firex.firex.models.Show;
import com.firex.firex.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService implements RestServiceInterface<Show>{

    @Autowired
    private ShowRepository showRepository;


    public List<Show> addAllSeat(List<Show> seat){
        return showRepository.saveAll(seat);
    }

    @Override
    public Show create(Show data) {
        return showRepository.save(data);
    }

    @Override
    public Show update() {
        return null;
    }

    @Override
    public Show read() {
        return null;
    }

    @Override
    public Show delete() {
        return null;
    }
}
