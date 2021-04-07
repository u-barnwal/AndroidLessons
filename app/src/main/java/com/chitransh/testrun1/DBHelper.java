package com.chitransh.testrun1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

  public DBHelper(Context context) {
    super(context, "TestDB", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(
      "CREATE TABLE users (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "first_name VARCHAR(20), " +
        "last_name VARCHAR(20) " +
        ")"
    );
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS users");
  }

  public boolean insertUser(String firstName, String lastName) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("first_name", firstName);
    contentValues.put("last_name", lastName);

    return getWritableDatabase().insert("users", null, contentValues) != -1;
  }

}
