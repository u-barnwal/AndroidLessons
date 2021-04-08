package com.chitransh.testrun1.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chitransh.testrun1.R;
import com.chitransh.testrun1.Student;
import com.chitransh.testrun1.fragments.ViewStudentFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends BaseAdapter {

  private final Context context;
  private final ViewStudentFragment viewStudentFragment;
  private List<Student> studentList = new ArrayList<>();

  public StudentListAdapter(Context context, ViewStudentFragment viewStudentFragment) {
    this.context = context;
    this.viewStudentFragment = viewStudentFragment;
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

    if (student.getPhotoURI() != null && !student.getPhotoURI().isEmpty()) {
      Log.e("0000000", "file://" + student.getPhotoURI());
      Picasso.get().load("file://" + student.getPhotoURI()).into(ivPhoto);
    }

    tvRoll.setText(String.valueOf(student.getRoll()));
    tvName.setText(student.getName());
    tvCourse.setText(student.getCourse());

    ivBtnEdit.setOnClickListener(v -> {
      viewStudentFragment.processEdit(student);
    });

    ivBtnDelete.setOnClickListener(v -> {
      viewStudentFragment.processDelete(student.getRoll());
    });

    return view;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
    notifyDataSetChanged();
  }
}
