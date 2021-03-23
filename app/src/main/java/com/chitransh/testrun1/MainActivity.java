package com.chitransh.testrun1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    WebView wvMain = findViewById(R.id.wvMain);
//
//    wvMain.loadUrl("https://wikipedia.org");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main_activity, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//    Toast.makeText(getApplicationContext(), "Item clicked", Toast.LENGTH_SHORT).show();

    String message = "";

    switch (item.getItemId()) {
      case R.id.iActionOpen:
        message = "Open clicked!";
        break;
      case R.id.iActionShare:
        message = "Share clicked!";
        break;
      case R.id.iActionExit:
        message = "Exit clicked!";
        break;
    }

    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    return super.onOptionsItemSelected(item);
  }
}