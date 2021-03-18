package com.chitransh.testrun1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button = findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.e("==: ", "Button clicked!");
      }
    });

    TextView textView = findViewById(R.id.textView);

    textView.setOnClickListener((v) -> {
      Log.e("==: ", "Text clicked!");
    });

//    textView.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Log.e("==: ", "Text clicked!");
//      }
//    });

  }
}