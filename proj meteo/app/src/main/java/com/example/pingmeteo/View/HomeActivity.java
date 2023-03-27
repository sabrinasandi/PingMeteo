package com.example.pingmeteo.View;


import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pingmeteo.Controller.lieux.LieuViewAdapter;
import com.example.pingmeteo.Controller.seuils.SeuilViewAdapter;
import com.example.pingmeteo.Model.FirebaseConnexion;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.NotificationManager;
import com.example.pingmeteo.Model.Seuil;
import com.example.pingmeteo.R;
import com.example.pingmeteo.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private ActivityMainBinding binding;
    private LieuViewAdapter lieuAdapter;
    private SeuilViewAdapter seuilAdapter;
    private String userID;

    /** Called when the user touches the button */
    public void OpenOption(View view) {
        // Do something in response to button click
        Intent myIntent = new Intent(HomeActivity.this, OptionActivity.class);
        myIntent.putExtra("DisplayedScreen", "test"); //Optional parameters
        HomeActivity.this.startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }

        // Get the current user's ID
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        FirebaseConnexion.getInstance();

        //set up pour seuil
        NotificationManager notificationScheduler = new NotificationManager(this);
        notificationScheduler.setUpAlarm();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_lieux, R.id.navigation_seuils)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}
