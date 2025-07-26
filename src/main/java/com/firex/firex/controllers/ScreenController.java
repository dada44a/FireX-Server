package com.firex.firex.controllers;

import com.firex.firex.models.Screen;
import com.firex.firex.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/screen")
public class ScreenController implements RestInterface<Screen> {

    @Autowired
    private ScreenService screenService;


    public Screen createAll() {
        return null;
    }

    public Screen findAll() {
        return null;
    }

    @PostMapping
    @Override
    public Screen create(@RequestBody Screen data) {
        return screenService.create(data);
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