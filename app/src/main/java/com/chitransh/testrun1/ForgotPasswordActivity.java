package com.chitransh.testrun1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_forgot_password);

    TextView tvLogin = findViewById(R.id.tvLogin);

    tvLogin.setOnClickListener(v -> {
      onBackPressed();
    });
  }
}