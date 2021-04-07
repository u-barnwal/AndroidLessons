package com.chitransh.testrun1.activities;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.chitransh.testrun1.R;
import com.chitransh.testrun1.fragments.SaveStudentFragment;
import com.chitransh.testrun1.fragments.ViewStudentFragment;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    LinearLayout llBtnView = findViewById(R.id.llBtnView);
    LinearLayout llBtnInsert = findViewById(R.id.llBtnInsert);

    llBtnView.setOnClickListener(v -> {
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

      transaction.replace(R.id.flMain, new ViewStudentFragment());
      transaction.commit();
    });

    llBtnInsert.setOnClickListener(v -> {
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

      transaction.replace(R.id.flMain, new SaveStudentFragment());
      transaction.commit();
    });

  }
}