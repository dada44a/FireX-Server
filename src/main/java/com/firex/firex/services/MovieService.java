package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Movie;
import com.firex.firex.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements RestServiceInterface<Movie> {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Creates a new Movie entry in the database.
     * @param data Movie object to be saved
     * @return The saved Movie
     */
    @Override
    public Movie create(Movie data) {
        return movieRepository.save(data);
    }

    /**
     * Updates an existing Movie by ID.
     * @param id Movie ID
     * @param data Updated Movie data
     * @return The updated Movie
     */
    @Override
    public Movie update(long id, Movie data) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie with ID " + id + " not found"));

        // Use builder to create updated copy of the movie
        Movie updatedMovie = movie.toBuilder()
                .title(data.getTitle())
                .description(data.getDescription())
                .releaseDate(data.getReleaseDate())
                .casts(data.getCasts())
                .genre(data.getGenre())
                .imageLink(data.getImageLink())
                .build();

        return movieRepository.save(updatedMovie);
    }

    /**
     * Retrieves a Movie by ID.
     * @param id Movie ID
     * @return Movie with the given ID
     */
    @Override
    public Movie read(long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie with ID " + id + " not found"));
    }

    /**
     * Retrieves all movies.
     * @return List of all movies
     */
    public List<Movie> readAll() {
        return movieRepository.findAll();
    }

    /**
     * Retrieves movies that have shows scheduled on a specific date.
     * @param date The date to filter by
     * @return List of movies with shows on the given date
     */
    public List<Movie> getMoviesWithShowsToday(LocalDate date) {
        return movieRepository.findMoviesWithShowsToday(date);
    }

    /**
     * Deletes a movie by ID.
     * @param id Movie ID
     * @return A result message
     */
    @Override
    public Map<String, String> delete(long id) {
        movieRepository.deleteById(id);
        return Map.of("result", "Success");
    }
}
