package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.ArrayList;

public class ManaliPlacesActivity extends AppCompatActivity {

    RecyclerView recyclerPlaces;
    ArrayList<Place> placesList;
    PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manali_places);

        Toolbar toolbar = findViewById(R.id.placesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerPlaces = findViewById(R.id.recyclerPlaces);
        placesList = new ArrayList<>();

        // 1️⃣ SOLANG VALLEY
        ArrayList<ThingItem> solangThings = new ArrayList<>();
        solangThings.add(new ThingItem(R.drawable.ic_paragliding, "Paragliding",
                "Adventure activity", "Best in summer",
                "Paid sport", "Weather dependent"));
        solangThings.add(new ThingItem(R.drawable.ic_snow_manali, "Snow Activities",
                "Skiing & snow play", "Winter season",
                "Equipment on rent", "Very popular"));

        placesList.add(new Place(
                "Solang Valley",
                R.drawable.solang,
                R.drawable.solang,
                R.drawable.solang,
                "Adventure hub near Manali famous for snow sports.",
                "December to February",
                solangThings,
                "Solang Valley Resort, Snow Valley",
                "Adventure, Snow, Mountains",
                32.3184, 77.1556
        ));

        // 2️⃣ HADIMBA TEMPLE
        ArrayList<ThingItem> hadimbaThings = new ArrayList<>();
        hadimbaThings.add(new ThingItem(R.drawable.ic_temple_manali, "Temple Visit",
                "Ancient wooden temple", "Surrounded by forest",
                "Free entry", "Peaceful place"));

        placesList.add(new Place(
                "Hadimba Temple",
                R.drawable.hadimba,
                R.drawable.hadimba,
                R.drawable.hadimba,
                "Ancient temple surrounded by cedar forest.",
                "March to June",
                hadimbaThings,
                "Hotel Johnson, Snow Valley",
                "Temple, Culture, Nature",
                32.2432, 77.1892
        ));

        adapter = new PlaceAdapter(this, placesList);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(this));
        recyclerPlaces.setAdapter(adapter);
    }
}
