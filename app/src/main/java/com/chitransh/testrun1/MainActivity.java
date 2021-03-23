package com.chitransh.testrun1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    WebView wvMain = findViewById(R.id.wvMain);

    wvMain.loadUrl("https://wikipedia.org");
  }
}