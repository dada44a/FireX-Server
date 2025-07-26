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

    public List<Movie> addAllMovie(List<Movie> movie) {
        return movieRepository.saveAll(movie);
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
