package com.chitransh.testrun1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private final String registeredEmail = "demo@test.com";
  private final String registeredPassword = "123";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    EditText etEmail = findViewById(R.id.etEmail);
    EditText etPassword = findViewById(R.id.etPassword);

    Button bLogin = findViewById(R.id.bLogin);

    TextView tvForgotPassword = findViewById(R.id.tvForgotPassword);

    bLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (
          etEmail.getText().toString().equals(registeredEmail) &&
            etPassword.getText().toString().equals(registeredPassword)
        ) {
          Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(getApplicationContext(), "Email or Password incorrect!", Toast.LENGTH_SHORT).show();
        }
      }
    });

  }
}