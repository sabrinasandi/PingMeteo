package com.example.pingmeteo.Model;

import androidx.annotation.NonNull;

import com.example.pingmeteo.Controller.lieux.LieuViewAdapter;
import com.example.pingmeteo.Controller.seuils.SeuilViewAdapter;
import com.example.pingmeteo.Model.Datatype.GPSType;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
public class FirebaseConnexion {
    private FirebaseAuth mAuth;
    private DatabaseReference rootRef;
    private ArrayList<Lieu> lieux;
    private ArrayList<LieuUser> lieuxUser;
    private ArrayList<Seuil> seuils;
    private static FirebaseConnexion instance;

    public static FirebaseConnexion getInstance() {
        if (instance == null) {
            instance = new FirebaseConnexion();
        }
        return instance;
    }
    public FirebaseConnexion() {
        mAuth = FirebaseAuth.getInstance();
        rootRef = FirebaseDatabase.getInstance().getReference();
        lieux = new ArrayList<>();
        lieuxUser = new ArrayList<>();
        seuils = new ArrayList<>();
        initializeData();
    }

    public void addLieuUser(Lieu lieu) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference lieuxRef = rootRef.child("users").child(userId).child("lieux");
            long lieuId = lieu.getId().getValeur();
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/LieuUsers/" + userId + "/" + lieuId, true);
            rootRef.updateChildren(childUpdates);
        }
    }
    public void addSeuil(Seuil seuil) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference seuilsRef = rootRef.child("seuils").child(userId);
        seuilsRef.push().setValue(seuil);
    }


    public ArrayList<Lieu> getLieux() {
        return lieux;
    }

    public ArrayList<LieuUser> getLieuxUser() {
        return lieuxUser;
    }

    public ArrayList<Seuil> getSeuils() {
        return seuils;
    }

    public void initializeData() {
        rootRef.child("lieux").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lieux.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                   // System.out.println("Creating new Lieu object" + postSnapshot.toString());
                    try {

                        int idVal = postSnapshot.child("id").getValue(Integer.class);
                        String nomVal = postSnapshot.child("nom").getValue(String.class);
                        double latitudeVal = Double.parseDouble(postSnapshot.child("position").child("latitude").getValue(String.class));
                        double longitudeVal = Double.parseDouble(postSnapshot.child("position").child("longitude").getValue(String.class));
                        if (idVal != 0 && nomVal != null && latitudeVal != 0 && longitudeVal != 0) {
                            IdType id = new IdType(idVal);
                            NomType nom = new NomType(nomVal);
                            GPSType position = new GPSType(latitudeVal, longitudeVal);

                            Lieu lieu = new Lieu(id, nom, position);
                            lieux.add(lieu);
                        }
                    } catch (NumberFormatException e) {
                        //System.out.println("Error:" + postSnapshot.toString());
                        continue;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle the error
            }
        });

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            rootRef.child("LieuUsers").child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    lieuxUser.clear();
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        //System.out.println("Creating new LieuUser object" + postSnapshot.toString());
                        try {
                            int LieuID = Integer.parseInt(postSnapshot.getKey());
                            String userID = dataSnapshot.getRef().getParent().getKey();
                            boolean value = postSnapshot.getValue(Boolean.class);

                            if (value) {
                                IdType idLieu = new IdType(LieuID);
                                LieuUser lieuUser = new LieuUser(idLieu, userID);
                                lieuxUser.add(lieuUser);
                            }
                        } catch (Exception e) {
                            System.out.println("Error:" + postSnapshot.toString());
                            continue;
                        }
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle error
                }
            });
            rootRef.child("seuils").child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    seuils.clear();
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        try {
                            Integer idVal = postSnapshot.child("id").child("valeur").getValue(Integer.class);
                            String nomVal = postSnapshot.child("nom").child("valeur").getValue(String.class);
                            Integer valeurVal = postSnapshot.child("valeur").getValue(Integer.class);
                            String typeVal = postSnapshot.child("type").child("valeur").getValue(String.class);
                            Integer lieuIDVal = postSnapshot.child("lieuID").child("valeur").getValue(Integer.class);

                            if (idVal != null && nomVal != null && valeurVal != null && typeVal != null && lieuIDVal != null) {
                                IdType id = new IdType(idVal);
                                NomType nom = new NomType(nomVal);
                                NomType type = new NomType(typeVal);
                                IdType lieuID = new IdType(lieuIDVal);
                                Seuil seuil = new Seuil(userId, id, nom, valeurVal, type, lieuID);
                                seuils.add(seuil);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error:" + postSnapshot.toString());
                            continue;
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error
                }
            });
        }

    }

    public Lieu getSingleLieu(IdType valeur) {
        return this.lieux.get(valeur.getValeur() - 1);
    }
}




