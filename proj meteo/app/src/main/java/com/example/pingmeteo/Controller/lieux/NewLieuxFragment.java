package com.example.pingmeteo.Controller.lieux;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.R;

import java.util.ArrayList;
public class NewLieuxFragment extends DialogFragment {

    private ListView lieuxListView;
    private Button cancelButton;

    public NewLieuxFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nouveau_lieu, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Lieu> lieux = FirebaseConnexion.getInstance().getLieux();
        LieuViewAdapter adapter = new LieuViewAdapter(getContext(), lieux);

        lieuxListView = view.findViewById(R.id.fragment_addlieux_view_list_lieux);
        lieuxListView.setAdapter(adapter);
        lieuxListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lieu selectedLieu = (Lieu) parent.getItemAtPosition(position);
                FirebaseConnexion.getInstance().addLieuUser(selectedLieu);
            }
        });

        cancelButton = view.findViewById(R.id.fragment_addlieux_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
