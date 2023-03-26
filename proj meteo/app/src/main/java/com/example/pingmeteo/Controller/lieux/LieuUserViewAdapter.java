package com.example.pingmeteo.Controller.lieux;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.pingmeteo.Controller.lieux.LieuUserMeteoFragment;
import com.example.pingmeteo.Controller.CallMeteo;
import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.LieuUser;
import com.example.pingmeteo.Model.Météo;
import com.example.pingmeteo.R;

import java.util.ArrayList;

public class LieuUserViewAdapter extends ArrayAdapter<LieuUser> {
    public LieuUserViewAdapter(Context context, ArrayList<LieuUser> lieu) {
        super(context, 0, lieu);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final LieuUser place = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lieux, parent, false);
        }
        // Lookup view for data population
        TextView itemLieuTemp = (TextView) convertView.findViewById(R.id.itemlieutemp);
        itemLieuTemp.setText(FirebaseConnexion.getInstance().getSingleLieu(place.getIdLieu()).getNom().getValeur());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ArrayList<Météo> meteo = CallMeteo.meteoAVenir(FirebaseConnexion.getInstance().getSingleLieu(place.getIdLieu()));
                LieuUserMeteoFragment fragment = LieuUserMeteoFragment.newInstance(FirebaseConnexion.getInstance().getSingleLieu(place.getIdLieu()));
                fragment.show(((FragmentActivity) getContext()).getSupportFragmentManager(), "meteo_dialog");
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

}
