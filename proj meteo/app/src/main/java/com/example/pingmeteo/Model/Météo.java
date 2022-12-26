package com.example.pingmeteo.Model;

import com.example.pingmeteo.Model.Datatype.DateType;
import com.example.pingmeteo.Model.Datatype.HourType;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.PluieType;
import com.example.pingmeteo.Model.Datatype.TemperatureType;
import com.example.pingmeteo.Model.Datatype.VentType;

public class Météo {
    private Lieu lieu;
    private IdType id;
    private TemperatureType température;
    private HourType heure;
    private DateType date;
    private PluieType pluie;
    private VentType vent;

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
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
