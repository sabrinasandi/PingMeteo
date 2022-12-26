package com.example.pingmeteo.Model.Datatype;

public class HourType {
    private int valeur;
    private final int LIMITE = 24;

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
