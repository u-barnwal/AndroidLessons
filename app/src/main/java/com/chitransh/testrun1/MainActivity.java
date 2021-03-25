package com.chitransh.testrun1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private Activity activity;
  private SharedPreferences sharedPreferences;
  private EditText etName;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    activity = this;

    sharedPreferences = getSharedPreferences("SP_TESTRUN1", MODE_PRIVATE);

    etName = findViewById(R.id.etName);
    Button bSave = findViewById(R.id.bSave);

//    if(sharedPreferences.contains("username"))
    etName.setText(sharedPreferences.getString("username", ""));

    bSave.setOnClickListener(v -> {
      if (etName.getText() == null || etName.getText().toString().isEmpty()) {
        Toast.makeText(getApplicationContext(), "You must enter your name!", Toast.LENGTH_SHORT).show();
        return;
      }

      AlertDialog.Builder builder = new AlertDialog.Builder(activity);

      builder.setTitle("Are you sure?");
      builder.setMessage("This name will be saved to the application. Continue?");

      builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          saveName();
        }
      });

      builder.setNegativeButton("No", (dialog, which) -> {
        etName.setText("");
      });

      builder.show();
    });
  }

  private void saveName() {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("username", etName.getText().toString());
    editor.apply();

    Toast.makeText(getApplicationContext(), "Names save!", Toast.LENGTH_SHORT).show();
  }
}