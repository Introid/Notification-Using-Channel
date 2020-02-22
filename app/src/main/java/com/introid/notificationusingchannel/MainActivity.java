package com.introid.notificationusingchannel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.introid.notificationusingchannel.App.channel1Id;
import static com.introid.notificationusingchannel.App.channel2Id;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText title,message;
    private Button channel1,channel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        title=findViewById( R.id.et_title );
        message= findViewById(R.id.et_message);
        channel1=findViewById(R.id.channel1);
        channel2=findViewById( R.id.channel2 );

        notificationManager= NotificationManagerCompat.from( this );

        channel1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel1(view);
            }
        } );
        channel2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel2(view);
            }
        } );
    }

    public void sendOnChannel2(View v) {
        String title1=title.getText().toString();
        String Message1= message.getText().toString();
        Notification notification= new NotificationCompat.Builder( this, channel2Id)
                .setSmallIcon( R.drawable.ic_android_black_24dp )
                .setContentTitle( title1)
                .setContentText( Message1 )
                .setPriority( NotificationCompat.PRIORITY_LOW)
                .setCategory( NotificationCompat.CATEGORY_MESSAGE )
                .build();
        notificationManager.notify( 2,notification );

    }

    public void sendOnChannel1(View v) {
        String title1=title.getText().toString();
        String Message1= message.getText().toString();
        Notification notification= new NotificationCompat.Builder( this, channel1Id)
                .setSmallIcon( R.drawable.ic_android_black_24dp )
                .setContentTitle( title1)
                .setContentText( Message1 )
                .setPriority( NotificationCompat.PRIORITY_HIGH)
                .setCategory( NotificationCompat.CATEGORY_MESSAGE )
                .build();
        notificationManager.notify( 1,notification );


    }
}
