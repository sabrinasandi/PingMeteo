package com.example.pingmeteo.Controller.lieux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.LieuUser;
import com.example.pingmeteo.R;

import java.util.ArrayList;

public class LieuUserViewAdapter extends ArrayAdapter<LieuUser> {
    public LieuUserViewAdapter(Context context, ArrayList<LieuUser> lieu) {
        super(context, 0, lieu);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        LieuUser place = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lieux, parent, false);
        }
        // Lookup view for data population
        TextView itemLieuTemp = (TextView) convertView.findViewById(R.id.itemlieutemp);
        itemLieuTemp.setText(FirebaseConnexion.getInstance().getSingleLieu(place.getIdLieu()).getNom().getValeur());

        convertView.setTag(place); // Add this line to set the LieuUser object as a tag

        // Return the completed view to render on screen
        return convertView;
    }
}