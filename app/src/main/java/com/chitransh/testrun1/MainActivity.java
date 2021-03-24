package com.chitransh.testrun1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    ProgressBar pbMain = findViewById(R.id.pbMain);
//    Button bShowPB = findViewById(R.id.bShowPB);
//    Button bHidePB = findViewById(R.id.bHidePB);
//
//    bShowPB.setOnClickListener(v -> {
//      pbMain.setVisibility(View.VISIBLE);
//    });
//
//    bHidePB.setOnClickListener(v -> {
//      pbMain.setVisibility(View.INVISIBLE);
////      pbMain.setVisibility(View.GONE);
//    });

    Switch sToggle = findViewById(R.id.sToggle);
    TextView tvContent = findViewById(R.id.tvContent);

    CheckBox cbMain = findViewById(R.id.cbMain);

    sToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        cbMain.setChecked(isChecked);
        if (isChecked)
          tvContent.setVisibility(View.VISIBLE);
        else
          tvContent.setVisibility(View.GONE);
      }
    });

    cbMain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        sToggle.setChecked(isChecked);
        if (isChecked)
          tvContent.setVisibility(View.VISIBLE);
        else
          tvContent.setVisibility(View.GONE);
      }
    });

  }
}