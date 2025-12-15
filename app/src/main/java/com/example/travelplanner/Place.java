package com.example.travelplanner;

import java.util.ArrayList;

public class Place {

    String name;
    int image;
    String overview;
    String bestTime;

    ArrayList<ThingItem> thingsList;  // NEW: List of things to do

    String hotels;
    String tags;
    double latitude;
    double longitude;

    public Place(String name, int image, String overview,
                 String bestTime, ArrayList<ThingItem> thingsList,
                 String hotels, String tags,
                 double latitude, double longitude) {

        this.name = name;
        this.image = image;
        this.overview = overview;
        this.bestTime = bestTime;

        this.thingsList = thingsList;  // assign list

        this.hotels = hotels;
        this.tags = tags;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // GETTERS
    public String getName() { return name; }
    public int getImage() { return image; }
    public String getOverview() { return overview; }
    public String getBestTime() { return bestTime; }

    public ArrayList<ThingItem> getThingsList() { return thingsList; }

    public String getHotels() { return hotels; }
    public String getTags() { return tags; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
