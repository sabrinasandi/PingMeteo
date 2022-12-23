package com.example.ping_meteo.Model.Datatype;

public class TemperatureType {

    private int valeur;

    private TemperatureUnit unite;

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public TemperatureUnit getUnite() {
        return unite;
    }

    public void setUnite(TemperatureUnit unite) {
        this.unite = unite;
    }
}
