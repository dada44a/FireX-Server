package com.firex.firex.repository;


import com.firex.firex.models.Movie;
import com.firex.firex.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByShowDate(LocalDate date);
    List<Show> findByMovieIdAndShowDate(Long movieId, LocalDate showDate);
    List<Show> findByShowDateBetween(LocalDate start, LocalDate end);


}
