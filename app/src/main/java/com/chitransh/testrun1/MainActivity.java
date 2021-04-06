package com.chitransh.testrun1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView lvContacts = findViewById(R.id.lvContacts);

    ContentResolver contentResolver = getContentResolver();

    Cursor cursor = contentResolver.query(
      ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
      null, // which all columns you want to select
      null, // where statement
      null, // where statement values
      null // sorting order (pass column names)
    );

//    Cursor cursor = contentResolver.query(
//      ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//      new String[]{
//        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//        ContactsContract.CommonDataKinds.Phone.NUMBER,
//      }, // which all columns you want to select
//      ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "=?", // where statement
//      new String[]{"Doe"}, // where statement values
//      ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC" // sorting order (pass column names)
//    );

    ArrayList<Contact> contacts = new ArrayList<>();

    if (cursor != null && cursor.getCount() > 0) {
      while (cursor.moveToNext()) {
        contacts.add(new Contact(
          cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
          cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
        ));
      }
    }

    ContactsListAdapter contactsListAdapter = new ContactsListAdapter(this);
    contactsListAdapter.setContactList(contacts);

    lvContacts.setAdapter(contactsListAdapter);

    cursor.close();
  }
}