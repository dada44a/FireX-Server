package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Screen;
import com.firex.firex.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Screen delete() {
        return null;
    }
}