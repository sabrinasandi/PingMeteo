package com.example.pingmeteo.Controller.lieux;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.DialogFragment;

import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.LieuUser;
import com.example.pingmeteo.R;

import java.util.ArrayList;
/*
public class LieuxListFragment extends DialogFragment {

    private ArrayList<Lieu> lieuxList;
    private LieuViewAdapter lieuAdapter;
    private ListView lieuxListView;

    public LieuxListFragment(ArrayList<Lieu> lieuxList) {
        this.lieuxList = lieuxList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lieux, container, false);

        lieuxListView = view.findViewById(R.id.fragment_lieux_list_view);
        lieuAdapter = new LieuViewAdapter(getContext(), lieuxList);
        lieuxListView.setAdapter(lieuAdapter);

        Button cancelButton = view.findViewById(R.id.fragment_lieux_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lieuxListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Lieu selectedLieu = lieuAdapter.getItem(position);
                // Add the selected Lieu to the "LieuUser" list in Firebase
                // ...
                //FirebaseConnexion.getInstance().addLieuUser(selectedLieu);
                // Update the ListView in LieuxFragment with the updated "LieuUser" list
                // ...

                dismiss();
            }
        });
    }
}
*/