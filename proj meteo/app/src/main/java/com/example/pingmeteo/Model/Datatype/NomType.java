package com.example.ping_meteo.Model.Datatype;

public class NomType extends Text{
    private final String PATTERN ="[A-Z]?[a-z]"; // a voir comment on code ça en vrai

    public NomType(String s) {
        super(s);
    }
}
