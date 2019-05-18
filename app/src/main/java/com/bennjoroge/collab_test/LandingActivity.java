package com.bennjoroge.collab_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LandingActivity extends AppCompatActivity {

    private String mUsername;
    private String mMonth;
    private Integer mNumber;

    Button nextActivityButton;

    private EditText usernameEditText;
    private EditText monthEditText;
    private EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //set EditTexts
        usernameEditText = findViewById(R.id.username_edit_text);
        monthEditText = findViewById(R.id.month_edit_text);
        numberEditText = findViewById(R.id.number_edit_text);


        //get next button and configure to open new Activity
        nextActivityButton = findViewById(R.id.next_activity_button);
        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isAllEditTextsFilled()) {

                    setEditTextsData();

                    openAnotherActivity();
                }

            }
        });
    }

    private boolean isAllEditTextsFilled() {
        if (TextUtils.isEmpty(usernameEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your name ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(monthEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your month ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(numberEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your number ", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void openAnotherActivity() {
        Intent myIntent = new Intent(LandingActivity.this, MainActivity.class);
        myIntent.putExtra("username", mUsername);
        myIntent.putExtra("month", mMonth);
        myIntent.putExtra("number", mNumber);
        startActivity(myIntent);

    }

    private void setEditTextsData() {

        mUsername = usernameEditText.getText().toString();
        mMonth = monthEditText.getText().toString();
        mNumber = Integer.parseInt(numberEditText.getText().toString());

    }


}
