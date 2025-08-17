package com.firex.firex.controllers;


import com.firex.firex.DTO.SeatDTO;
import com.firex.firex.models.Seat;
import com.firex.firex.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    /**
     * Create a new Seat
     * @param data Seat data from request body
     * @return Created Seat
     */
    @PostMapping

    public Seat create(@RequestBody SeatDTO data) {
        return seatService.create(data);
    }

    /**
     * Create multiple Seats at once
     * @param seats List of Seats from request body
     * @return List of created Seats
     */
    @PostMapping("/all")
    public List<Seat> createAll(@RequestBody List<SeatDTO> seats) {
        return seatService.createAll(seats);
    }

    /**
     * Update an existing Seat by ID
     * @param id Seat ID from a path
     * @param data Updated Seat data from request body
     * @return Updated Seat
     */
    @PutMapping("/{id}")

    public Seat update(@PathVariable long id, @RequestBody Seat data) {
        return seatService.update(id, data);
    }

    /**
     * Update booking status of a Seat by ID
     * @param id Seat ID from a path
     * @param isBooked Boolean booking status from request body
     * @return Updated Seat with new booking status
     */
    @PutMapping("/status/{id}")
    public Seat updateStatus(@PathVariable long id, @RequestBody boolean isBooked) {
        return seatService.updateStatus(id, isBooked);
    }

    /**
     * Get a Seat by ID
     * @param id Seat ID from a path
     * @return Seat object
     */
    @GetMapping("/{id}")

    public Seat read(@PathVariable long id) {
        return seatService.read(id);
    }

    /**
     * Get all Seats for a given Screen ID
     * @param id Screen ID from a path
     * @return List of Seats belonging to the Screen
     */
    @GetMapping("/screen/{id}")
    public List<Seat> getSeatByScreen(@PathVariable long id) {
        return seatService.getSeatByScreen(id);
    }

    /**
     * Get all Seats
     * @return List of all Seats
     */
    @GetMapping
    public List<Seat> readAll() {
        return seatService.readAll();
    }

    /**
     * Delete a Seat by ID
     * @param id Seat ID from a path
     * @return Map indicating success
     */
    @DeleteMapping("/{id}")

    public Map<String, String> delete(@PathVariable long id) {
        seatService.delete(id);
        return Map.of("result", "Success");
    }
}
