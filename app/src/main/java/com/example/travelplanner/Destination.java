package com.example.travelplanner;


// To store destination data(name + image)

public class Destination {

    String name;
    int image;

    public Destination(String n, int i){
        this.name= n;
        this.image= i;
    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }


}
