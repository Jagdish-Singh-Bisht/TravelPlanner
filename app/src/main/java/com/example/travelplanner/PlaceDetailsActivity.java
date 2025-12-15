package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class PlaceDetailsActivity extends AppCompatActivity {

    String name, overview, bestTime, hotels, tags;
    int image;
    double lat, lng;

    ArrayList<ThingItem> thingsList;   // <-- IMPORTANT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.placeToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Receive Data
        name = getIntent().getStringExtra("name");
        image = getIntent().getIntExtra("image", 0);

        overview = getIntent().getStringExtra("overview");
        bestTime = getIntent().getStringExtra("bestTime");
        hotels = getIntent().getStringExtra("hotels");
        tags = getIntent().getStringExtra("tags");

        lat = getIntent().getDoubleExtra("lat", 0);
        lng = getIntent().getDoubleExtra("lng", 0);

        // RECEIVE THINGS LIST
        thingsList = (ArrayList<ThingItem>) getIntent().getSerializableExtra("thingsList");

        // Tabs
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Overview").setIcon(R.drawable.ic_overview));
        tabLayout.addTab(tabLayout.newTab().setText("Things To Do").setIcon(R.drawable.ic_things));

        // Default Tab
        loadOverview();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    loadOverview();
                } else {
                    loadThingsToDo();
                }
            }
            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    // --------------------------
    // LOAD OVERVIEW TAB
    // --------------------------
    private void loadOverview() {
        FrameLayout tabContainer = findViewById(R.id.tabContainer);
        tabContainer.removeAllViews();

        getLayoutInflater().inflate(R.layout.layout_overview, tabContainer, true);

        ImageView img = findViewById(R.id.imgPlaceLarge);
        TextView title = findViewById(R.id.txtPlaceTitle);
        TextView desc = findViewById(R.id.txtPlaceDescLarge);
        TextView tBest = findViewById(R.id.txtBestTime);
        TextView tHotels = findViewById(R.id.txtHotels);
        Button btnOpen = findViewById(R.id.btnOpenMap);

        img.setImageResource(image);
        title.setText(name);
        desc.setText(overview);
        tBest.setText(bestTime);
        tHotels.setText(hotels);

        btnOpen.setOnClickListener(v -> {
            String uri = "geo:" + lat + "," + lng + "?q=" + lat + "," + lng + "(" + name + ")";
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
    }

    // --------------------------
    // LOAD THINGS TO DO TAB
    // --------------------------
    private void loadThingsToDo() {
        FrameLayout tabContainer = findViewById(R.id.tabContainer);
        tabContainer.removeAllViews();

        getLayoutInflater().inflate(R.layout.layout_things_to_do, tabContainer, true);

        // 1️⃣ Setup Chips (Famous For)
        ChipGroup chipGroup = findViewById(R.id.chipGroupTags);

        if (tags != null && !tags.isEmpty()) {
            String[] tagArray = tags.split(",");

            for (String tag : tagArray) {
                Chip chip = new Chip(this);
                chip.setText(tag.trim());
                chip.setChipBackgroundColorResource(R.color.purple_200);
                chip.setTextColor(getResources().getColor(android.R.color.white));
                chip.setClickable(false);
                chip.setCheckable(false);

                chipGroup.addView(chip);
            }
        }

        // 2️⃣ RecyclerView for Things To Do
        RecyclerView recycler = findViewById(R.id.recyclerThings);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        if (thingsList == null)
            thingsList = new ArrayList<>();

        ThingsAdapter adapter = new ThingsAdapter(this, thingsList);
        recycler.setAdapter(adapter);
    }
}
