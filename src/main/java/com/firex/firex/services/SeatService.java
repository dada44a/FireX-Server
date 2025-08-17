package com.firex.firex.services;

import com.firex.firex.DTO.SeatDTO;
import com.firex.firex.models.Screen;
import com.firex.firex.models.Seat;
import com.firex.firex.repository.ScreenRepository;
import com.firex.firex.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScreenRepository screenRepository;

    /**
     * Create a new Seat
     * @param data Seat objects to save
     * @return Saved Seat
     */

    public Seat create(SeatDTO data) {
        Screen screen = screenRepository.findById(data.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        Seat seat = Seat.builder()
                .rows(data.getRow())
                .columns(data.getColumn())
                .isBooked(false)
                .screen(screen)
                .build();
        return seatRepository.save(seat);
    }

    /**
     * Update an existing Seat by ID
     * @param id Seat ID
     * @param data Updated Seat data
     * @return Updated Seat
     */

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
     * @param data List of Seat objects to save
     * @return List of saved Seats
     */
    public List<Seat> createAll(List<SeatDTO> data) {
        List<Seat> seats = data.stream().map(dto -> {
            Screen screen = screenRepository.findById(dto.getScreenId())
                    .orElseThrow(() -> new RuntimeException("Screen not found"));
            return Seat.builder()
                    .rows(dto.getRow())
                    .columns(dto.getColumn())
                    .isBooked(false)
                    .screen(screen)
                    .build();
        }).toList();

        return seatRepository.saveAll(seats);

    }

    /**
     * Delete a Seat by ID
     * @param id Seat ID
     * @return Map indicating success
     */

    public Map<String, String> delete(long id) {
        seatRepository.deleteById(id);
        return Map.of("result", "Success");
    }
}
