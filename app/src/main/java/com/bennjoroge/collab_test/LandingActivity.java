package com.bennjoroge.collab_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class LandingActivity extends AppCompatActivity {

    String mUsername;
    String mMonth;
    Integer mNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        getEditTextsData();
    }

    private boolean getEditTextsData() {

        EditText usernameEditText = findViewById(R.id.username_edit_text);
        EditText monthEditText = findViewById(R.id.month_edit_text);
        EditText numberEditText = findViewById(R.id.number_edit_text);

        mUsername = usernameEditText.getText().toString();
        mMonth = monthEditText.getText().toString();
        mNumber = Integer.parseInt(numberEditText.getText().toString());

        if (!checkIfStringIsEmpty(mUsername, mMonth, mNumber)){
            Toast.makeText(this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean checkIfStringIsEmpty(String name, String month, Integer number) {
        return TextUtils.isEmpty(name) || TextUtils.isEmpty(month) || number == null;
    }
}
