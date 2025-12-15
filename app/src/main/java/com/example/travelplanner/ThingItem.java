package com.example.travelplanner;

import java.io.Serializable;

public class ThingItem implements Serializable {

    int icon;
    String title;

    String line1;
    String line2;
    String line3;
    String line4;

    public ThingItem(int icon, String title,
                     String line1, String line2, String line3, String line4) {

        this.icon = icon;
        this.title = title;

        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
    }

    public int getIcon() { return icon; }
    public String getTitle() { return title; }

    public String getLine1() { return line1; }
    public String getLine2() { return line2; }
    public String getLine3() { return line3; }
    public String getLine4() { return line4; }
}
