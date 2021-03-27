package com.chitransh.testrun1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

  private final String registeredEmail = "demo@test.com";
  private final String registeredPassword = "123";
  private View mv;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mv = inflater.inflate(R.layout.fragment_login, container, false);

    EditText etEmail = mv.findViewById(R.id.etEmail);
    EditText etPassword = mv.findViewById(R.id.etPassword);

    Button bLogin = mv.findViewById(R.id.bLogin);

    TextView tvForgotPassword = mv.findViewById(R.id.tvForgotPassword);

    bLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (
          etEmail.getText().toString().equals(registeredEmail) &&
            etPassword.getText().toString().equals(registeredPassword)
        ) {
          Log.e("----", "Login Successful!");
        } else {
          Log.e("----", "Email or Password incorrect!");
        }
      }
    });

    tvForgotPassword.setOnClickListener(v -> {
//      Intent intent = new Intent(getActivity(), ForgotPasswordActivity.class);
//      startActivity(intent);
    });

    return mv;
  }
}