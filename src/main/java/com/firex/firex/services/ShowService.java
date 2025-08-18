package com.firex.firex.services;

import com.firex.firex.DTO.ShowDTO;
import com.firex.firex.models.Movie;
import com.firex.firex.models.Screen;
import com.firex.firex.models.Show;
import com.firex.firex.models.Users;
import com.firex.firex.repository.MovieRepository;
import com.firex.firex.repository.ShowRepository;
import com.firex.firex.repository.ScreenRepository;
import com.firex.firex.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private UserRepository userRepository;

    /** ---------- Create from DTO ---------- */
    public Show createFromDTO(ShowDTO showDTO) {
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Screen screen = screenRepository.findById(showDTO.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        Users admin = userRepository.findByEmail(showDTO.getAdminEmail());

        Show show = Show.builder()
                .movie(movie)
                .screen(screen)
                .showDate(showDTO.getShowDate())
                .showTime(showDTO.getShowTime())
                .admin(admin)
                .build();

        return showRepository.save(show);
    }

    /** ---------- Update from DTO ---------- */
    public Show updateFromDTO(long id, ShowDTO showDTO) {
        Show existingShow = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Screen screen = screenRepository.findById(showDTO.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        Users admin = userRepository.findByEmail(showDTO.getAdminEmail());

        Show updatedShow = existingShow.toBuilder()
                .movie(movie)
                .screen(screen)
                .showDate(showDTO.getShowDate())
                .showTime(showDTO.getShowTime())
                .admin(admin)
                .build();

        return showRepository.save(updatedShow);
    }

    /** ---------- Get single ShowDTO ---------- */
    public ShowDTO getShowDTO(long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        return mapToDTO(show);
    }

    /** ---------- Get all Shows as DTOs ---------- */
    public List<ShowDTO> getAllShowsDTO() {
        return showRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    /** ---------- Delete Show ---------- */
    public Map<String, String> delete(long id) {
        showRepository.deleteById(id);
        return Map.of("result", "Success");
    }

    /** ---------- Helper: Show -> ShowDTO ---------- */
    public ShowDTO mapToDTO(Show show) {
        return new ShowDTO(
                show.getId(),
                show.getMovie().getId(),
                show.getShowTime(),
                show.getShowDate(),
                show.getAdmin().getEmail(),
                show.getScreen().getId()
        );
    }
}
