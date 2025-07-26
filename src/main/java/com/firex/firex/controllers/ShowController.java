package com.firex.firex.controllers;

import com.firex.firex.interfaces.RestControllerInterface;
import com.firex.firex.models.Show;
import com.firex.firex.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @DeleteMapping("/{id}")
    public Map<String,String> delete(@PathVariable long id) {

        showService.delete(id);
        return Map.of("result", "Sucess");
    }
}
