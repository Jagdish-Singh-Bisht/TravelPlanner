package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.ArrayList;

public class JaipurPlacesActivity extends AppCompatActivity {

    RecyclerView recyclerPlaces;
    ArrayList<Place> placesList;
    PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaipur_places);

        Toolbar toolbar = findViewById(R.id.placesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerPlaces = findViewById(R.id.recyclerPlaces);
        placesList = new ArrayList<>();

        // 1️⃣ AMBER FORT
        ArrayList<ThingItem> amberThings = new ArrayList<>();
        amberThings.add(new ThingItem(R.drawable.ic_fort, "Fort Tour",
                "Historic fort", "Huge complex",
                "Morning best", "Entry ticket required"));

        placesList.add(new Place(
                "Amber Fort",
                R.drawable.amber_fort,
                "Grand fort showcasing Rajput architecture.",
                "October to March",
                amberThings,
                "Heritage Hotels nearby",
                "Fort, History, Architecture",
                26.9855, 75.8513
        ));

        adapter = new PlaceAdapter(this, placesList);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(this));
        recyclerPlaces.setAdapter(adapter);
    }
}
