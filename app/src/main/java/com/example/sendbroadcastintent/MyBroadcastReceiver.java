package com.example.sendbroadcastintent;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent == null) return;
        if(intent.getAction().equals("com.example.MY_ACTION"))
        {
            String message = intent.getStringExtra("myMessage");
            showNotification(context,message);
        }



    }



    private void showNotification(Context context, String message) {

        // Build the Content of notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "0");
        builder.setContentTitle(message);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setDefaults(Notification.DEFAULT_VIBRATE);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setAutoCancel(true); // when user click , it disappear
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && Build.VERSION.SDK_INT <= Build.VERSION_CODES.O) {
            builder.setPriority(NotificationManager.IMPORTANCE_HIGH);
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // show the Notification & also create channel for devices running android O
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nChannel = new NotificationChannel(
                    "0",
                    "batteryNotificationChannel",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(nChannel);
        }

        if (notificationManager != null)
            notificationManager.notify(1, builder.build());

    }
}
