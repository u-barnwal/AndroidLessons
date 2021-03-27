package com.chitransh.testrun1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    FrameLayout flA = findViewById(R.id.flA);
//    FrameLayout flB = findViewById(R.id.flB);
//    FrameLayout flC = findViewById(R.id.flC);
//    FrameLayout flD = findViewById(R.id.flD);

    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    transaction.replace(R.id.flA, new FragmentA());
    transaction.replace(R.id.flB, new FragmentB());
    transaction.replace(R.id.flC, new FragmentC());
    transaction.replace(R.id.flD, new FragmentD());

    transaction.commit();

  }
}