package com.firex.firex.controllers;


import com.firex.firex.models.Movie;
import com.firex.firex.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movie")
public class MovieController{

    @Autowired
    private MovieService movieService;

    /**
     * Create a new movie
     * @param data Movie object from the request body
     * @return The created movie
     */
    @PostMapping

    public Movie create(@RequestBody Movie data) {
        return movieService.create(data);
    }

    /**
     * Update an existing movie by ID
     * @param id Movie ID
     * @param data Updated movie data
     * @return The updated movie
     */
    @PutMapping("/{id}")

    public Movie update(@PathVariable long id, @RequestBody Movie data) {
        return movieService.update(id, data);
    }

    /**
     * Get a movie by ID
     * @param id Movie ID
     * @return Movie with the given ID
     */
    @GetMapping("/{id}")

    public Movie read(@PathVariable long id) {
        return movieService.read(id);
    }

    /**
     * Get a list of all movies
     * @return List of all movies
     */
    @GetMapping
    public List<Movie> readAll() {
        return movieService.readAll();
    }

    /**
     * Get movies that have shows scheduled for today
     * @return List of movies with today's shows
     */
    @GetMapping("/now")
    public List<Movie> getMoviesWithShowsToday() {
        return movieService.getMoviesWithShowsToday(LocalDate.now());
    }

    /**
     * Delete a movie by ID
     * @param id Movie ID
     * @return A success message
     */
    @DeleteMapping("/{id}")

    public Map<String, String> delete(@PathVariable long id) {
        return movieService.delete(id);
    }
}
