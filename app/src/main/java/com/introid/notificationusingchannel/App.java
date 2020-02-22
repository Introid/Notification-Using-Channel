package com.introid.notificationusingchannel;

import android.app.AlertDialog;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String channel1Id= "Channel1ID";
    public static final String channel1Name= "Channel 1";

    public static final String channel2Id= "Channel2ID";
    public static final String channel2Name= "Channel 2";
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    public void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel(channel1Id, channel1Name, NotificationManager.IMPORTANCE_HIGH );
            channel.setDescription( "This is Channel 1" );

            NotificationChannel channe2 = new NotificationChannel(channel2Id, channel2Name, NotificationManager.IMPORTANCE_LOW );
            channe2.setDescription( "This is Channel 2" );

            NotificationManager manager= getSystemService( NotificationManager.class );

            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channe2);


        }
    }
}
