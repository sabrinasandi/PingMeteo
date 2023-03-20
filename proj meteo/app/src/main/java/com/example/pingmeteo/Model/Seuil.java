package com.example.pingmeteo.Model;

import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;

public class Seuil {
    public String userId;
    private IdType id;
    private NomType nom;
    private int Valeur; // a check
    private NomType type;
    private  IdType LieuID;

    public String getUserId() {
        return userId;
    }

    public IdType getLieuID() {
        return LieuID;
    }

    public void setLieuID(IdType lieuID) {
        LieuID = lieuID;
    }

    public Seuil() {
        // Default constructor required for calls to DataSnapshot.getValue(Seuil.class)
    }

    public Seuil(String user, IdType idType, NomType test, int valeur, NomType typeDeSeuil, IdType IdDuLieu) {
        userId = userId;
        id = idType;
        nom = test;
        Valeur = valeur;
        type = new NomType("TEMP");// plus tard sera typeDeSeuil
        LieuID = IdDuLieu;
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public NomType getNom() {
        return nom;
    }

    public void setNom(NomType nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return Valeur;
    }

    public void setValeur(int valeur) {
        Valeur = valeur;
    }

    public NomType getType() {
        return type;
    }

    public void setType(NomType type) {
        this.type = type;
    }

    public boolean checkCondition() {
        // check condition seuil
        return true;
    }

    public String getMessage() {
        return "Seuil" + nom.getValeur()+ " Triggered";
    }
}
