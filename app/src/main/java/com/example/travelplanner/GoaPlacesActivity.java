package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.ArrayList;

public class GoaPlacesActivity extends AppCompatActivity {

    RecyclerView recyclerPlaces;
    ArrayList<Place> placesList;
    PlaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goa_places);

        Toolbar toolbar = findViewById(R.id.placesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        recyclerPlaces = findViewById(R.id.recyclerPlaces);
        placesList = new ArrayList<>();

        // 1️⃣ BAGA BEACH
        ArrayList<ThingItem> bagaThings = new ArrayList<>();
        bagaThings.add(new ThingItem(R.drawable.ic_parasailing, "Parasailing",
                "Popular water sport", "Best Time: Morning",
                "Duration: 10–15 min", "Paid activity"));
        bagaThings.add(new ThingItem(R.drawable.ic_beach, "Beach Walk",
                "Golden sandy beach", "Sunset views",
                "Free entry", "Evening best"));
        bagaThings.add(new ThingItem(R.drawable.ic_food, "Beach Shacks",
                "Goan food & drinks", "Live music",
                "Nightlife nearby", "Crowded at night"));

        placesList.add(new Place(
                "Baga Beach",
                R.drawable.baga,
                R.drawable.baga,
                R.drawable.baga,
                "One of Goa’s most famous beaches known for nightlife and water sports.",
                "November to March",
                bagaThings,
                "Acron Waterfront, Casa Baga, Beach Street",
                "Beach, Nightlife, Water Sports",
                15.5520, 73.7517
        ));

        // 2️⃣ CALANGUTE BEACH
        ArrayList<ThingItem> calanguteThings = new ArrayList<>();
        calanguteThings.add(new ThingItem(R.drawable.ic_swim, "Swimming",
                "Safe swimming zone", "Lifeguards present",
                "Morning best", "Avoid high tides"));
        calanguteThings.add(new ThingItem(R.drawable.ic_jet_ski, "Jet Ski",
                "High speed ride", "Paid activity",
                "Short duration", "Safety gear mandatory"));

        placesList.add(new Place(
                "Calangute Beach",
                R.drawable.calangute,
                R.drawable.calangute,
                R.drawable.calangute,
                "Largest beach in North Goa with vibrant crowd and activities.",
                "November to March",
                calanguteThings,
                "Hard Rock Hotel, Casa De Goa",
                "Beach, Adventure, Shopping",
                15.5494, 73.7530
        ));

        // Attach Adapter
        adapter = new PlaceAdapter(this, placesList);
        recyclerPlaces.setLayoutManager(new LinearLayoutManager(this));
        recyclerPlaces.setAdapter(adapter);
    }
}
