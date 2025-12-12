package com.example.travelplanner;

public class Place {

    String name;
    int image;
    String shortDesc;
    double latitude;
    double longitude;

    public Place(String name, int image, String shortDesc, double latitude, double longitude) {
        this.name = name;
        this.image = image;
        this.shortDesc = shortDesc;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
