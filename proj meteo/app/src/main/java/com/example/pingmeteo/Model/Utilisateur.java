package com.example.ping_meteo.Model;

import com.example.ping_meteo.Model.Datatype.*;

import java.util.List;

public class Utilisateur {
    private IdType id;
    private NomType login;
    private MotDePasseType mdp;
    private int freqAlerte; // jsp si on a fait un datatype pour ça a check
    private List<Seuil> listeSeuil;
    private List<Lieu> listeLieu;

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public NomType getLogin() {
        return login;
    }

    public void setLogin(NomType login) {
        this.login = login;
    }

    public MotDePasseType getMdp() {
        return mdp;
    }

    public void setMdp(MotDePasseType mdp) {
        this.mdp = mdp;
    }

    public int getFreqAlerte() {
        return freqAlerte;
    }

    public void setFreqAlerte(int freqAlerte) {
        this.freqAlerte = freqAlerte;
    }

    public List<Seuil> getListeSeuil() {
        return listeSeuil;
    }

    public void setListeSeuil(List<Seuil> listeSeuil) {
        this.listeSeuil = listeSeuil;
    }

    public List<Lieu> getListeLieu() {
        return listeLieu;
    }

    public void setListeLieu(List<Lieu> listeLieu) {
        this.listeLieu = listeLieu;
    }
}
