package com.example.pranishres.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String MY_TAG = "custom message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The Simple Hello World Activity
//        setContentView(R.layout.activity_main);

        // Activity which takes two numbers from user and adds it
        setContentView(R.layout.add_two_numbers);

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

    /**
     * Layout name :- add_two_numbers
     * Method Type :- Handle button click event
     * Purpose     :- Take the values for 2 numbers provided by the user and display the sum result.
     * @param v
     */
    public void onButtonClick(View v){

        Log.i(MY_TAG , " Button click event executed successfully ");

        // Getting the components with its id and then converting explicitly to its Class

        // Getting the edit text with its id. Then convert explicitly to EditText
        EditText e1 = (EditText) findViewById(R.id.editText_firstNumber);
        EditText e2 = (EditText) findViewById(R.id.editText_secondNumber);

        TextView t1 = (TextView) findViewById(R.id.txtView_ResultPrint);

        // Getting integer values from the text fields
        int number1 =  Integer.parseInt(e1.getText().toString());
        int number2 = Integer.parseInt(e2.getText().toString());

        Log.i(MY_TAG, "The sum is : " + (number1+number2));

        t1.setText(Integer.toString(number1+number2));

    }
}
