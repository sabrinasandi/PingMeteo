package com.example.pingmeteo.Controller.lieux;

import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.databinding.FragmentLieuxBinding;

import java.util.ArrayList;

public abstract class LieuxFragment extends Fragment {

    private FragmentLieuxBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LieuxViewModel dashboardViewModel =
                new ViewModelProvider((ViewModelStoreOwner) this).get(LieuxViewModel.class);

        binding = FragmentLieuxBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<Lieu> your_array_list = new ArrayList<Lieu>();
        LieuViewAdapter adapter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            adapter = new LieuViewAdapter(getContext(),your_array_list);
        }
        Lieu newLieu = new Lieu(new IdType(6),new NomType("test"),null);

        ListView lv = binding.fragmentLieuxViewListLieux;
        lv.setAdapter(adapter);
        ImageButton addLieu = binding.fragmentLieuxLieuxAdd;

        adapter.add(newLieu);
        newLieu.setNom(new NomType("oof"));
        adapter.add(newLieu);
        Lieu newLieu2 = new Lieu(new IdType(6),new NomType("test"),null);
        adapter.add(newLieu2);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lieu selectedItem = (Lieu) parent.getItemAtPosition(position);
                binding.fragmentLieuxLieuxLabel.setText("lieu selected: " + selectedItem.getNom().getValeur());
            }
        });
        addLieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewLieuxFragment dialogFragment = new NewLieuxFragment();
                dialogFragment.show(getFragmentManager(), "dialog");
            }
        });
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public abstract Dialog onCreateDialog(Bundle savedInstanceState);
}