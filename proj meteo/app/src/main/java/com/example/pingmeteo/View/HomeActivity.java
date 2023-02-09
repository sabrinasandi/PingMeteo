package com.example.pingmeteo.View;

import static com.example.pingmeteo.Controller.CallMeteo.meteoActuel;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.pingmeteo.Controller.CallMeteo;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.Météo;
import com.example.pingmeteo.R;
import com.example.pingmeteo.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private ActivityMainBinding binding;
    TextView posText, tempText, pluieText;
    /*OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(action));
        }
    };

    Button button = (Button) findViewById(id);
        button.setOnClickListener(onClickListener);*/

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




        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_lieux, R.id.navigation_seuils)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);







        /*
        List<Person> people = new ArrayList<>();
        people.add(new Person("John Doe", 30));
        people.add(new Person("Jane Doe", 25));

        DatabaseReference myRef = database.getReference("users").child(userId);
        myRef.child("people").setValue(people);
        myRef.child("people").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Person> people = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Person person = snapshot.getValue(Person.class);
                    people.add(person);
                }
                // Do something with the people list
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle errors
            }
        });
        */

    }

}