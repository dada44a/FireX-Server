package com.firex.firex.services;

import com.firex.firex.interfaces.RestServiceInterface;
import com.firex.firex.models.Screen;
import com.firex.firex.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScreenService implements RestServiceInterface<Screen> {

    @Autowired
    private ScreenRepository screenRepository;

    /**
     * Create a new Screen
     * @param data Screen object to save
     * @return Saved Screen
     */
    @Override
    public Screen create(Screen data) {
        return screenRepository.save(data);
    }

    /**
     * Create multiple screens at once
     * @param screens List of Screen objects to save
     * @return List of saved Screens
     */
    public List<Screen> createAll(List<Screen> screens) {
        return screenRepository.saveAll(screens);
    }

    /**
     * Update an existing Screen by ID
     * @param id Screen ID
     * @param data Updated Screen data
     * @return Updated Screen
     */
    @Override
    public Screen update(long id, Screen data) {
        Screen screen = screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen with ID " + id + " not found"));

        Screen updatedScreen = screen.toBuilder()
                .name(data.getName())
                .build();

        return screenRepository.save(updatedScreen);
    }

    /**
     * Read a Screen by ID
     * @param id Screen ID
     * @return Screen with the specified ID
     */
    @Override
    public Screen read(long id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen with ID " + id + " not found"));
    }

    /**
     * Retrieve all screens
     * @return List of all screens
     */
    public List<Screen> readAll() {
        return screenRepository.findAll();
    }

    /**
     * Delete a Screen by ID
     * @param id Screen ID
     * @return Result map indicating success
     */
    @Override
    public Map<String, String> delete(long id) {
        screenRepository.deleteById(id);
        return Map.of("result", "Success");
    }
}
