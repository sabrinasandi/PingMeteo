package com.example.pingmeteo.Model;

import com.example.pingmeteo.Model.Datatype.DateType;
import com.example.pingmeteo.Model.Datatype.GPSType;
import com.example.pingmeteo.Model.Datatype.HourType;
import com.example.pingmeteo.Model.Datatype.IdType;
import com.example.pingmeteo.Model.Datatype.NomType;

public class Lieu {
    private IdType id;
    private NomType nom;
    private GPSType position;

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
