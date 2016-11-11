package com.app.tutorial.android.sqlite_app;

import android.app.AlertDialog;
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

import com.app.tutorial.android.sqlite_app.config.DatabaseConfig;
import com.app.tutorial.android.sqlite_app.model.Student;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ActionBarActivity {
    DatabaseConfig dbConfig;



    /*For adapter view*/
    String[] allData = new String[]{
            "Nepal",
            "China",
            "Japan",
            "U.S.A",
            "U.K",
            "Spain",
            "Portugal",
            "Satungal",
            "Latungal",
            "Hatungal",
            "Patungal",
            "Matungal",
            "France",
            "Dance",
            "Brance",
            "aaNepal",
            "aaChina",
            "aaJapan",
            "aaU.S.A",
            "aaU.K",
            "aaSpain",
            "aaPortugal",
            "aaSatungal",
            "aaLatungal",
            "aaHatungal",
            "aPatungal",
            "aMatungal",
            "aFrance",
            "aDance",
            "aBrance",
    };

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        dbConfig = new DatabaseConfig(this);

        ListView lvCountries = (ListView) findViewById(R.id.array_adapter_listView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1  , allData);
        lvCountries.setAdapter(arrayAdapter);

        // Needs to be called to enable Butterknife annotations
        ButterKnife.bind(this);

    }

}
