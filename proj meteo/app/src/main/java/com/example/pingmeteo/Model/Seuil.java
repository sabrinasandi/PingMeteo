package com.example.pingmeteo.Model;

import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;

public class Seuil {
    private IdType id;
    private NomType nom;
    private int Valeur; // a check
    private NomType type;

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
}
