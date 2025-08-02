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
        Users admin = movie.getAdmin();
        AdminSummaryDTO adminSummaryDTO= new AdminSummaryDTO(admin.getId(), admin.getName());
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getReleaseDate(),
                adminSummaryDTO
        );

    }

    public static ShowDTO toShowDTO(Show show) {
        Movie movie = show.getMovie();
        Users admin = show.getAdmin();

        return new ShowDTO(
                show.getId(),
                show.getShowTime(),
                show.getShowDate(),
                new MovieSummaryDTO(movie.getId()),
                new AdminSummaryDTO(admin.getId(), admin.getName())
        );
    }
}
