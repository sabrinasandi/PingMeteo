package com.example.pingmeteo.Controller.seuils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.pingmeteo.Controller.lieux.LieuUserViewAdapter;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;
import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.LieuUser;
import com.example.pingmeteo.Model.Seuil;
import com.example.pingmeteo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SeuilFormActivity extends DialogFragment {

    private EditText nomEditText;
    private TextView ValeurText;
    private SeekBar ValeurSeekBar;
    private Spinner typeSpinner;
    private Button submitButton;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_seuil_form, null);


        Spinner lieuSpinner = view.findViewById(R.id.fragment_seuil_form_spinner_SeuilFormLieuID);
        ArrayAdapter<LieuUser> adapter = new ArrayAdapter<LieuUser>(getContext(), R.layout.custom_spinner_item, FirebaseConnexion.getInstance().getLieuxUser());
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        lieuSpinner.setAdapter(adapter);

        nomEditText = view.findViewById(R.id.fragment_seuil_form_editText_SeuilFormNom);
        ValeurSeekBar = view.findViewById(R.id.fragment_seuil_form_seekBar_SeuilFormValeur);
        ValeurText = view.findViewById(R.id.fragment_seuil_form_textView_SeuilFormValeur);
        ValeurSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ValeurText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });


        typeSpinner = view.findViewById(R.id.fragment_seuil_form_spinner_SeuilFormType);
        submitButton = view.findViewById(R.id.fragment_seuil_form_button_SeuilFormSave);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser != null) {
                    String userId = currentUser.getUid();
                    String nom = nomEditText.getText().toString();
                    int Valeur = ValeurSeekBar.getProgress();
                    String type = typeSpinner.getSelectedItem().toString();
                    // Code to get LieuID based on the user's selection


                    // Get the selected LieuUser object from the spinner
                    LieuUser selectedLieuUser = (LieuUser) lieuSpinner.getSelectedItem();

                    int LieuID = selectedLieuUser.getIdLieu().getValeur(); // Get LieuID from the selected LieuUser

                    Seuil seuil = new Seuil(userId, new IdType(FirebaseConnexion.getInstance().getSeuils().size()), new NomType(nom), Valeur, new NomType(type), new IdType(LieuID));
                    FirebaseConnexion.getInstance().addSeuil(seuil);

                    // Code to go back to the previous activity or fragment
                }
            }
        });

        builder.setView(view);
        return builder.create();
    }
}
