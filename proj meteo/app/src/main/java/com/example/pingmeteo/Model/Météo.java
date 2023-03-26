package com.example.pingmeteo.Model;

import com.example.pingmeteo.Model.Datatype.DateType;
import com.example.pingmeteo.Model.Datatype.HourType;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.PluieType;
import com.example.pingmeteo.Model.Datatype.TemperatureType;
import com.example.pingmeteo.Model.Datatype.VentType;

import java.io.Serializable;

public class Météo implements Serializable {
    private Lieu lieu;
    private TemperatureType température;
    private HourType heure;
    private DateType date;
    private PluieType pluie;
    private VentType vent;
    private String dateToString;

    //Constructeur réduit pour météo actuel
    public Météo(Lieu lieu, TemperatureType température,  PluieType pluie, VentType vent) {
        this.lieu = lieu;
        this.température = température;
        this.pluie = pluie;
        this.vent = vent;
    }
    public Météo(Lieu lieu, TemperatureType température, HourType heure, DateType date, PluieType pluie, VentType vent) {
        this.lieu = lieu;
        this.température = température;
        this.heure = heure;
        this.date = date;
        this.pluie = pluie;
        this.vent = vent;
    }

    public String getDateToString() {
        return dateToString;
    }

    public void setDateToString(String dateToString) {
        this.dateToString = dateToString;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public TemperatureType getTempérature() {
        return température;
    }

    public void setTempérature(TemperatureType température) {
        this.température = température;
    }

    public HourType getHeure() {
        return heure;
    }

    public void setHeure(HourType heure) {
        this.heure = heure;
    }

    public DateType getDate() {
        return date;
    }

    public void setDate(DateType date) {
        this.date = date;
    }

    public PluieType getPluie() {
        return pluie;
    }

    public void setPluie(PluieType pluie) {
        this.pluie = pluie;
    }

    public VentType getVent() {
        return vent;
    }

    public void setVent(VentType vent) {
        this.vent = vent;
    }
}
