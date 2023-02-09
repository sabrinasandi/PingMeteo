package com.example.pingmeteo.View;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pingmeteo.R;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginActivity extends AppCompatActivity {

    Button butInscription, butLogin;
    TextView googleLogin, mdpOublié;
    EditText inputEmail, inputMdp;
    FirebaseAuth mAuth ;
    FirebaseUser mUser;

    String paterneEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.connection);
        butLogin = findViewById(R.id.connection_button);
        butInscription = findViewById(R.id.connection_gotoinscription);
        googleLogin = findViewById(R.id.connection_lblconnectgoogle);

        inputEmail = findViewById(R.id.connection_editTextEmailAddress);
        inputMdp = findViewById(R.id.connection_editTextPassword);
        mdpOublié = findViewById(R.id.connection_mdpforgotten);
        mdpOublié.setVisibility(View.INVISIBLE);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        butInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, GoogleSignInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connexion();

            }
        });


    }

    private void connexion() {
        String mail = inputEmail.getText().toString();
        String mdp = inputMdp.getText().toString();

        if (!mail.matches(paterneEmail)) {
            inputEmail.setError("Email non correct");
            inputEmail.requestFocus();
        } else if (mdp.isEmpty() || mdp.length() < 6) {
            inputMdp.setError("Mot de passe non correct");
        } else {
            mAuth.signInWithEmailAndPassword(mail, mdp).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        EnvoieSuite();
                        Toast.makeText(LoginActivity.this, "Bienvenue !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Erreur de connexion", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
    private void EnvoieSuite() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
