package com.chitransh.testrun1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView tvContacts = findViewById(R.id.tvContacts);

    ContentResolver contentResolver = getContentResolver();

    Cursor cursor = contentResolver.query(
      ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
      null, // which all columns you want to select
      null, // where statement
      null, // where statement values
      null // sorting order (pass column names)
    );

    String contacts = "";

    if (cursor != null && cursor.getCount() > 0) {
      while (cursor.moveToNext()) {
        contacts +=
          cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            + " " +
            cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            + "\n";
      }
    }

    tvContacts.setText(contacts);

    cursor.close();
  }
}