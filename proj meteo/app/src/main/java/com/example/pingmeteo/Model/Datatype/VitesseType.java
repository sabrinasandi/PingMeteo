package com.example.pingmeteo.Model.Datatype;

public class VitesseType {
    private int valeur;
    private int degreVent;
    private VitesseUnit unite;
    public VitesseType(Object key){

    }
    public VitesseType(int valeur,int degreVent){
        this.valeur=valeur;
        this.degreVent=degreVent;

    }

    public int getValeur() {
        return valeur;
    }

    public int getDegreVent() {
        return degreVent;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public VitesseUnit getUnite() {
        return unite;
    }

    public void setUnite(VitesseUnit unite) {
        this.unite = unite;
    }


}
