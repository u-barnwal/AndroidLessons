package com.chitransh.testrun1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chitransh.testrun1.DBHelper;
import com.chitransh.testrun1.R;
import com.chitransh.testrun1.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends BaseAdapter {

  private final Context context;
  private List<Student> studentList = new ArrayList<>();

  public StudentListAdapter(Context context) {
    this.context = context;
  }

  @Override
  public int getCount() {
    return studentList.size();
  }

  @Override
  public Student getItem(int position) {
    return studentList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return studentList.get(position).getRoll();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = LayoutInflater.from(context).inflate(R.layout.student_list_item, null);

    ImageView ivPhoto = view.findViewById(R.id.ivPhoto);
    TextView tvRoll = view.findViewById(R.id.tvRoll);
    TextView tvName = view.findViewById(R.id.tvName);
    TextView tvCourse = view.findViewById(R.id.tvCourse);

    ImageView ivBtnEdit = view.findViewById(R.id.ivBtnEdit);
    ImageView ivBtnDelete = view.findViewById(R.id.ivBtnDelete);

    Student student = getItem(position);

    tvRoll.setText(String.valueOf(student.getRoll()));
    tvName.setText(student.getName());
    tvCourse.setText(student.getCourse());

    ivBtnEdit.setOnClickListener(v -> {
    });

    ivBtnDelete.setOnClickListener(v -> {
      DBHelper dbHelper = new DBHelper(context);

      dbHelper.deleteStudent(student.getRoll());

      Toast.makeText(context, "Student deleted!", Toast.LENGTH_SHORT).show();
    });

    return view;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
    notifyDataSetChanged();
  }
}
