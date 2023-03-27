package com.example.pingmeteo.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.pingmeteo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.pingmeteo.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        startActivity(new Intent(MainActivity.this  , LoginActivity.class));




    }

}