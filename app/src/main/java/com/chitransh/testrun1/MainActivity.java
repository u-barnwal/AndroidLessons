package com.chitransh.testrun1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  public static boolean IS_SERVICE_STARTED = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button bPlay = findViewById(R.id.bPlay);
    Button bStop = findViewById(R.id.bStop);

    Intent serviceIntent = new Intent(this, Music.class);

    bPlay.setOnClickListener(v -> {
      if (IS_SERVICE_STARTED) {
        stopService(serviceIntent);
      }

      startService(serviceIntent);
    });

    bStop.setOnClickListener(v -> {
      stopService(serviceIntent);
    });

  }
}