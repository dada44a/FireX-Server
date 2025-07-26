package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Show;
import com.firex.firex.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShowService implements RestServiceInterface<Show> {

    @Autowired
    private ShowRepository showRepository;



    @Override
    public Show create(Show data) {
        return showRepository.save(data);
    }

    public List<Show> createAll(List<Show> seat){
        return showRepository.saveAll(seat);
    }


    @Override
    public Show update() {
        return null;
    }

    @Override
    public Show read() {
        return null;
    }

    public Map<String,String> delete(long id) {

        showRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
