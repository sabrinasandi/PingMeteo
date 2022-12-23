package com.example.ping_meteo.Model;

import com.example.ping_meteo.Model.Datatype.DateType;
import com.example.ping_meteo.Model.Datatype.GPSType;
import com.example.ping_meteo.Model.Datatype.HourType;
import com.example.ping_meteo.Model.Datatype.IdType;
import com.example.ping_meteo.Model.Datatype.NomType;

public class Lieu {
    private IdType id;
    private NomType nom;
    private GPSType position;

    public  Lieu (IdType idé, NomType name, GPSType gps){
        this.id = idé;
        this.nom = name;
        this.position = gps;
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
