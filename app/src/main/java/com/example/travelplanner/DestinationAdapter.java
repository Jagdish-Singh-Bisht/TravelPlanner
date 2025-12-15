package com.example.travelplanner;


//Create Adapter for RecyclerView

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



public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {

    Context context;
    ArrayList<Destination> list;

    public DestinationAdapter(Context context, ArrayList<Destination> list){
        this.context= context;
        this.list= list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_destination, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Destination d= list.get(position);
        holder.txtName.setText(d.getName());
        holder.img.setImageResource(d.getImage());

        /*
        // Click Listener -> Open Details Screen
        holder.itemView.setOnClickListener(v -> {
            Intent intent= new Intent(context, DetailsActivity.class);
            intent.putExtra("name", d.getName());
            intent.putExtra("image", d.getImage());
            context.startActivity(intent);
        });
        */

        /* i replace this clickListener with next one

        holder.itemView.setOnClickListener(v -> {

            if (d.getName().equals("Uttarakhand")) {

                Intent intent = new Intent(context, UttarakhandPlacesActivity.class);
                context.startActivity(intent);

            } else {

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", d.getName());
                intent.putExtra("image", d.getImage());
                context.startActivity(intent);

            }

        });
        */

        holder.itemView.setOnClickListener(v -> {

            Intent intent;

            switch (d.getName()) {

                case "Uttarakhand":
                    intent = new Intent(context, UttarakhandPlacesActivity.class);
                    break;

                case "Goa":
                    intent = new Intent(context, GoaPlacesActivity.class);
                    break;

                case "Manali":
                    intent = new Intent(context, ManaliPlacesActivity.class);
                    break;

                case "Jaipur":
                    intent = new Intent(context, JaipurPlacesActivity.class);
                    break;

                case "Delhi":
                    intent = new Intent(context, DelhiPlacesActivity.class);
                    break;

                default:
                    intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("name", d.getName());
                    intent.putExtra("image", d.getImage());
                    break;
            }

            context.startActivity(intent);
        });

    }


    @Override
    public int getItemCount(){
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtName;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            img= itemView.findViewById(R.id.imgDestination);
            txtName= itemView.findViewById(R.id.txtDestinationName);
        }
    }

}
