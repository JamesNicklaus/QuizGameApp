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

public class Question1 extends AppCompatActivity {

    TextView amountEarned;
    RadioButton radio1_1, radio1_2, radio1_3, radio1_4;
    private boolean correct1;
    String tvScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        radio1_1 = (RadioButton) findViewById(R.id.radio1_1);
        radio1_2 = (RadioButton) findViewById(R.id.radio1_2);
        radio1_3 = (RadioButton) findViewById(R.id.radio1_3);
        radio1_4 = (RadioButton) findViewById(R.id.radio1_4);

        tvScore = getString(R.string.baseScore);
        amountEarned = findViewById(R.id.amountEarned);
        amountEarned.setText(tvScore + "0");

    }

    public void radio1clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        //When radio button is clicked, selection is highlighted and bool is set
        switch (view.getId()) {
            case R.id.radio1_1:
                if (checked) {
                    radio1_1.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct1 = false;
                    break;
                }
            case R.id.radio1_2:
                if (checked) {
                    radio1_2.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct1 = false;
                    break;
                }
            case R.id.radio1_3:
                if (checked) {
                    radio1_3.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct1 = false;
                    break;
                }
            case R.id.radio1_4:
                if (checked) {
                    radio1_4.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct1 = true;
                    break;
                }
        }

    }

    public void confirmAnswer(View view) {

        //Checks whether the correct answer is submitted and passes relevant value to next activity
        //Creates toast informing user is the answer was correct
        if (correct1) {
            Toast.makeText(Question1.this, "That answer is correct! You earned $100!", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question2.class);
            n.putExtra("totalScore", 100);
            startActivity(n);
        }
        else {
            Toast.makeText(Question1.this, "That answer is incorrect! You didn't earn anything.", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question2.class);
            n.putExtra("totalScore", 0);
            startActivity(n);
        }
    }
}