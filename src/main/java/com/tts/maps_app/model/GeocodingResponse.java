package com.tts.maps_app.model;

import java.util.List;

public class GeocodingResponse {
    private List<Geocoding> results;

    public GeocodingResponse() {
    }

    public GeocodingResponse(List<Geocoding> results) {
        this.results = results;
    }

    public List<Geocoding> getResults() {
        return this.results;
    }

    public void setResults(List<Geocoding> results) {
        this.results = results;
    }

}
