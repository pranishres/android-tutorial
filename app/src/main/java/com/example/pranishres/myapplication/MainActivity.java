package com.example.pranishres.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The application will load onCreate() method first when it gets executed. There are lots of
 * examples used here. All the examples use different activity layout so you will have to
 * uncomment the particular method in the onCrete() method to run the desired activity
 */
public class MainActivity extends AppCompatActivity {

    String MY_TAG = "custom message";

    private EditText password;
    private Button button;


    // Radio button example variables
    private static RadioGroup radioGroup;
    private static Button buttonSubmit;
    private static RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        // The Simple Hello World Activity
        setContentView(R.layout.activity_main);
*/

/*
        // Activity which takes two numbers from user and adds it
        setContentView(R.layout.basic_calculator);
*/

        // Using password field and show password to the user
 /*       setContentView(R.layout.show_password);
        // calling this method will register a button click event
        addListenerOnButton();
*/

  /*
        // Check box basics
            setContentView(R.layout.checkbox);
        // calling this method will register a button click event
            addListenerForCheckbox();
*/

 /*
        // Radio button basics
        setContentView(R.layout.radio_button);
        // calling this method will register a button click event
        addListenerForRadioButton();
*/

   /*
        // Rating basics
        setContentView(R.layout.rating_bar_basics);
        addListernerForRating();
        addListenerForRatingButtonClick();
*/
        // Alert dialog
        setContentView(R.layout.alert_dialog);
        addListenerForAlertDialog();

        // Printing Logs
        Log.i(MY_TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MY_TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MY_TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MY_TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MY_TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MY_TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(MY_TAG, "onRestart()");
    }

    /**
     * Layout name :- basic_calculator
     * Method Type :- Button click event
     * Purpose     :- Take the values for 2 numbers provided by the user and display the sum result.
     *
     * @param v
     */
    public void onButtonClick(View v) {

        Log.i(MY_TAG, " Button click event executed successfully ");

        // Getting the components with its id and then converting explicitly to its Class

        // Getting the edit text with its id. Then convert explicitly to EditText
        EditText e1 = (EditText) findViewById(R.id.editText_firstNumber);
        EditText e2 = (EditText) findViewById(R.id.editText_secondNumber);

        TextView t1 = (TextView) findViewById(R.id.txtView_ResultPrint);

        // Getting integer values from the text fields
        int number1 = Integer.parseInt(e1.getText().toString());
        int number2 = Integer.parseInt(e2.getText().toString());

        Log.i(MY_TAG, "The sum is : " + (number1 + number2));

        t1.setText(Integer.toString(number1 + number2));

    }

    /**
     * Layout name :- show_password
     * Method Type :- Call
     * Purpose     :- Handles button click event and displays the password entered by the user.
     */
    public void addListenerOnButton() {
        password = (EditText) findViewById(R.id.editText_Password_PwddField);
        button = (Button) findViewById(R.id.btn_ShowPassword);

        // Add button click event
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                MainActivity.this, password.getText(), Toast.LENGTH_SHORT
                        ).show();
                    }
                }

        );
    }

    /**
     * Layout name  :- checkbox
     * Method Type  :- Call
     * Purpose      :- Displays the checked items
     */
    public void addListenerForCheckbox() {
        final CheckBox checkboxSwimming = (CheckBox) findViewById(R.id.checkBox_swimming);
        final CheckBox checkboxDancing = (CheckBox) findViewById(R.id.checkBox_dancing);
        final CheckBox checkboxSinging = (CheckBox) findViewById(R.id.checkBox_singing);
        final Button button_check = (Button) findViewById(R.id.button_submit);

        // Add button click event
        button_check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Append all the checkboxes in a String Buffer
                        StringBuffer result = new StringBuffer();
                        result.append("Swimming : ").append(checkboxSwimming.isChecked());
                        result.append(" Dancing : ").append(checkboxDancing.isChecked());
                        result.append(" Singing : ").append(checkboxSinging.isChecked());

                        Toast.makeText(
                                MainActivity.this, result.toString(), Toast.LENGTH_LONG
                        ).show();
                    }
                });

    }

    /**
     * Layout name :- radio_button
     * Method Type :- Call
     * Purpose     :- Display selected radio button value
     */
    public void addListenerForRadioButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        private final RadioButton = radioMale, radioFemale, radioOther ;
        buttonSubmit = (RadioButton) findViewById(R.id.button_RadioSubmit);

        // Add button click event
        buttonSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        radioButton = (RadioButton) findViewById(selectedId);
                        Toast.makeText(
                                MainActivity.this, radioButton.getText().toString(), Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

    }

    /**
     * Layout name :- rating_bar_basics
     * Method type :- Call
     * Purpose     :- Take user rating and display the result
     */
    public void addListernerForRating() {
        final TextView ratingResult = (TextView) findViewById(R.id.textView_ratingResult);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        // Set the value of rating to the textview
                        ratingResult.setText(String.valueOf(rating));
                    }
                }
        );

    }

    /**
     * Layout name :- rating_bar_basics
     * Method type :- Call
     * Purpose     :- Take user rating and display the result on a button click event
     */
    public void addListenerForRatingButtonClick() {
        Button buttonSubmit = (Button) findViewById(R.id.button_ratingSubmit);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        buttonSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }

    /**
     * Layour name :- alert_dialog
     * Method type :- Call
     * Purpose     :- Prompt user to confirm exit event
     */
    public void addListenerForAlertDialog() {
        Button buttonAlert = (Button) findViewById(R.id.button_alert);

        /* Setting click listener to button and then creating an alert dialog. Then setting listener
        events to the alert dialog box buttons*/

        // setting click listener to button
        buttonAlert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // First create an alert dialog builder and then crete an alert dialog

                        // creting alert dialog builder
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                        System.out.println("Alert Dialog button click listener");
                        alertBuilder.setMessage("Do you really want to exit?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        // terminates the applciation
                                        finish();
                                    }
                                })
                                .setNegativeButton("Sorry, No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        // close the dialog box
                                        dialogInterface.cancel();
                                    }
                                });

                        // creating alert dialog using alert dialog builder
                        AlertDialog alertDialog = alertBuilder.create();
                        alertDialog.setTitle("Confirmation");
                        alertDialog.show();
                    }
                }
        );
    }
}
