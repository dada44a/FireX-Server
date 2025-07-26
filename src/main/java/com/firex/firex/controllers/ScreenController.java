package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Screen;
import com.firex.firex.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/screen")
public class ScreenController implements RestControllerInterface<Screen> {

    @Autowired
    private ScreenService screenService;


    public Screen findAll() {
        return null;
    }

    @PostMapping
    @Override
    public Screen create(@RequestBody Screen data) {
        return screenService.create(data);
    }


    @PostMapping("/all")
    public List<Screen> createAll(@RequestBody List<Screen> data) {
        return screenService.createAll(data);
    }

    @Override
    public Screen update() {
        return null;
    }

    @Override
    public Screen read() {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable long id) {

        screenService.delete(id);
        return Map.of("result", "Sucess");
    }
}