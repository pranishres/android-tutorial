package com.app.tutorial.android.sqlite_app;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.app.tutorial.android.sqlite_app.config.DatabaseConfig;
import com.app.tutorial.android.sqlite_app.model.Student;

public class MainActivity extends AppCompatActivity {
    DatabaseConfig dbConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbConfig = new DatabaseConfig(this);

        populateData();
        getData();
    }

    private void populateData(){
        Student student  = new Student();
        student.setFirstName("Pranish");
        student.setLastName("Shrestha");
        student.setAddress("Ason");
        student.setEmail("er@gmail.com");

        Boolean result = dbConfig.insertData(student);

        if(result){
            System.out.println("Data has been inserted successfully" );
            Toast.makeText(MainActivity.this, "Data has been inserted successfully" , Toast.LENGTH_SHORT);
        }else {
            System.out.println("Error while inserting data" );
            Toast.makeText(MainActivity.this, "Error while inserting data" , Toast.LENGTH_SHORT);
        }
    }

    private void getData(){
        Cursor cursor =  dbConfig.getAllData();
        if(cursor.getCount() == 0){
            showMessage("Error" , "No data found");
            return;
        }

        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()){
            stringBuffer.append("Id : " + cursor.getString(0) + "\n");
            stringBuffer.append("First Name : " + cursor.getString(1) + "\n");
            stringBuffer.append("Last Name : " + cursor.getString(2) + "\n");
            stringBuffer.append("Address : " + cursor.getString(3) + "\n");
            stringBuffer.append("Email : " + cursor.getString(4) + "\n");
        }

        showMessage("Data" , stringBuffer.toString());

    }

    private void showMessage(String title , String message){
        AlertDialog.Builder builder =   new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
