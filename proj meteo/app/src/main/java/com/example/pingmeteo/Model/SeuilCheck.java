package com.example.pingmeteo.Model;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.pingmeteo.Model.Seuil;
import com.example.pingmeteo.R;
import com.example.pingmeteo.View.MainActivity;

import java.util.List;

public class SeuilCheck extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SeuilCheck", "Checking seuils...");

        // Get the list of seuils for the current user from the database
        List<Seuil> seuils = FirebaseConnexion.getInstance().getSeuils();

        // Iterate over the list of seuils and check if the conditions are met
        for (Seuil seuil : seuils) {
            if (seuil.checkCondition()) {
                // Create a unique notification ID
                int notificationId = 1;
                System.out.println("NotificationPart");
/*
                // Create a new notification channel for Android 8.0 and higher
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    String channelId = "_channel_id";
                    String channelName = "Ping Meteo Notification Channel";
                    String channelDescription = "Seuil notif";
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
                    channel.setDescription(channelDescription);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(channel);
                }

                // Create a new notification builder
                Notification.Builder builder = new Notification.Builder(this, "my_channel_id")
                        .setContentTitle("Seuil triggered")
                        .setContentText(seuil.getMessage())
                        .setSmallIcon(R.drawable.notification_icon)
                        .setAutoCancel(true); // Dismiss notification when user taps it

                // Create a new intent to open the app when the user taps the notification
                Intent intent = new Intent(this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                // Get the notification manager and send the notification
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(notificationId, builder.build());*/
            }
        }

    }
}
