package com.example.pingmeteo.Controller.lieux;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pingmeteo.Controller.home.MeteoAsyncTask;
import com.example.pingmeteo.Model.Météo;
import com.example.pingmeteo.R;

import java.util.ArrayList;

public class MeteoListAdapter extends ArrayAdapter<Météo> {

    public MeteoListAdapter(Context context, ArrayList<Météo> meteos) {
        super(context, 0, meteos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Météo meteo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_meteo, parent, false);
        }
        // Lookup view for data population
        TextView dateTextView = convertView.findViewById(R.id.item_meteo_date_text_view);
        TextView temperatureTextView = convertView.findViewById(R.id.item_meteo_temperature_text_view);

        // Populate the data into the template view using the data object
        dateTextView.setText(meteo.getDateToString());
        temperatureTextView.setText(Integer.toString(meteo.getTempérature().getValeur()));

        // Return the completed view to render on screen
        return convertView;
    }
}
