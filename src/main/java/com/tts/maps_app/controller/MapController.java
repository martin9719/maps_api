package com.tts.maps_app.controller;

import com.tts.maps_app.model.Location;
import com.tts.maps_app.service.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {

    @Autowired
    private MapService mapService;

    // @GetMapping({ "/" })
    // public String getDefaultMap() {
    // Location location = new Location();
    // location.setCity("Dallas");
    // location.setState("Texas");
    // mapService.addCoordinates(location);
    // System.out.println(location);
    // return "index";
    // }
    @GetMapping(value = { "/", "/home" })
    public String getDefaultMap(Model model) {
        model.addAttribute("location", new Location());
        return "index";
    }

    @PostMapping(value = { "/", "/home" })
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute("location", location);
        return "index";
    }

    @PostMapping(value = { "/index" })
    public String getRandomMapLocation(Model model) {
        model.addAttribute("location", mapService.getRandomLocation());
        return "index";
    }
}
