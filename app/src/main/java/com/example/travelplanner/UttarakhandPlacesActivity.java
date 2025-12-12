package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.ArrayList;

public class UttarakhandPlacesActivity extends AppCompatActivity {

    RecyclerView recyclerPlaces;
    ArrayList<Place> placesList;
    PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uttarakhand_places);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.placesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v -> onBackPressed());


        recyclerPlaces = findViewById(R.id.recyclerPlaces);

        // List of Uttarakhand Places
        placesList = new ArrayList<>();

        placesList.add(new Place(
                "Rishikesh",
                R.drawable.rishikesh,
                "Yoga Capital · River Rafting · Ganga Aarti",
                30.0869, 78.2676
        ));

        placesList.add(new Place(
                "Mussoorie",
                R.drawable.mussoorie,
                "Queen of Hills · Mall Road · Waterfalls",
                30.4547, 78.0710
        ));

        placesList.add(new Place(
                "Nainital",
                R.drawable.nainital,
                "Beautiful Lake City · Boating · Snow View",
                29.3919, 79.4542
        ));

        placesList.add(new Place(
                "Dehradun",
                R.drawable.dehradun,
                "Capital City · Robber’s Cave · FRI",
                30.3165, 78.0322
        ));

        placesList.add(new Place(
                "Jim Corbett",
                R.drawable.corbett,
                "India’s Oldest Tiger Reserve · Safaris",
                29.5300, 78.7740
        ));

        placesList.add(new Place(
                "Auli",
                R.drawable.auli,
                "Ski Resort · Ropeway · Snow Peaks",
                30.5286, 79.5712
        ));

        placesList.add(new Place(
                "Kedarnath",
                R.drawable.kedarnath,
                "Famous Shiva Temple · Trek Route",
                30.7346, 79.0669
        ));

        placesList.add(new Place(
                "Valley of Flowers",
                R.drawable.valleyflowers,
                "UNESCO Site · Seasonal Trek · Meadows",
                30.7280, 79.6050
        ));

        placesList.add(new Place(
                "Tungnath",
                R.drawable.tungnath,
                "Highest Shiva Temple · Chandrashila Trek",
                30.4900, 79.2100
        ));

        // Attach Adapter
        adapter = new PlaceAdapter(this, placesList);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(this));
        recyclerPlaces.setAdapter(adapter);
    }
}
