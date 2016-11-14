package com.app.tutorial.android.sqlite_app;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.app.tutorial.android.sqlite_app.adapters.StudentAdapter;
import com.app.tutorial.android.sqlite_app.config.DatabaseConfig;
import com.app.tutorial.android.sqlite_app.model.Student;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    DatabaseConfig dbConfig;


    // Alternative to findViewById. Needs Butterknife dependencies
    @BindView(R.id.editText_main_firstName)
    EditText firstName;
    @BindView(R.id.editText_main_lastName)
    EditText lastName;
    @BindView(R.id.editText_main_Address)
    EditText address;
    @BindView(R.id.editText_main_email)
    EditText email;
    @BindView(R.id.editText_main_getById)
    EditText getById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbConfig = new DatabaseConfig(this);

        // Needs to be called to enable Butterknife annotations
        ButterKnife.bind(this);

    }

    public void onButtonSubmit(View view) {
        Student student = new Student();
        student.setFirstName(firstName.getText().toString());
        student.setLastName(lastName.getText().toString());
        student.setAddress(address.getText().toString());
        student.setEmail(email.getText().toString());

        Boolean result = dbConfig.insertData(student);

        if (result) {
            System.out.println("Data has been inserted successfully");
            Toast.makeText(MainActivity.this, "Data has been inserted successfully", Toast.LENGTH_SHORT);
        } else {
            System.out.println("Error while inserting data");
            Toast.makeText(MainActivity.this, "Error while inserting data", Toast.LENGTH_SHORT);
        }
    }

    /**
     * Populates all data on a alert dialog using string buffer
     * @param view
     */
    public void getAllData(View view) {
       Cursor cursor = dbConfig.getAllData();
        if (cursor.getCount() == 0) {
            showMessage("Error", "No data found");
            return;
        }

        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()) {
            stringBuffer.append("Id : " + cursor.getString(0) + "\n");
            stringBuffer.append("First Name : " + cursor.getString(1) + "\n");
            stringBuffer.append("Last Name : " + cursor.getString(2) + "\n");
            stringBuffer.append("Address : " + cursor.getString(3) + "\n");
            stringBuffer.append("Email : " + cursor.getString(4) + "\n");
        }

        showMessage("Data", stringBuffer.toString());

    }

    /**
     * Populates all data in list view in a new activity via Intent
     * Uses a Custom Adapter
     * @param view
     */
    public void getAllData_v2(View view) {
        ArrayList<Student> students = new ArrayList<>();

        Cursor cursor = dbConfig.getAllData();
        if (cursor.getCount() == 0) {
            showMessage("Error", "No data found");
            return;
        }
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.setFirstName(cursor.getString(1));
            student.setLastName(cursor.getString(2));
            student.setAddress(cursor.getString(3));
            student.setEmail(cursor.getString(4));

            students.add(student);
        }

        Intent intent = new Intent(this , student_list.class);
        intent.putExtra("studentData", students);
        startActivity(intent);

    }

    public void getById(View view) {
       Cursor cursor = dbConfig.getById(Integer.parseInt(getById.getText().toString()));

        if (cursor.getCount() == 0) {
            showMessage("Error", "No data found");
            return;
        }
        while (cursor.moveToNext()) {
            firstName.setText(cursor.getString(1));
            lastName.setText(cursor.getString(2));
        }
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
