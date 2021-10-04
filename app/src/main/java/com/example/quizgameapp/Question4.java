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

public class Question4 extends AppCompatActivity {

    String earned;
    TextView amountEarned;
    RadioButton radio4_1, radio4_2, radio4_3, radio4_4;
    private boolean correct4;
    String tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        radio4_1 = (RadioButton) findViewById(R.id.radio4_1);
        radio4_2 = (RadioButton) findViewById(R.id.radio4_2);
        radio4_3 = (RadioButton) findViewById(R.id.radio4_3);
        radio4_4 = (RadioButton) findViewById(R.id.radio4_4);

        Intent recInt = getIntent();

        earned = (String) String.valueOf(recInt.getIntExtra("totalScore", 0));
        tvScore = getString(R.string.baseScore);
        amountEarned = (TextView) findViewById(R.id.amountEarned);


        amountEarned.setText(tvScore + earned);
    }

    public void radio4clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio4_1:
                if (checked) {
                    radio4_1.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct4 = false;
                    break;
                }
            case R.id.radio4_2:
                if (checked) {
                    radio4_2.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct4 = true;
                    break;
                }
            case R.id.radio4_3:
                if (checked) {
                    radio4_3.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct4 = false;
                    break;
                }
            case R.id.radio4_4:
                if (checked) {
                    radio4_4.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct4 = false;
                    break;
                }
        }
    }

    public void confirmAnswer(View view) {

        if (correct4) {
            Toast.makeText(Question4.this, "That answer is correct! You earned $400!", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question5.class);
            n.putExtra("totalScore", 400);
            startActivity(n);
        }
        else {
            Toast.makeText(Question4.this, "That answer is incorrect! You didn't earn anything.", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question5.class);
            n.putExtra("totalScore", 0);
            startActivity(n);
        }
    }
}