package com.example.pingmeteo.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pingmeteo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.pingmeteo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

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
        Intent myIntent = new Intent(MainActivity.this, OptionActivity.class);
        myIntent.putExtra("DisplayedScreen", "test"); //Optional parameters
        MainActivity.this.startActivity(myIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_lieux, R.id.navigation_seuils)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);



    }

}