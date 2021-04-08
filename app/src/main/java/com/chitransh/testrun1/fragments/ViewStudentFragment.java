package com.chitransh.testrun1.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.chitransh.testrun1.DBHelper;
import com.chitransh.testrun1.R;
import com.chitransh.testrun1.Student;
import com.chitransh.testrun1.adapters.StudentListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewStudentFragment extends Fragment {

  private View mv;
  private ListView lvMain;
  private StudentListAdapter studentListAdapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mv = inflater.inflate(R.layout.fragment_view_student, container, false);

    instantiate();
    initialize();
    listen();

    return mv;
  }

  private void instantiate() {
    lvMain = mv.findViewById(R.id.lvMain);
    studentListAdapter = new StudentListAdapter(getActivity());
  }

  private void initialize() {
    lvMain.setAdapter(studentListAdapter);

    DBHelper dbHelper = new DBHelper(getActivity());

    Cursor cursor = dbHelper.readStudent();

    List<Student> students = new ArrayList<>();

    if (cursor != null && cursor.getCount() > 0) {
      while (cursor.moveToNext()) {
        Student student = new Student();

        student.setRoll(Integer.parseInt(cursor.getString(1)));
        student.setName(cursor.getString(2));
        student.setAddress(cursor.getString(3));
        student.setCourse(cursor.getString(4));

        students.add(student);
      }
    }

    studentListAdapter.setStudentList(students);
  }

  private void listen() {
  }
}