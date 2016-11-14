package com.app.tutorial.android.sqlite_app;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.tutorial.android.sqlite_app.adapters.StudentAdapter;
import com.app.tutorial.android.sqlite_app.model.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class student_list extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        List<Student> students = (List) getIntent().getSerializableExtra("studentData");
        StudentAdapter studentAdapter = new StudentAdapter(this , R.layout.activity_student_list , students);
        setListAdapter(studentAdapter);
    }
}
