package com.example.travelplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThingsAdapter extends RecyclerView.Adapter<ThingsAdapter.ViewHolder> {

    Context context;
    ArrayList<ThingItem> list;

    public ThingsAdapter(Context context, ArrayList<ThingItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_thing, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ThingItem item = list.get(position);

        holder.icon.setImageResource(item.getIcon());
        holder.title.setText(item.getTitle());

        holder.line1.setText(item.getLine1());
        holder.line2.setText(item.getLine2());
        holder.line3.setText(item.getLine3());
        holder.line4.setText(item.getLine4());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title, line1, line2, line3, line4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.thingIcon);
            title = itemView.findViewById(R.id.thingTitle);
            line1 = itemView.findViewById(R.id.line1);
            line2 = itemView.findViewById(R.id.line2);
            line3 = itemView.findViewById(R.id.line3);
            line4 = itemView.findViewById(R.id.line4);
        }
    }
}
