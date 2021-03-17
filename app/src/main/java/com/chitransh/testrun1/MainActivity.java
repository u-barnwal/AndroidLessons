package com.chitransh.testrun1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.e("Event: ", "create");
  }

  @Override
  protected void onStart() {
    super.onStart();

    Log.e("Event: ", "start");
  }

  @Override
  protected void onPause() {
    super.onPause();

    Log.e("Event: ", "pause");
  }

  @Override
  protected void onResume() {
    super.onResume();

    Log.e("Event: ", "resume");
  }

  @Override
  protected void onStop() {
    super.onStop();

    Log.e("Event: ", "stop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    Log.e("Event: ", "destroy");
  }
}