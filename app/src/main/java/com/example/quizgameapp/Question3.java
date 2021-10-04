package com.example.quizgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    String earned;
    TextView amountEarned;
    RadioButton radio3_1, radio3_2, radio3_3, radio3_4;
    private boolean correct3;
    String tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        radio3_1 = (RadioButton) findViewById(R.id.radio3_1);
        radio3_2 = (RadioButton) findViewById(R.id.radio3_2);
        radio3_3 = (RadioButton) findViewById(R.id.radio3_3);
        radio3_4 = (RadioButton) findViewById(R.id.radio3_4);

        Intent recInt = getIntent();

        earned = (String) String.valueOf(recInt.getIntExtra("totalScore", 0));
        tvScore = getString(R.string.baseScore);
        amountEarned = (TextView) findViewById(R.id.amountEarned);


        amountEarned.setText(tvScore + earned);
    }

    public void radio3clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio3_1:
                if (checked) {
                    radio3_1.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct3 = false;
                    break;
                }
            case R.id.radio3_2:
                if (checked) {
                    radio3_2.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct3 = false;
                    break;
                }
            case R.id.radio3_3:
                if (checked) {
                    radio3_3.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct3 = true;
                    break;
                }
            case R.id.radio3_4:
                if (checked) {
                    radio3_4.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct3 = false;
                    break;
                }
        }
    }

    public void confirmAnswer(View view) {

        if (correct3) {
            Toast.makeText(Question3.this, "That answer is correct! You earned $300!", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question4.class);
            n.putExtra("totalScore", 300);
            startActivity(n);
        }
        else {
            Toast.makeText(Question3.this, "That answer is incorrect! You didn't earn anything.", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question4.class);
            n.putExtra("totalScore", 0);
            startActivity(n);
        }
    }
}