package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Screen;
import com.firex.firex.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScreenService implements RestServiceInterface<Screen> {

    @Autowired
    private ScreenRepository screenRepository;




    @Override
    public Screen create(Screen data) {
        return screenRepository.save(data);
    }

    public List<Screen> createAll(List<Screen> screen){
        return screenRepository.saveAll(screen);
    }

    @Override
    public Screen update() {
        return null;
    }

    @Override
    public Screen read() {
        return null;
    }

    @Override
    public Map<String,String> delete(long id) {

        screenRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
