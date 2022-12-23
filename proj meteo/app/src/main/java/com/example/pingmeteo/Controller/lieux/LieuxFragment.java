package com.example.ping_meteo.Controller.lieux;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_meteo.Model.Datatype.IdType;
import com.example.ping_meteo.Model.Datatype.NomType;
import com.example.ping_meteo.Model.Lieu;
import com.example.ping_meteo.databinding.FragmentLieuxBinding;

import java.util.ArrayList;

public class LieuxFragment extends Fragment {

    private FragmentLieuxBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LieuxViewModel dashboardViewModel =
                new ViewModelProvider(this).get(LieuxViewModel.class);

        binding = FragmentLieuxBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<Lieu> your_array_list = new ArrayList<Lieu>();
        LieuViewAdapter adapter = new LieuViewAdapter(getContext(),your_array_list);
        Lieu newLieu = new Lieu(new IdType(6),new NomType("test"),null);

        ListView lv = binding.viewListLieux;
        lv.setAdapter(adapter);

        adapter.add(newLieu);
        newLieu.setNom(new NomType("oof"));
        adapter.add(newLieu);
        Lieu newLieu2 = new Lieu(new IdType(6),new NomType("test"),null);
        adapter.add(newLieu2);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lieu selectedItem = (Lieu) parent.getItemAtPosition(position);
                binding.LieuxLabel.setText("lieu selected: " + selectedItem.getNom().getValeur());
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