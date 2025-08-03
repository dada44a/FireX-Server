package com.firex.firex.DTO.utilities;

import com.firex.firex.DTO.AdminSummaryDTO;
import com.firex.firex.DTO.MovieDTO;
import com.firex.firex.DTO.MovieSummaryDTO;
import com.firex.firex.DTO.ShowDTO;
import com.firex.firex.models.Movie;
import com.firex.firex.models.Show;
import com.firex.firex.models.Users;

public class DtoMapper {
    public static MovieDTO toMovieDTO(Movie movie){
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getReleaseDate()
        );

    }

    public static ShowDTO toShowDTO(Show show) {
        Movie movie = show.getMovie();

        return new ShowDTO(
                show.getId(),
                show.getShowTime(),
                show.getShowDate(),
                new MovieSummaryDTO(movie.getId())
        );
    }
}
