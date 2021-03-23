package com.tts.maps_app.service;

import com.tts.maps_app.model.GeocodingResponse;
import com.tts.maps_app.model.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
    @Value("${api_key}")
    private String apiKey;

    public void addCoordinates(Location location) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + ","
                + location.getState() + "&key=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();
        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
    }

    public Location getRandomLocation() {
        Location location = new Location();
        double x = (Math.random() * 180.0) - 90.0;
        double y = (Math.random() * 360.0) - 180.0;
        location.setLat(String.valueOf(x));
        location.setLng(String.valueOf(y));
        // String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" +
        // location.getLat() + ","
        // + location.getLng() + "&key=" + apiKey;
        // RestTemplate restTemplate = new RestTemplate();
        // GeocodingResponse response = restTemplate.getForObject(url,
        // GeocodingResponse.class);
        // Location coordinates =
        // response.getResults().get(0).getGeometry().getLocation();
        // location.setCity(coordinates.getCity());
        // location.setState(coordinates.getState());

        return location;
    }
}
