package com.chitransh.testrun1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SharedPreferences sharedPreferences = getSharedPreferences("SP_TESTRUN1", MODE_PRIVATE);

    EditText etName = findViewById(R.id.etName);
    Button bSave = findViewById(R.id.bSave);

//    if(sharedPreferences.contains("username"))
      etName.setText(sharedPreferences.getString("username", ""));

    bSave.setOnClickListener(v -> {
      if (etName.getText() == null || etName.getText().toString().isEmpty()) {
        Toast.makeText(getApplicationContext(), "You must enter your name!", Toast.LENGTH_SHORT).show();
        return;
      }

      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString("username", etName.getText().toString());
      editor.apply();

      Toast.makeText(getApplicationContext(), "Names save!", Toast.LENGTH_SHORT).show();
    });
  }
}