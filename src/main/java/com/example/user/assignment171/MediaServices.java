package com.example.user.assignment171;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

//Media service Class extending Service
public class MediaServices extends Service{

    //making object of mediaPlayer
    MediaPlayer mediaPlayer;
   //onCreate Method
    @Override
    public void onCreate() {
        super.onCreate();

        //setting mediaPlayer
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.let_me_love_you);
    }

    //onStartCommand method
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //starting mediaPalyer
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    //onDestroy Method
    @Override
    public void onDestroy() {
        //stoping media Player
        mediaPlayer.release();

        //mmaking a simple notification with title and text
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("assignment17.1").setContentText("Notification released and focus taken to MainActivity.");

        //Intent to Return on Main Activity
        Intent intent=new Intent(MediaServices.this,MainActivity.class);

        //pending Intent to wait untill notification is tapped
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(contentIntent);

        //Making notification Manager object to notify
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

        super.onDestroy();
    }
}
