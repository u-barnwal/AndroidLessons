package com.chitransh.testrun1;

import android.graphics.drawable.Drawable;

public class Movie {

  private String name, description;
  private Drawable drawable;

  public Movie(String name, String description, Drawable drawable) {
    this.name = name;
    this.description = description;
    this.drawable = drawable;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Drawable getDrawable() {
    return drawable;
  }

  public void setDrawable(Drawable drawable) {
    this.drawable = drawable;
  }
}
