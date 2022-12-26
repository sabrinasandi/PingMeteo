package com.example.pingmeteo.Controller.seuils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pingmeteo.Model.Seuil;
import com.example.pingmeteo.R;

import java.util.ArrayList;

public class SeuilViewAdapter extends ArrayAdapter<Seuil> {
    public SeuilViewAdapter(Context context, ArrayList<Seuil> Seuils) {
        super(context, 0, Seuils);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Seuil limite = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_seuils, parent, false);
        }
        // Lookup view for data population
        TextView itemSeuilName = (TextView) convertView.findViewById(R.id.itemSeuilName);
        TextView itemSeuiltemp = (TextView) convertView.findViewById(R.id.itemSeuiltemp);
        // Populate the data into the template view using the data object
        itemSeuilName.setText(limite.getNom().getValeur());//
        itemSeuiltemp.setText("toto");//
        // Return the completed view to render on screen
        return convertView;
    }
}