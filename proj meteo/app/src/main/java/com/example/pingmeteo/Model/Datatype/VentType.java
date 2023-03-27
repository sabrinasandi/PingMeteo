package com.example.pingmeteo.Model.Datatype;

public class VentType {
    private VitesseType vitesseVent;
    private QualitéVent typeVent;

    public VentType(VitesseType vitesseVent) {
        this.vitesseVent = vitesseVent;
    }

    public VitesseType getVitesseVent() {
        return vitesseVent;
    }

    public void setVitesseVent(VitesseType vitesseVent) {
        this.vitesseVent = vitesseVent;
    }

    public QualitéVent getTypeVent() {
        return typeVent;
    }

    public void setTypeVent(QualitéVent typeVent) {
        this.typeVent = typeVent;
    }
}
