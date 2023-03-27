package com.example.pingmeteo.Model.Datatype;

public class GPSType {
    private double latitute;
    private double longitude;
    public GPSType(double latitute, double longitude){

        this.latitute = latitute;
        this.longitude = longitude;
    }
    public GPSType(){

    }
    public double getLatitute() {
        return latitute;
    }

    public void setLatitute(double latitute) {
        this.latitute = latitute;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
