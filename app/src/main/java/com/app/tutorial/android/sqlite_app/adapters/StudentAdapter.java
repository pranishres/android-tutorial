package com.app.tutorial.android.sqlite_app.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.tutorial.android.sqlite_app.R;
import com.app.tutorial.android.sqlite_app.model.Student;

import java.util.List;

/**
 * Created by pranishres on 11/11/16.
 * Custom Adapter for populating Student list of data
 */

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.studentList = objects;
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.student_list_layout , parent , false);

        // Display Student name in the TextView widget
        Student student =studentList.get(position);
        /* We need to load the data in another layout which has a textview and then load that textview
        in the list view*/
        TextView tv = (TextView) view.findViewById(R.id.textView_student_list_layout);
        tv.setText(student.getFirstName() + " " + student.getLastName());

        return view;
    }
}
