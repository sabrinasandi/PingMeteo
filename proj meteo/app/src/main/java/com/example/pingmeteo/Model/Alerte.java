package com.example.ping_meteo.Model;

import com.example.ping_meteo.Model.Datatype.DateType;
import com.example.ping_meteo.Model.Datatype.NomType;
import com.example.ping_meteo.Model.Datatype.NotificationType;

public class Alerte {
    private Lieu lieuEnQuestion;
    private Seuil seuilEnQuestion;
    private NomType nom;
    private NotificationType contenu;
    private DateType date;

    public Lieu getLieuEnQuestion() {
        return lieuEnQuestion;
    }

    public void setLieuEnQuestion(Lieu lieuEnQuestion) {
        this.lieuEnQuestion = lieuEnQuestion;
    }

    public Seuil getSeuilEnQuestion() {
        return seuilEnQuestion;
    }

    public void setSeuilEnQuestion(Seuil seuilEnQuestion) {
        this.seuilEnQuestion = seuilEnQuestion;
    }

    public NomType getNom() {
        return nom;
    }

    public void setNom(NomType nom) {
        this.nom = nom;
    }

    public NotificationType getContenu() {
        return contenu;
    }

    public void setContenu(NotificationType contenu) {
        this.contenu = contenu;
    }

    public DateType getDate() {
        return date;
    }

    public void setDate(DateType date) {
        this.date = date;
    }
}
