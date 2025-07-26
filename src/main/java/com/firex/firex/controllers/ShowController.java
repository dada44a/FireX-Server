package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Show;
import com.firex.firex.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/show")
public class ShowController implements RestControllerInterface<Show> {

    @Autowired
    private ShowService showService;

    @PostMapping
    @Override
    public Show create(@RequestBody  Show data) {
        return showService.create(data);
    }

    @PostMapping("/all")
    public List<Show> createAll(@RequestBody List<Show> seat){
        return showService.createAll(seat);
    }

    @Override
    public Show update() {
        return null;
    }

    @Override
    public Show read() {
        return null;
    }

    @Override
    public Show delete() {
        return null;
    }
}
