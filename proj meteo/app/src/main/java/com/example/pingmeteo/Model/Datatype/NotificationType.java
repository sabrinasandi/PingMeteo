package com.example.pingmeteo.Model.Datatype;

public class NotificationType extends Text{
    private int maxTaille;

    public NotificationType(String s) {
        super(s);
    }

    public int getMaxTaille() {
        return maxTaille;
    }

    public void setMaxTaille(int maxTaille) {
        this.maxTaille = maxTaille;
    }
}
