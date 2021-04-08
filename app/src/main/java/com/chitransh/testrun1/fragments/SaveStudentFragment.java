package com.chitransh.testrun1.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chitransh.testrun1.DBHelper;
import com.chitransh.testrun1.R;
import com.chitransh.testrun1.Student;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveStudentFragment extends Fragment {

  private View mv;
  private Student oldStudent;

  private EditText etRoll;
  private EditText etName;
  private EditText etAddress;
  private EditText etCourse;
  private Button bClear;
  private Button bSave;
  private ImageView ivPhoto;

  private DBHelper dbHelper;
  private Bitmap selectedStudentBitmap;

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

  @Override
  public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == Activity.RESULT_OK) {
      if (data == null) {
        Toast.makeText(getActivity(), "Failed to create image file!", Toast.LENGTH_SHORT).show();
        return;
      }

      Picasso.get().load(String.valueOf(data.getData())).into(new com.squareup.picasso.Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
          ivPhoto.setImageBitmap(bitmap);
          selectedStudentBitmap = bitmap;
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
        }
      });

    }
  }

  private void instantiate() {
    etRoll = mv.findViewById(R.id.etRoll);
    etName = mv.findViewById(R.id.etName);
    etAddress = mv.findViewById(R.id.etAddress);
    etCourse = mv.findViewById(R.id.etCourse);

    bClear = mv.findViewById(R.id.bClear);
    bSave = mv.findViewById(R.id.bSave);

    ivPhoto = mv.findViewById(R.id.ivPhoto);

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
    ivPhoto.setOnClickListener(v -> processPickPhoto());

    bClear.setOnClickListener(v -> clear());

    bSave.setOnClickListener(v -> save());
  }

  private void processPickPhoto() {
    ImagePicker.Companion.with(this)
      .crop()
      .compress(1024)
      .maxResultSize(1080, 1080)
      .start();
  }

  private String savePhotoAndGetURI() {
    if (selectedStudentBitmap != null) {
      File file = new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "/" + etName.getText() + ".png");

      try {
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        selectedStudentBitmap.compress(Bitmap.CompressFormat.PNG, 60, fileOutputStream);

        fileOutputStream.flush();
        fileOutputStream.close();

        return file.getAbsolutePath();
      } catch (IOException e) {
      }
    }

    return "";
  }

  private void clear() {
    etRoll.setText("");
    etName.setText("");
    etAddress.setText("");
    etCourse.setText("");
  }

  private void save() {
    Student student = new Student();

    student.setPhotoURI(savePhotoAndGetURI());
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

//  public static void loadBitmapWithPicasso(Object imagePath, Callback<Bitmap> onLoaded) {
//    Picasso.get().load(getString(imagePath)).into(new Target() {
//      @Override
//      public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//        if (onLoaded != null) onLoaded.exec(bitmap);
//      }
//
//      @Override
//      public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//      }
//
//      @Override
//      public void onPrepareLoad(Drawable placeHolderDrawable) {
//      }
//    });
//  }

}