package com.example.pingmeteo.Model.Datatype;

public class Text {
    private String valeur;

    public Text(String s){
        valeur = s;
    }
    public Text(){

    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
