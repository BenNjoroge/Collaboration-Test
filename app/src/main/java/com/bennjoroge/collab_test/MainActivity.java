package com.bennjoroge.collab_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int NO_USER_NUMBER_ENTERED = -1;
    private String userName;
    private String userMonth;
    private int userNumber;

    private TextView randomNumberTextView;
    private TextView usernameTextView;
    private TextView monthTextView;
    private TextView numberTextView;
    private Button regenerateButton;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gets all the TextViews place holders
        usernameTextView = findViewById(R.id.username_text_view);
        monthTextView = findViewById(R.id.month_text_view);
        numberTextView = findViewById(R.id.number_text_view);
        randomNumberTextView = findViewById(R.id.random_number_text_view);

        regenerateButton = findViewById(R.id.regenerate_button);
        backButton = findViewById(R.id.back_button);

        getUserDetails();

        setUserDetails();

        setRandomNumber();

        regenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomNumber();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, LandingActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void setRandomNumber() {
        randomNumberTextView.setText(String.valueOf(generateRandomNumber()));
    }

    private void setUserDetails() {
        //sets the placeholders to the input data from LandingActivity
        usernameTextView.setText(userName);
        monthTextView.setText(userMonth);
        numberTextView.setText(String.valueOf(userNumber));
    }

    private void getUserDetails() {
        Intent myIntent = getIntent();
        userName = myIntent.getStringExtra("username");
        userMonth = myIntent.getStringExtra("month");
        userNumber = myIntent.getIntExtra("number", NO_USER_NUMBER_ENTERED);
    }

    private int generateRandomNumber() {
        //generate random number with Random class
        Random rand = new Random();
        return rand.nextInt(50) + 1;
    }

}
