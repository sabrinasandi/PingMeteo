package com.example.ping_meteo.Model.Datatype;

public class MotDePasseType extends Text{
    private final int MINTAILLE = 6; // a voir si on change
    private String regleExp; // pas fait les getset jsp comment modéliser ça encore

    public MotDePasseType(String s) {
        super(s);
    }
}
