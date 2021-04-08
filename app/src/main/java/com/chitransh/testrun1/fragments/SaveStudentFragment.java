package com.chitransh.testrun1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.chitransh.testrun1.DBHelper;
import com.chitransh.testrun1.R;
import com.chitransh.testrun1.Student;

public class SaveStudentFragment extends Fragment {

  private View mv;
  private Student oldStudent;

  private EditText etRoll;
  private EditText etName;
  private EditText etAddress;
  private EditText etCourse;
  private Button bClear;
  private Button bSave;

  private DBHelper dbHelper;

  public SaveStudentFragment() {
  }

  public SaveStudentFragment(Student student) {
    this.oldStudent = student;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mv = inflater.inflate(R.layout.fragment_save_student, container, false);

    instantiate();
    initialize();
    listen();

    return mv;
  }

  private void instantiate() {
    etRoll = mv.findViewById(R.id.etRoll);
    etName = mv.findViewById(R.id.etName);
    etAddress = mv.findViewById(R.id.etAddress);
    etCourse = mv.findViewById(R.id.etCourse);

    bClear = mv.findViewById(R.id.bClear);
    bSave = mv.findViewById(R.id.bSave);

    dbHelper = new DBHelper(getActivity());
  }

  private void initialize() {
    if (oldStudent != null) {
      etRoll.setText(String.valueOf(oldStudent.getRoll()));
      etName.setText(oldStudent.getName());
      etAddress.setText(oldStudent.getAddress());
      etCourse.setText(oldStudent.getCourse());
    }
  }

  private void listen() {
    bClear.setOnClickListener(v -> clear());

    bSave.setOnClickListener(v -> save());
  }

  private void clear() {
    etRoll.setText("");
    etName.setText("");
    etAddress.setText("");
    etCourse.setText("");
  }

  private void save() {
    Student student = new Student();

    student.setRoll(Integer.parseInt(etRoll.getText().toString()));
    student.setName(etName.getText().toString());
    student.setAddress(etAddress.getText().toString());
    student.setCourse(etCourse.getText().toString());

    if (oldStudent == null)
      insert(student);
    else
      update(student);
  }

  private void insert(Student student) {
    if (dbHelper.createStudent(student)) {
      Toast.makeText(getActivity(), "Student Added!", Toast.LENGTH_SHORT).show();
      clear();
    } else
      Toast.makeText(getActivity(), "Failed to add student!", Toast.LENGTH_SHORT).show();
  }

  private void update(Student student) {
    dbHelper.updateStudent(oldStudent.getRoll(), student);
    Toast.makeText(getActivity(), "Student Updated!", Toast.LENGTH_SHORT).show();
  }

}