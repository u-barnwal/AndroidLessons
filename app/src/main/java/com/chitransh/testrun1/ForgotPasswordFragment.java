package com.chitransh.testrun1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ForgotPasswordFragment extends Fragment {

  private View mv;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mv = inflater.inflate(R.layout.fragment_forgot_password, container, false);

    TextView tvLogin = mv.findViewById(R.id.tvLogin);

    tvLogin.setOnClickListener(v -> {
      getActivity().onBackPressed();
    });

    return mv;
  }
}