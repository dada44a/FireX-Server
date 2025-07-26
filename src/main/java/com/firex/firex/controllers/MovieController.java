package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Movie;
import com.firex.firex.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable long id) {

        movieService.delete(id);
        return Map.of("result", "Sucess");
    }


    public Movie createAll() {
        return null;
    }


    public Movie findAll() {
        return null;
    }
}
