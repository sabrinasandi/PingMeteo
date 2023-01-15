package com.example.pingmeteo.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.pingmeteo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends Activity {

    TextView compteExistant1,compteExistant2,googleLogin, progression;

    EditText inputEmail, inputMdp, inputMdpConf;

    Button butRegister;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    String paterneEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        compteExistant1 = findViewById(R.id.inscription_lblReturnLogin);
        compteExistant2 = findViewById(R.id.inscription_lblConnexion);
        inputEmail = findViewById(R.id.inscription_editTextEmailAddress);
        inputMdp = findViewById(R.id.inscription_editTextPassword);
        inputMdpConf = findViewById(R.id.inscription_editTextPasswordConf);
        progression = findViewById(R.id.inscription_lblProgress);
        butRegister = findViewById(R.id.inscription_boutton);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progression.setVisibility(View.INVISIBLE);

        compteExistant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this  , LoginActivity.class));
            }
        });
        compteExistant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this  , LoginActivity.class));
            }
        });
        butRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthFireBsase();
            }
        });

    }

    private void AuthFireBsase() {
        String mail = inputEmail.getText().toString();
        String mdp = inputMdp.getText().toString();
        String mdpconf = inputMdpConf.getText().toString();

        if(!mail.matches(paterneEmail))
        {
            inputEmail.setError("Email non correct");
            inputEmail.requestFocus();
        }else if(mdp.isEmpty() || mdp.length()<6)
        {
            inputMdp.setError("Mot de passe non correct");

        }else if(!mdp.equals(mdpconf))
        {
            inputMdpConf.setError("Mots de passe non egaux");
        }else{

            progression.setVisibility(View.VISIBLE);
            progression.setText("Inscription");
            mAuth.createUserWithEmailAndPassword(mail,mdp).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        progression.setVisibility(View.INVISIBLE);
                        EnvoieSuite();
                        Toast.makeText(RegisterActivity.this, "Inscrit !", Toast.LENGTH_SHORT).show();
                    }else{
                        progression.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegisterActivity.this, "Erreur: "+task.getException(), Toast.LENGTH_LONG).show();
                    }
                }
            });



        }
    }

    private void EnvoieSuite() {
        Intent intent=new Intent(RegisterActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
