package com.example.pingmeteo.Model.Datatype;

public class PluieType {
    private int précipitation;
    private QualitéPluie typePluie;

    private String descriptionPluie;

    public PluieType(int précipitation, String descriptionPluie) {
        this.précipitation = précipitation;
        this.descriptionPluie = descriptionPluie;
    }

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

    public String getDescriptionPluie() {
        return descriptionPluie;
    }

    public void setDescriptionPluie(String descriptionPluie) {
        this.descriptionPluie = descriptionPluie;
    }
}
