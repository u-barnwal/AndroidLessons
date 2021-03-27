package com.chitransh.testrun1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

  private View rootView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_a, container, false);

    Button bClick = rootView.findViewById(R.id.bClick);

    bClick.setOnClickListener(v -> {
      Toast.makeText(getActivity(), "Button clicked!", Toast.LENGTH_SHORT).show();
    });

    return rootView;
  }

}