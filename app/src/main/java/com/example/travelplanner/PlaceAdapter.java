package com.example.travelplanner;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    Context context;
    ArrayList<Place> placeList;

    public PlaceAdapter(Context context, ArrayList<Place> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_place, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {

        Place place = placeList.get(position);

        holder.txtPlaceName.setText(place.getName());
        holder.txtPlaceDesc.setText(place.getOverview());
        holder.imgPlace.setImageResource(place.getImage1());

        // Click Listener → Open details page
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, PlaceDetailsActivity.class);

            // Basic data
            intent.putExtra("name", place.getName());
            intent.putExtra("image1", place.getImage1());
            intent.putExtra("image2", place.getImage2());
            intent.putExtra("image3", place.getImage3());
            intent.putExtra("overview", place.getOverview());
            intent.putExtra("bestTime", place.getBestTime());
            intent.putExtra("hotels", place.getHotels());
            intent.putExtra("tags", place.getTags());

            // Lat/Lng
            intent.putExtra("lat", place.getLatitude());
            intent.putExtra("lng", place.getLongitude());

            // 🚨 Send the list of ThingsToDo
            intent.putExtra("thingsList", place.getThingsList());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPlace;
        TextView txtPlaceName, txtPlaceDesc;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPlace = itemView.findViewById(R.id.imgPlaceItem);
            txtPlaceName = itemView.findViewById(R.id.txtPlaceName);
            txtPlaceDesc = itemView.findViewById(R.id.txtPlaceDesc);
        }
    }
}
