package com.chitransh.testrun1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.islamkhsh.CardSliderAdapter;

import java.util.ArrayList;

public class MovieAdapter extends CardSliderAdapter<MovieAdapter.MovieViewHolder> {

  private final ArrayList<Movie> movies;

  public MovieAdapter(ArrayList<Movie> movies) {
    this.movies = movies;
  }

  @Override
  public int getItemCount() {
    return movies.size();
  }

  @Override
  public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
    return new MovieViewHolder(view);
  }

  @Override
  public void bindVH(MovieViewHolder movieViewHolder, int i) {
    movieViewHolder.populate(movies.get(i));
  }

  class MovieViewHolder extends RecyclerView.ViewHolder {

    private final View view;

    ImageView ivMovie;
    TextView tvTitle;
    TextView tvDescription;

    public MovieViewHolder(View view) {
      super(view);
      this.view = view;

      ivMovie = view.findViewById(R.id.ivMovie);
      tvTitle = view.findViewById(R.id.tvTitle);
      tvDescription = view.findViewById(R.id.tvDescription);
    }

    private void populate(Movie movie) {
      ivMovie.setImageDrawable(movie.getDrawable());
      tvTitle.setText(movie.getName());
      tvDescription.setText(movie.getDescription());
    }
  }
}
