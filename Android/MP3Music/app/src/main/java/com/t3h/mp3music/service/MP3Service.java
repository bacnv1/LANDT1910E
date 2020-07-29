package com.t3h.mp3music.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.t3h.mp3music.MediaController;
import com.t3h.mp3music.R;
import com.t3h.mp3music.models.Song;

import java.util.ArrayList;

public class MP3Service extends Service {

    private MediaController controller;
    private RemoteViews remoteViews;

    @Override
    public void onCreate() {
        super.onCreate();
        initRemoteViews();
    }

    private void initRemoteViews() {
        remoteViews = new RemoteViews(getPackageName(), R.layout.ui_notification);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MP3Binder(this);
    }

    private void pushNotify(Song song) {
        Intent intent = new Intent(this, getClass());
        startService(intent);

        String channelId = "MP3Channel";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    channelId,
                    NotificationManager.IMPORTANCE_MIN
            );
            manager.createNotificationChannel(channel);
        }
        remoteViews.setTextViewText(R.id.tv_song, song.getTitle());
        remoteViews.setTextViewText(R.id.tv_artist, song.getArtist());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this,
                channelId
        );
        builder.setSmallIcon(R.drawable.ic_song);
        builder.setCustomContentView(remoteViews);
        startForeground(1221, builder.build());
    }

    public void setData(final ArrayList<Song> songs) {
        if (controller == null) {
            controller = new MediaController(songs, this) {
                @Override
                public void create(int index) {
                    super.create(index);
                    pushNotify(songs.get(index));
                }
            };
        }
    }

    public MediaController getController() {
        return controller;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MP3Binder extends Binder {
        private MP3Service service;

        public MP3Binder(MP3Service service) {
            this.service = service;
        }

        public MP3Service getService() {
            return service;
        }
    }

}
