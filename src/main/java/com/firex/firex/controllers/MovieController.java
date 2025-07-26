package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Movie;
import com.firex.firex.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController implements RestControllerInterface<Movie> {

    @Autowired
    private MovieService movieService;


    @PostMapping
    @Override
    public Movie create(@RequestBody Movie data) {
        return movieService.create(data);
    }

    @PostMapping("/all")
    public List<Movie> createAll(@RequestBody List<Movie> data){
        return movieService.createAll(data);
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


    public Movie createAll() {
        return null;
    }


    public Movie findAll() {
        return null;
    }
}
