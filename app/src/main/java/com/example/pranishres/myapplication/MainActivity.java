package com.example.pranishres.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String MY_TAG = "custom message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // sets the layout for the activity
        System.out.println("onCreate()");

        // Printing Logs
        Log.i(MY_TAG, "onCreate()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(MY_TAG, "onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(MY_TAG, "onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(MY_TAG,"onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(MY_TAG,"onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(MY_TAG,"onDestroy()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(MY_TAG,"onRestart()");
    }
}
