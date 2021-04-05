package com.chitransh.testrun1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.islamkhsh.CardSliderViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    CardSliderViewPager slider = findViewById(R.id.slider);

    Drawable movieLogo = getResources().getDrawable(R.drawable.logo);

    ArrayList<Movie> movies = new ArrayList();

    movies.add(new Movie("Test A", "Description A", movieLogo));
    movies.add(new Movie("Test B", "Description B", movieLogo));
    movies.add(new Movie("Test C", "Description C", movieLogo));

    slider.setAdapter(new MovieAdapter(movies));

  }
}