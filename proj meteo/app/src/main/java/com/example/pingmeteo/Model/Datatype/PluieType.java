package com.example.pingmeteo.Model.Datatype;

public class PluieType {
    private int précipitation;
    private QualitéPluie typePluie;

    public int getPrécipitation() {
        return précipitation;
    }

    public void setPrécipitation(int précipitation) {
        this.précipitation = précipitation;
    }

    public QualitéPluie getTypePluie() {
        return typePluie;
    }

    public void setTypePluie(QualitéPluie typePluie) {
        this.typePluie = typePluie;
    }
}
