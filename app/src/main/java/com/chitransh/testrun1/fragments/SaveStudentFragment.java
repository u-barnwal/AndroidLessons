package com.chitransh.testrun1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.chitransh.testrun1.R;

public class SaveStudentFragment extends Fragment {

  private View mv;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mv = inflater.inflate(R.layout.fragment_save_student, container, false);
    return mv;
  }
}