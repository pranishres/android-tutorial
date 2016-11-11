package com.app.tutorial.android.sqlite_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class student_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        ArrayList<String> allData = getIntent().getStringArrayListExtra("allData");

        ListView lvCountries = (ListView) findViewById(R.id.array_adapter_listView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(student_list.this, android.R.layout.simple_list_item_1, allData);
        lvCountries.setAdapter(arrayAdapter);

    }
}
