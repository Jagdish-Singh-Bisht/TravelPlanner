package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.ArrayList;

public class DelhiPlacesActivity extends AppCompatActivity {

    RecyclerView recyclerPlaces;
    ArrayList<Place> placesList;
    PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_places);

        Toolbar toolbar = findViewById(R.id.placesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerPlaces = findViewById(R.id.recyclerPlaces);
        placesList = new ArrayList<>();

        // 1️⃣ INDIA GATE
        ArrayList<ThingItem> indiaGateThings = new ArrayList<>();
        indiaGateThings.add(new ThingItem(
                R.drawable.ic_monument,
                "Evening Walk",
                "Iconic landmark",
                "Best after sunset",
                "Free entry",
                "Crowded weekends"
        ));

        placesList.add(new Place(
                "India Gate",
                R.drawable.indiagate,
                R.drawable.indiagate,
                R.drawable.indiagate,
                "National war memorial and popular city landmark.",
                "October to March",
                indiaGateThings,
                "Nearby CP hotels",
                "Monument, City, Landmark",
                28.6129,
                77.2295
        ));

        adapter = new PlaceAdapter(this, placesList);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(this));
        recyclerPlaces.setAdapter(adapter);
    }
}
