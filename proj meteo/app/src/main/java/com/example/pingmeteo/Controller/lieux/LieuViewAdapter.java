package com.example.ping_meteo.Controller.lieux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ping_meteo.Model.Lieu;
import com.example.ping_meteo.R;

import java.util.ArrayList;

public class LieuViewAdapter extends ArrayAdapter<Lieu> {
    public LieuViewAdapter(Context context, ArrayList<Lieu> lieux) {
        super(context, 0, lieux);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Lieu place = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lieux, parent, false);
        }
        // Lookup view for data population
        TextView itemLieuName = (TextView) convertView.findViewById(R.id.itemlieuName);
        TextView itemLieuTemp = (TextView) convertView.findViewById(R.id.itemlieutemp);
        // Populate the data into the template view using the data object
        itemLieuName.setText(place.getNom().getValeur());//
        itemLieuTemp.setText("test");//
        // Return the completed view to render on screen
        return convertView;
    }
}