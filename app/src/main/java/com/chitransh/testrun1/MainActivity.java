package com.chitransh.testrun1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

      View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_alert, null);

      builder.setView(view);

      AlertDialog dialog = builder.show();

      TextView tvTitle = view.findViewById(R.id.tvTitle);
      TextView tvText = view.findViewById(R.id.tvText);
      Button bPositive = view.findViewById(R.id.bPositive);
      Button bNegative = view.findViewById(R.id.bNegative);

      tvTitle.setText("Are you sure?");
      tvText.setText("This name will be saved to the application. Continue?");

      bPositive.setText("Yes");
      bNegative.setText("No");

      bPositive.setOnClickListener(v1 -> {
        dialog.dismiss();
        saveName();
      });

      bNegative.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          dialog.dismiss();
          etName.setText("");
        }
      });

    });
  }

  private void saveName() {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("username", etName.getText().toString());
    editor.apply();

    Toast.makeText(getApplicationContext(), "Names save!", Toast.LENGTH_SHORT).show();
  }
}