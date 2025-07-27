package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Seat;
import com.firex.firex.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeatService implements RestServiceInterface<Seat> {

    @Autowired
    private SeatRepository seatRepository;

    /**
     * Create a new Seat
     * @param data Seat objects to save
     * @return Saved Seat
     */
    @Override
    public Seat create(Seat data) {
        return seatRepository.save(data);
    }

    /**
     * Update an existing Seat by ID
     * @param id Seat ID
     * @param data Updated Seat data
     * @return Updated Seat
     */
    @Override
    public Seat update(long id, Seat data) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat with ID " + id + " not found"));

        Seat updatedSeat = seat.toBuilder()
                .rows(data.getRows())
                .columns(data.getColumns())
                .isBooked(data.isBooked())
                .build();
        return seatRepository.save(updatedSeat);
    }

    /**
     * Update only the booking status of a Seat
     * @param id Seat ID
     * @param isBooked Booking status
     * @return Updated Seat with new booking status
     */
    public Seat updateStatus(long id, boolean isBooked) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat with ID " + id + " not found"));

        Seat updatedSeat = seat.toBuilder()
                .isBooked(isBooked)
                .build();

        return seatRepository.save(updatedSeat);
    }

    /**
     * Retrieve a Seat by ID
     * @param id Seat ID
     * @return Seat object
     */
    @Override
    public Seat read(long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat with ID " + id + " not found"));
    }

    /**
     * Retrieve all Seats for a given Screen ID
     * @param screenId Screen ID
     * @return List of Seats associated with the Screen
     */
    public List<Seat> getSeatByScreen(long screenId) {
        return seatRepository.findByScreenId(screenId);
    }

    /**
     * Retrieve all Seats
     * @return List of all Seats
     */
    public List<Seat> readAll() {
        return seatRepository.findAll();
    }

    /**
     * Create multiple Seats at once
     * @param seats List of Seat objects to save
     * @return List of saved Seats
     */
    public List<Seat> createAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    /**
     * Delete a Seat by ID
     * @param id Seat ID
     * @return Map indicating success
     */
    @Override
    public Map<String, String> delete(long id) {
        seatRepository.deleteById(id);
        return Map.of("result", "Success");
    }
}
