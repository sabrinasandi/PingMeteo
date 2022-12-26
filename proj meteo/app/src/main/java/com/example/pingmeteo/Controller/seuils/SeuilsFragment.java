package com.example.pingmeteo.Controller.seuils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pingmeteo.Controller.lieux.LieuViewAdapter;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.Seuil;
import com.example.pingmeteo.databinding.FragmentSeuilsBinding;

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