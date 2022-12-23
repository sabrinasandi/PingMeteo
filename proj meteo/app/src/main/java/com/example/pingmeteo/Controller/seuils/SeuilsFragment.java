package com.example.ping_meteo.Controller.seuils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ping_meteo.Controller.lieux.LieuViewAdapter;
import com.example.ping_meteo.Model.Datatype.IdType;
import com.example.ping_meteo.Model.Datatype.NomType;
import com.example.ping_meteo.Model.Lieu;
import com.example.ping_meteo.Model.Seuil;
import com.example.ping_meteo.databinding.FragmentSeuilsBinding;

import java.util.ArrayList;

public class SeuilsFragment extends Fragment {

    private FragmentSeuilsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SeuilsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(SeuilsViewModel.class);

        binding = FragmentSeuilsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.SeuilLabel;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        ArrayList<Seuil> your_array_list = new ArrayList<Seuil>();
        SeuilViewAdapter adapter = new SeuilViewAdapter(getContext(),your_array_list);
        Seuil newSeuil = new Seuil(new IdType(6),new NomType("test"));

        ListView lv = binding.viewListSeuils;
        lv.setAdapter(adapter);

        adapter.add(newSeuil);
        adapter.add(newSeuil);
        adapter.add(newSeuil);
        adapter.add(newSeuil);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}