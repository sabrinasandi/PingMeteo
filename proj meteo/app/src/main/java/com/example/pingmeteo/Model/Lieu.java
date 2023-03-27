package com.example.pingmeteo.Model;

import com.example.pingmeteo.Model.Datatype.DateType;
import com.example.pingmeteo.Model.Datatype.GPSType;
import com.example.pingmeteo.Model.Datatype.HourType;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;

import java.io.Serializable;

public class Lieu implements Serializable {
    private IdType id;
    private NomType nom;
    private GPSType position;

    public Lieu() {
        // Default constructor required for calls to DataSnapshot.getValue(Lieu.class)
    }

    public  Lieu (IdType idé, NomType name, GPSType gps){
        this.id = idé;
        this.nom = name;
        this.position = gps;
    }
    public  Lieu (NomType name, GPSType gps){
        this.nom = name;
        this.position = gps;
    }

    public Lieu(String cityName, double latitude, double longitude) {
        this.nom = new NomType(cityName);
        this.position = new GPSType(latitude,longitude);
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

    public GPSType getPosition() {
        return position;
    }

    public void setPosition(GPSType position) {
        this.position = position;
    }

    public Météo getMeteo(DateType date, HourType heure){
        return null;
    }
}
