package com.example.travelplanner;

import java.util.ArrayList;

public class Place {

    String name;

    int image1;
    int image2;
    int image3;

    String overview;
    String bestTime;
    ArrayList<ThingItem> thingsList;
    String hotels;
    String tags;
    double latitude;
    double longitude;

    public Place(String name,
                 int image1, int image2, int image3,
                 String overview,
                 String bestTime,
                 ArrayList<ThingItem> thingsList,
                 String hotels,
                 String tags,
                 double latitude,
                 double longitude) {

        this.name = name;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.overview = overview;
        this.bestTime = bestTime;
        this.thingsList = thingsList;
        this.hotels = hotels;
        this.tags = tags;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() { return name; }

    public int getImage1() { return image1; }
    public int getImage2() { return image2; }
    public int getImage3() { return image3; }

    public String getOverview() { return overview; }
    public String getBestTime() { return bestTime; }
    public ArrayList<ThingItem> getThingsList() { return thingsList; }
    public String getHotels() { return hotels; }
    public String getTags() { return tags; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
