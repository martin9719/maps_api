package com.tts.maps_app.model;

public class Geocoding {
    private Geometry geometry;

    public Geocoding() {
    }

    public Geocoding(Geometry geometry) {
        this.geometry = geometry;
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

}
