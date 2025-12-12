package com.example.travelplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView imgPlace;
    TextView txtTitle, txtPacking, txtFood, txtRoutes, txtHotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgPlace = findViewById(R.id.imgPlace);
        txtTitle = findViewById(R.id.txtTitle);
        txtPacking = findViewById(R.id.txtPacking);
        txtFood = findViewById(R.id.txtFood);
        txtRoutes = findViewById(R.id.txtRoutes);
        txtHotels = findViewById(R.id.txtHotels);

        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);

        txtTitle.setText(name);
        imgPlace.setImageResource(image);

        // Now we add content based on destination
        switch (name) {

            case "Uttarakhand":
                txtPacking.setText("• Warm clothes\n• Trekking shoes\n• Medicines\n• Raincoat");
                txtFood.setText("• Kafuli\n• Bhatt ki Churkani\n• Aloo ke gutke");
                txtRoutes.setText("Reach by: Dehradun Airport, Haridwar Railway Station, NH7 Road route.");
                txtHotels.setText("Recommended areas: Rishikesh, Mussoorie, Nainital.");
                break;

            case "Goa":
                txtPacking.setText("• Beach wear\n• Sunscreen\n• Sunglasses\n• Powerbank");
                txtFood.setText("• Goan Fish Curry\n• Bebinca\n• Vindaloo");
                txtRoutes.setText("Reach by: Dabolim Airport, Madgaon Railway Station.");
                txtHotels.setText("Recommended: Calangute, Baga, Panaji.");
                break;

            case "Delhi":
                txtPacking.setText("• Light clothes (summer)\n• Jacket (winters)\n• Water bottle");
                txtFood.setText("• Chole Bhature\n• Momos\n• Paranthas (Chandni Chowk)");
                txtRoutes.setText("Reach by: IGI Airport, New Delhi Railway Station.");
                txtHotels.setText("Stay near: Karol Bagh, Connaught Place.");
                break;

            case "Manali":
                txtPacking.setText("• Heavy jackets\n• Gloves\n• Snow boots\n• Medicine kit");
                txtFood.setText("• Siddu\n• Thukpa\n• Trout Fish");
                txtRoutes.setText("Reach by: Bhuntar Airport, Volvo bus from Delhi/Chandigarh.");
                txtHotels.setText("Recommended: Old Manali, Mall Road.");
                break;

            case "Jaipur":
                txtPacking.setText("• Light cotton clothes\n• Sunglasses\n• Hat");
                txtFood.setText("• Dal Baati Churma\n• Ghewar\n• Pyaaz Kachori");
                txtRoutes.setText("Reach by: Jaipur Airport, Jaipur Junction.");
                txtHotels.setText("Stay near: Bani Park, MI Road.");
                break;
        }
    }
}
