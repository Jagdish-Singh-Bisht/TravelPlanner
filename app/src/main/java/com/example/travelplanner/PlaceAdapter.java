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
        holder.txtPlaceDesc.setText(place.getShortDesc());
        holder.imgPlace.setImageResource(place.getImage());


        // Click Listener
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PlaceDetailsActivity.class);
            intent.putExtra("name", place.getName());
            intent.putExtra("image", place.getImage());
            intent.putExtra("desc", place.getShortDesc());
            intent.putExtra("lat", place.getLatitude());
            intent.putExtra("lng", place.getLongitude());
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
