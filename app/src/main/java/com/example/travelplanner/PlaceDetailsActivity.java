package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetailsActivity extends AppCompatActivity {

    ImageView imgPlaceLarge;
    TextView txtPlaceTitle, txtPlaceDescLarge;
    TextView txtBestTime, txtThingsToDo, txtHotels;
    Button btnOpenMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.placeToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(""); // title will come from layout

        toolbar.setNavigationOnClickListener(v -> onBackPressed());


        // Initialize Views
        imgPlaceLarge = findViewById(R.id.imgPlaceLarge);
        txtPlaceTitle = findViewById(R.id.txtPlaceTitle);
        txtPlaceDescLarge = findViewById(R.id.txtPlaceDescLarge);
        txtBestTime = findViewById(R.id.txtBestTime);
        txtThingsToDo = findViewById(R.id.txtThingsToDo);
        txtHotels = findViewById(R.id.txtHotels);
        btnOpenMap = findViewById(R.id.btnOpenMap);

        // Get Data From Intent
        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);
        String desc = getIntent().getStringExtra("desc");
        double lat = getIntent().getDoubleExtra("lat", 0);
        double lng = getIntent().getDoubleExtra("lng", 0);

        // Set Data to UI
        txtPlaceTitle.setText(name);
        txtPlaceDescLarge.setText(desc);
        imgPlaceLarge.setImageResource(image);

        // Set dynamic data for each place
        switch (name) {

            case "Rishikesh":
                txtBestTime.setText("September to November and March to May");
                txtThingsToDo.setText("• River Rafting\n• Ganga Aarti\n• Yoga Sessions\n• Neergarh Waterfall");
                txtHotels.setText("• Aloha on the Ganges\n• Live Free Hostel\n• Ganga Kinare");
                break;

            case "Mussoorie":
                txtBestTime.setText("April to June and September to November");
                txtThingsToDo.setText("• Mall Road Walk\n• Kempty Falls\n• Gun Hill Ropeway\n• Lal Tibba Viewpoint");
                txtHotels.setText("• JW Marriott\n• Rokeby Manor\n• Hotel Vishnu Palace");
                break;

            case "Nainital":
                txtBestTime.setText("March to June and October to December");
                txtThingsToDo.setText("• Boating in Naini Lake\n• Naina Peak Trek\n• Eco Cave Gardens\n• Snow View Point");
                txtHotels.setText("• Manu Maharani\n• Seasons Resort\n• Nainital Palace");
                break;

            case "Dehradun":
                txtBestTime.setText("March to June");
                txtThingsToDo.setText("• Robber’s Cave\n• FRI Museum\n• Tapkeshwar Temple\n• Sahastradhara");
                txtHotels.setText("• Lemon Tree Hotel\n• Clarion Hotel\n• Hotel Saffron Leaf");
                break;

            case "Jim Corbett":
                txtBestTime.setText("November to February (best for safari)");
                txtThingsToDo.setText("• Jeep Safari\n• Bird Watching\n• Garjia Temple\n• Corbett Falls");
                txtHotels.setText("• Corbett Riverside\n• Taj Corbett Resort\n• Tiger Camp Resort");
                break;

            case "Auli":
                txtBestTime.setText("December to February (snow), March to June (pleasant)");
                txtThingsToDo.setText("• Skiing\n• Ropeway Ride\n• Gorson Bugyal Trek\n• Snow Activities");
                txtHotels.setText("• Blue Poppy Resort\n• Clifftop Club\n• Kuber Resort");
                break;

            case "Kedarnath":
                txtBestTime.setText("May to June and September to October");
                txtThingsToDo.setText("• Kedarnath Temple\n• Vasuki Tal Trek\n• Bhairavnath Temple");
                txtHotels.setText("• GMVN Kedarnath\n• Lodges at Sitapur/Sonprayag");
                break;

            case "Valley of Flowers":
                txtBestTime.setText("July to September (flowers bloom)");
                txtThingsToDo.setText("• Valley Trek\n• Hemkund Sahib Trek\n• Photography\n• Bird Watching");
                txtHotels.setText("• Hotels in Ghangaria\n• GMVN Guest Houses");
                break;

            case "Tungnath":
                txtBestTime.setText("April to June and September to November");
                txtThingsToDo.setText("• Tungnath Temple\n• Chandrashila Summit Trek\n• Snow Trek\n• Sunrise View");
                txtHotels.setText("• Chopta Camps\n• Magpie Camp\n• Snow View Resort");
                break;
        }

        // Open Location in Google Maps
        btnOpenMap.setOnClickListener(v -> {
            String uri = "geo:" + lat + "," + lng + "?q=" + lat + "," + lng + "(" + name + ")";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });
    }
}
