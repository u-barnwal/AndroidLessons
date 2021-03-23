package com.chitransh.testrun1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  String website = "https://google.com";
  String mobile = "9661123235654";
  String email = "demo@demo.com";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button bOpenWebsite = findViewById(R.id.bOpenWebsite);
    Button bOpenMobile = findViewById(R.id.bOpenMobile);
    Button bOpenEmail = findViewById(R.id.bOpenEmail);

    bOpenWebsite.setOnClickListener(v -> {
      Intent intent = new Intent(Intent.ACTION_VIEW);
      intent.setData(Uri.parse(website));

      startActivity(intent);
    });

    bOpenMobile.setOnClickListener(v -> {
//      Intent intent = new Intent(Intent.ACTION_DIAL);
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse("tel:" + mobile));

      startActivity(intent);
    });

    bOpenEmail.setOnClickListener(v -> {
      Intent intent = new Intent(Intent.ACTION_SENDTO);
      intent.setData(Uri.parse("mailto:" + email));

      startActivity(intent);
    });
  }
}