package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Show;
import com.firex.firex.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ShowService implements RestServiceInterface<Show> {

    @Autowired
    private ShowRepository showRepository;

    /**
     * Create and persist a new Show entity.
     * @param data the Show data to save
     * @return the saved Show
     */
    @Override
    public Show create(Show data) {
        return showRepository.save(data);
    }

    /**
     * Update an existing Show by ID.
     * @param id ID of the show to update
     * @param data Updated data
     * @return the updated Show entity
     */
    @Override
    public Show update(long id, Show data) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show Not Found"));

        // Use builder to update only relevant fields
        Show updatedShow = show.toBuilder()
                .showDate(data.getShowDate())
                .showTime(data.getShowTime())
                .build();

        return showRepository.save(updatedShow);
    }

    /**
     * Read a single Show by its ID.
     * @param id the ID of the Show
     * @return the found Show
     */
    @Override
    public Show read(long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show Not Found"));
    }

    /**
     * Fetch all Show entries.
     * @return a list of all Shows
     */
    public List<Show> readAll() {
        return showRepository.findAll();
    }

    /**
     * Get all Shows scheduled on a specific date.
     * @param data the date to filter shows
     * @return list of Shows on the given date
     */
    public List<Show> getShowsByDate(LocalDate data) {
        return showRepository.findByShowDate(data);
    }

    /**
     * Get Shows within a specific date range (inclusive).
     * Useful for schedules or reporting.
     * @param start start date
     * @param end end date
     * @return list of Shows between the given dates
     */
    public List<Show> getShowsInDateRange(LocalDate start, LocalDate end) {
        return showRepository.findByShowDateBetween(start, end);
    }

    /**
     * Bulk create Shows in one transaction.
     * @param data list of Show entries (note: variable name 'seat' is misleading)
     * @return saved list of Shows
     */
    public List<Show> createAll(List<Show> data) {
        return showRepository.saveAll(data);
    }

    /**
     * Delete a Show by its ID.
     * @param id the ID of the Show to delete
     * @return result message
     */
    public Map<String, String> delete(long id) {
        showRepository.deleteById(id);
        return Map.of("result", "Sucess");
    }
}
