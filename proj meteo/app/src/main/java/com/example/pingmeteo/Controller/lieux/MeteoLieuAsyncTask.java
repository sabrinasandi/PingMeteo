package com.example.pingmeteo.Controller.lieux;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pingmeteo.Controller.CallMeteo;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.Météo;
import com.example.pingmeteo.R;
import com.example.pingmeteo.databinding.FragmentMeteoBinding;

import java.util.ArrayList;

public class MeteoLieuAsyncTask  extends AsyncTask<Lieu, Void, ArrayList<Météo>> {
    private FragmentMeteoBinding binding;
    private Context context;

    public MeteoLieuAsyncTask(FragmentMeteoBinding binding, Context context) {
        this.binding = binding;
        this.context = context;
    }


    @Override
    protected ArrayList<Météo> doInBackground(Lieu... params) {
        Lieu posactu = params[0];
        ArrayList<Météo> météo = null;
        try {
            météo = CallMeteo.meteoAVenir(posactu);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return météo;
    }

    @Override
    protected void onPostExecute(ArrayList<Météo> meteo) {
        //fill the listview

        ListView listView = binding.fragmentMeteoListMeteo;
        MeteoListAdapter adapter = new MeteoListAdapter(context, meteo);
        listView.setAdapter(adapter);
    }
}
