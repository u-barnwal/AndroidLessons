package com.chitransh.testrun1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductsListAdapter extends BaseAdapter {

  private final Context context;
  private ArrayList<Product> products = new ArrayList<>();

  ProductsListAdapter(Context context) {
    this.context = context;
  }

  @Override
  public int getCount() {
    return products.size(); // size is same as length
  }

  @Override
  public Product getItem(int index) {
    return products.get(index);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int index, View convertView, ViewGroup parent) {
    View view = LayoutInflater.from(context).inflate(R.layout.list_product_item, null);

    TextView tvName = view.findViewById(R.id.tvName);
    TextView tvCode = view.findViewById(R.id.tvCode);
    TextView tvSelling = view.findViewById(R.id.tvSelling);
    TextView tvPurchase = view.findViewById(R.id.tvPurchase);

    Product product = getItem(index);

    tvName.setText(product.getName());
    tvCode.setText(product.getCode());
    tvSelling.setText(String.valueOf(product.getSelling()));
    tvPurchase.setText(String.valueOf(product.getPurchase()));

    return view;
  }

  public void setProducts(ArrayList<Product> products) {
    this.products = products;
  }
}
