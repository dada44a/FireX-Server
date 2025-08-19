package com.firex.firex.controllers;

import com.firex.firex.DTO.ShowDTO;
import com.firex.firex.models.Movie;
import com.firex.firex.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    /** ---------- Create a single Show ---------- */
    @PostMapping
    public ShowDTO create(@RequestBody ShowDTO data) {
        return showService.mapToDTO(showService.createFromDTO(data));
    }

    /** ---------- Update a Show by ID ---------- */
    @PutMapping("/{id}")
    public ShowDTO update(@PathVariable long id, @RequestBody ShowDTO data) {
        return showService.mapToDTO(showService.updateFromDTO(id, data));
    }

    /** ---------- Get a Show by ID ---------- */
    @GetMapping("/{id}")
    public ShowDTO read(@PathVariable long id) {
        return showService.getShowDTO(id);
    }

    /** ---------- Get all Shows ---------- */
    @GetMapping
    public List<ShowDTO> readAll() {
        return showService.getAllShowsDTO();
    }

    /** ---------- Get shows for today ---------- */
    @GetMapping("/today")
    public List<ShowDTO> getTodayShows() {
        LocalDate today = LocalDate.now();
        return showService.getAllShowsDTO().stream()
                .filter(show -> today.equals(show.getShowDate()))
                .toList();
    }

    /** ---------- Get shows within a date range ---------- */
    @GetMapping("/in-between")
    public List<ShowDTO> getShowsBetween(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return showService.getAllShowsDTO().stream()
                .filter(show -> !show.getShowDate().isBefore(start) && !show.getShowDate().isAfter(end))
                .toList();
    }

    /** ---------- Bulk-create Shows ---------- */
    @PostMapping("/all")
    public List<ShowDTO> createAll(@RequestBody List<ShowDTO> data) {
        return data.stream()
                .map(showService::createFromDTO)
                .map(showService::mapToDTO)
                .toList();
    }


    /** ---------- Get movies that have shows today ---------- */
    @GetMapping("/today-movies")
    public List<Movie> getTodayMovies() {
        return showService.getTodayMovies();
    }

    /** ---------- Delete a Show by ID ---------- */
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable long id) {
        return showService.delete(id);
    }
}
