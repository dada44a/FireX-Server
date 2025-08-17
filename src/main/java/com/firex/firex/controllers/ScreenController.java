package com.firex.firex.controllers;


import com.firex.firex.models.Screen;
import com.firex.firex.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    /**
     * Create a new Screen
     * @param data Screen data from request body
     * @return Created Screen
     */
    @PostMapping
    public Screen create(@RequestBody Screen data) {
        return screenService.create(data);
    }

    /**
     * Create multiple Screens at once
     * @param data List of Screen objects from request body
     * @return List of created Screens
     */
    @PostMapping("/all")
    public List<Screen> createAll(@RequestBody List<Screen> data) {
        return screenService.createAll(data);
    }

    /**
     * Update an existing Screen by ID
     * @param id Screen ID from path variable
     * @param data Updated Screen data from request body
     * @return Updated Screen
     */
    @PutMapping("/{id}")
    public Screen update(@PathVariable long id, @RequestBody Screen data) {
        return screenService.update(id, data);
    }

    /**
     * Retrieve a Screen by ID
     * @param id Screen ID from path variable
     * @return Screen object
     */
    @GetMapping("/{id}")

    public Screen read(@PathVariable long id) {
        return screenService.read(id);
    }

    /**
     * Retrieve all Screens
     * @return List of all Screens
     */
    @GetMapping
    public List<Screen> findAll() {
        return screenService.readAll();
    }

    /**
     * Delete a Screen by ID
     * @param id Screen ID from path variable
     * @return Map indicating success
     */
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable long id) {
        screenService.delete(id);
        return Map.of("result", "Success");
    }
}
