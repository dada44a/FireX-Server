package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Show;
import com.firex.firex.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/show")
public class ShowController implements RestControllerInterface<Show> {

    @Autowired
    private ShowService showService;

    /**
     * Create a single Show entry.
     * Mapped to POST /api/show
     * @param data Show an object from request body
     * @return the created Show
     */
    @PostMapping
    @Override
    public Show create(@RequestBody Show data) {
        return showService.create(data);
    }

    /**
     * Update an existing Show by its ID.
     * Mapped to PUT /api/show/{id}
     * @param id Show ID from a path
     * @param data updated Show data from body
     * @return updated Show object
     */
    @Override
    @PutMapping("/{id}")
    public Show update(@PathVariable long id, @RequestBody Show data) {
        return showService.update(id, data);
    }

    /**
     * Get a single Show by ID.
     * Mapped to GET /api/show/{id}
     * @param id Show ID
     * @return the found Show
     */
    @Override
    @GetMapping("/{id}")
    public Show read(@PathVariable long id) {
        return showService.read(id);
    }

    /**
     * Get all Shows.
     * Mapped to GET /api/show
     * @return list of all Shows
     */
    @GetMapping
    public List<Show> readAll() {
        return showService.readAll();
    }

    /**
     * Get all shows scheduled for today.
     * Mapped to GET /api/show/now
     * @return list of today's shows
     */
    @GetMapping("/now")
    public List<Show> getTodayShows() {
        return showService.getShowsByDate(LocalDate.now());
    }

    /**
     * Get shows within a specified date range.
     * Example request: /api/show/in-between?start=2025-07-01&end=2025-07-31
     * @param start start date
     * @param end end date
     * @return list of shows between those dates
     */
    @GetMapping("/in-between")
    public List<Show> getShowsBetween(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return showService.getShowsInDateRange(start, end);
    }

    /**
     * Bulk-create multiple Shows.
     * Mapped to POST /api/show/all
     * @param data list of Show objects
     * @return list of saved Shows
     */
    @PostMapping("/all")
    public List<Show> createAll(@RequestBody List<Show> data) {
        return showService.createAll(data);
    }

    /**
     * Delete a Show by ID.
     * Mapped to DELETE /api/show/{id}
     * @param id ID of the Show
     * @return success message map
     */
    @Override
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable long id) {
        showService.delete(id);
        return Map.of("result", "Success");
    }
}
