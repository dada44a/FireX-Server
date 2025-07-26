package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Movie;
import com.firex.firex.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements RestServiceInterface<Movie> {

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public Movie create(Movie data) {
        return movieRepository.save(data);
    }

    public List<Movie> createAll(List<Movie> data) {
        return movieRepository.saveAll(data);
    }



    @Override
    public Movie update() {
        return null;
    }

    @Override
    public Movie read() {
        return null;
    }

    @Override
    public Movie delete() {
        return null;
    }
}
