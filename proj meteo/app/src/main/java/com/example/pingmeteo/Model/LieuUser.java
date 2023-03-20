package com.example.pingmeteo.Model;

import com.example.pingmeteo.Model.Datatype.IdType;

public class LieuUser {
        private IdType idLieu;
        private String FirebaseID;

    public LieuUser() {
        // Default constructor required for calls to DataSnapshot.getValue(LieuUser.class)
    }

    public  LieuUser (IdType idL, String idF){
            this.idLieu = idL;
            this.FirebaseID = idF;
        }


    public IdType getIdLieu() {
        return idLieu;
    }
    @Override
    public String toString() {
        Lieu lieu = FirebaseConnexion.getInstance().getSingleLieu(idLieu);
        if (lieu != null) {
            return lieu.getNom().getValeur();
        } else {
            return "Unknown";
        }
    }

    public void setIdLieu(IdType idLieu) {
        this.idLieu = idLieu;
    }

    public String getFirebaseID() {
        return FirebaseID;
    }

    public void setFirebaseID(String firebaseID) {
        FirebaseID = firebaseID;
    }
}


