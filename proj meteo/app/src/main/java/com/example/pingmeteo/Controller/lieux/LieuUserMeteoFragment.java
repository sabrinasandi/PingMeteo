package com.example.pingmeteo.Controller.lieux;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import androidx.fragment.app.DialogFragment;
import com.example.pingmeteo.R;
import com.example.pingmeteo.Model.Météo;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.databinding.FragmentMeteoBinding;

import java.util.ArrayList;

public class LieuUserMeteoFragment extends DialogFragment {
    private ArrayList<Météo> meteo;
    private static Lieu lieuSelect;

    public static LieuUserMeteoFragment newInstance(Lieu place) {
        LieuUserMeteoFragment fragment = new LieuUserMeteoFragment();
        Bundle args = new Bundle();
        lieuSelect = place;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_meteo, null);
        FragmentMeteoBinding binding = FragmentMeteoBinding.bind(view);


        MeteoLieuAsyncTask task = new MeteoLieuAsyncTask(binding, getContext());
        task.execute(lieuSelect);
        builder.setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return builder.create();
    }
}

