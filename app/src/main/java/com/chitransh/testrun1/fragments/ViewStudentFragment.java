package com.chitransh.testrun1.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
  private DBHelper dbHelper;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mv = inflater.inflate(R.layout.fragment_view_student, container, false);

    instantiate();
    initialize();
    listen();
    load();

    return mv;
  }

  private void instantiate() {
    lvMain = mv.findViewById(R.id.lvMain);
    studentListAdapter = new StudentListAdapter(getActivity(), this);
    dbHelper = new DBHelper(getActivity());
  }

  private void initialize() {
    lvMain.setAdapter(studentListAdapter);
  }

  private void listen() {
  }

  private void load() {
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

  public void processEdit(Student student) {
    FragmentTransaction transaction = getFragmentManager().beginTransaction();

    transaction.replace(R.id.flMain, new SaveStudentFragment(student));
    transaction.commit();
  }

  public void processDelete(int roll) {
    dbHelper.deleteStudent(roll);
    Toast.makeText(getActivity(), "Student deleted!", Toast.LENGTH_SHORT).show();
    load();
  }

}