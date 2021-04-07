package com.chitransh.testrun1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chitransh.testrun1.R;
import com.chitransh.testrun1.Student;

import java.util.List;

public class StudentListAdapter extends BaseAdapter {

  private final Context context;
  private List<Student> studentList;

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
    return view;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
    notifyDataSetChanged();
  }
}
