package com.chitransh.testrun1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class Music extends Service {

  private MediaPlayer player;

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    MainActivity.IS_SERVICE_STARTED = true;

    player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
    player.setLooping(false);
    player.start();

    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void onDestroy() {
    MainActivity.IS_SERVICE_STARTED = false;

    player.stop();
    super.onDestroy();
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
}