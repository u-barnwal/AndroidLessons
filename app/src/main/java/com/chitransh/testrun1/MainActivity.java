package com.chitransh.testrun1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private ListView lvMain;
//  private ArrayList list;
  private ArrayList<Product> products;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    lvMain = findViewById(R.id.lvMain);

//    list = new ArrayList();
//
//    list.add("A");
//    list.add("B");
//    list.add("C");
//    list.add("D");
//    list.add("E");
//    list.add("F");
//    list.add("G");
//    list.add("G");
//    list.add("H");
//    list.add("I");
//
//    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

//    lvMain.setAdapter(adapter);

    products = new ArrayList<>();

    products.add(new Product("Mobile", "XYZ", 12200, 23000));
    products.add(new Product("Laptop", "XYDJZ", 45, 23000));
    products.add(new Product("Desktop", "XYDFJZ", 12200, 23000));
    products.add(new Product("Marker", "FWG", 12200, 23000));
    products.add(new Product("Keyboard", "XYZ", 3, 23000));
    products.add(new Product("Mouse", "XYZ", 12200, 23000));
    products.add(new Product("Touchpad", "SDH", 12200, 9));
    products.add(new Product("Cabel", "XDJFYZ", 5, 23000));


  }

}