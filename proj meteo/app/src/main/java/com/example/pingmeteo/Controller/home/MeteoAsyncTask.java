package com.example.pingmeteo.Controller.home;

import android.os.AsyncTask;

import com.example.pingmeteo.Controller.CallMeteo;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.Météo;
import com.example.pingmeteo.databinding.FragmentHomeBinding;

public class MeteoAsyncTask extends AsyncTask<Lieu, Void, Météo> {
    private FragmentHomeBinding binding;

    public MeteoAsyncTask(FragmentHomeBinding binding) {
        this.binding = binding;
    }

    @Override
    protected Météo doInBackground(Lieu... params) {
        Lieu posactu = params[0];
        Météo météo = null;
        try {
            météo = CallMeteo.meteoActuel(posactu);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return météo;
    }

    @Override
    protected void onPostExecute(Météo meteo) {
        if (meteo != null) {
            binding.fragmentHomeTextPos.setText(meteo.getLieu().getNom().getValeur());
            binding.fragmentHomeTextTemp.setText(meteo.getTempérature().getValeur() + " °C");
            binding.fragmentHomeTextPluietype.setText("Le temps est " + meteo.getPluie().getDescriptionPluie());
        } else {
            binding.fragmentHomeTextPluietype.setText("Caught NullPointerException: ");
        }
    }
}
