package com.chitransh.testrun1;

import android.graphics.drawable.Drawable;

public class Product {

  private Drawable drawable;
  private String name, code;
  private float selling, purchase;

  public Product(String name, String code, float selling, float purchase, Drawable drawable) {
    this.name = name;
    this.code = code;
    this.selling = selling;
    this.purchase = purchase;
    this.drawable = drawable;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public float getSelling() {
    return selling;
  }

  public void setSelling(float selling) {
    this.selling = selling;
  }

  public float getPurchase() {
    return purchase;
  }

  public void setPurchase(float purchase) {
    this.purchase = purchase;
  }

  public Drawable getDrawable() {
    return drawable;
  }

  public void setDrawable(Drawable drawable) {
    this.drawable = drawable;
  }
}
