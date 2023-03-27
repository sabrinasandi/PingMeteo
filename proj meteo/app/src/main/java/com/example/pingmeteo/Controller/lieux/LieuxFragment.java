package com.example.pingmeteo.Controller.lieux;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;
import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.LieuUser;
import com.example.pingmeteo.databinding.FragmentLieuxBinding;

import java.util.ArrayList;

public class LieuxFragment extends Fragment {
    private FragmentLieuxBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LieuxViewModel dashboardViewModel = new ViewModelProvider((ViewModelStoreOwner) this).get(LieuxViewModel.class);

        binding = FragmentLieuxBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<LieuUser> lieux = FirebaseConnexion.getInstance().getLieuxUser();
        LieuUserViewAdapter adapter = new LieuUserViewAdapter(getContext(), lieux);

        ListView listView = binding.fragmentLieuxViewListLieux;
        listView.setAdapter(adapter);

        ImageButton addLieuButton = binding.fragmentLieuxLieuxAdd;
        addLieuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    NewLieuxFragment dialogFragment = new NewLieuxFragment();
                dialogFragment.show(getFragmentManager(), "New Lieux");
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Lieu selectedLieu = (Lieu) parent.getItemAtPosition(position);
            TextView lieuxLabel = binding.fragmentLieuxLieuxLabel;
            lieuxLabel.setText("Lieu selected: " + selectedLieu.getNom().getValeur());
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
