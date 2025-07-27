package com.firex.firex.repository;

import com.firex.firex.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.shows s WHERE s.showDate = :today")
    List<Movie> findMoviesWithShowsToday(@Param("today") LocalDate today);
}
