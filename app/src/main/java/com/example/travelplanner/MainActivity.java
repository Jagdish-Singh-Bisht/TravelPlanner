package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Destination> list;
    DestinationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerDestinations);

        list = new ArrayList<>();

        // Add destinations (with images from drawable)
        list.add(new Destination("Uttarakhand", R.drawable.uttarakhand));
        list.add(new Destination("Goa", R.drawable.goa));
        list.add(new Destination("Delhi", R.drawable.delhi));
        list.add(new Destination("Manali", R.drawable.manali));
        list.add(new Destination("Jaipur", R.drawable.jaipur));

        adapter = new DestinationAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
