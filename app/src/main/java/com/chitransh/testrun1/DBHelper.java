package com.chitransh.testrun1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

  public DBHelper(Context context) {
    super(context, "TEST_DB", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(
      "CREATE TABLE student (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "roll INTEGER," +
        "name VARCHAR(40)," +
        "address TEXT," +
        "course VARCHAR(40)," +
        "photo_uri TEXT DEFAULT NULL" +
        ")"
    );
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS student");
  }

  public boolean createStudent(Student student) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("roll", student.getRoll());
    contentValues.put("name", student.getName());
    contentValues.put("address", student.getAddress());
    contentValues.put("course", student.getCourse());

//    long result = getWritableDatabase().insert("student", null, contentValues);
//    if(result==-1) {
//      return false;
//    }
//    return true;

    return getWritableDatabase().insert("student", null, contentValues) != -1;
  }

  public void updateStudent(int studentId, Student student) {
  }

  public Cursor readStudent() {
    Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM student", null);

    return cursor;
  }

  public void deleteStudent(int roll) {
    getWritableDatabase().delete("student", "roll=?", new String[]{String.valueOf(roll)});
  }

}
