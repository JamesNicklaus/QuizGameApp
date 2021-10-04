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

public class Question5 extends AppCompatActivity {

    String earned;
    TextView amountEarned;
    RadioButton radio5_1, radio5_2, radio5_3, radio5_4;
    private boolean correct5;
    String tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        radio5_1 = (RadioButton) findViewById(R.id.radio5_1);
        radio5_2 = (RadioButton) findViewById(R.id.radio5_2);
        radio5_3 = (RadioButton) findViewById(R.id.radio5_3);
        radio5_4 = (RadioButton) findViewById(R.id.radio5_4);

        Intent recInt = getIntent();

        earned = (String) String.valueOf(recInt.getIntExtra("totalScore", 0));
        tvScore = getString(R.string.baseScore);
        amountEarned = (TextView) findViewById(R.id.amountEarned);


        amountEarned.setText(tvScore + earned);
    }

    public void radio5clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio5_1:
                if (checked) {
                    radio5_1.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct5 = false;
                    break;
                }
            case R.id.radio5_2:
                if (checked) {
                    radio5_2.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct5 = false;
                    break;
                }
            case R.id.radio5_3:
                if (checked) {
                    radio5_3.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct5 = false;
                    break;
                }
            case R.id.radio5_4:
                if (checked) {
                    radio5_4.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct5 = true;
                    break;
                }
        }
    }

    public void confirmAnswer(View view) {

        if (correct5) {
            Toast.makeText(Question5.this, "That answer is correct! You earned $500!", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question6.class);
            n.putExtra("totalScore", 500);
            startActivity(n);
        }
        else {
            Toast.makeText(Question5.this, "That answer is incorrect! You didn't earn anything.", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question6.class);
            n.putExtra("totalScore", 0);
            startActivity(n);
        }
    }
}