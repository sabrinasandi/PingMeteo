package com.example.pingmeteo.Controller.seuils;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pingmeteo.Controller.lieux.LieuViewAdapter;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;
import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.Seuil;
import com.example.pingmeteo.databinding.FragmentSeuilsBinding;

import java.util.ArrayList;

public class SeuilsFragment extends Fragment {

    private FragmentSeuilsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SeuilsViewModel notificationsViewModel =new ViewModelProvider(this).get(SeuilsViewModel.class);

        binding = FragmentSeuilsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        ArrayList<Seuil> seuils = FirebaseConnexion.getInstance().getSeuils();
        SeuilViewAdapter adapter = new SeuilViewAdapter(getContext(),seuils);

        ListView lv = binding.viewListSeuils;
        lv.setAdapter(adapter);
        ImageButton seuilAdd = binding.SeuilAdd;
        seuilAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SeuilFormActivity seuilForm = new SeuilFormActivity();
                seuilForm.show(getActivity().getSupportFragmentManager(), "Seuil Form");
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}