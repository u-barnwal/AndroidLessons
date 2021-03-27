package com.chitransh.testrun1;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button bLogin = findViewById(R.id.bLogin);
    Button bRecover = findViewById(R.id.bRecover);
    Button bSignup = findViewById(R.id.bSignup);

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.flMain, new LoginFragment());
    ft.commit();

    bLogin.setOnClickListener(v -> {
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
      transaction.replace(R.id.flMain, new LoginFragment());
      transaction.addToBackStack("login_fragment");
      transaction.commit();
    });

    bRecover.setOnClickListener(v -> {
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
      transaction.replace(R.id.flMain, new ForgotPasswordFragment());
      transaction.addToBackStack("recover_fragment");
      transaction.commit();
    });
  }
}