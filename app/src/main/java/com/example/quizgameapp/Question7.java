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

public class Question7 extends AppCompatActivity {

    String earned;
    TextView amountEarned;
    RadioButton radio7_1, radio7_2, radio7_3, radio7_4;
    private boolean correct7;
    String tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);

        radio7_1 = (RadioButton) findViewById(R.id.radio7_1);
        radio7_2 = (RadioButton) findViewById(R.id.radio7_2);
        radio7_3 = (RadioButton) findViewById(R.id.radio7_3);
        radio7_4 = (RadioButton) findViewById(R.id.radio7_4);

        Intent recInt = getIntent();

        earned = (String) String.valueOf(recInt.getIntExtra("totalScore", 0));
        tvScore = getString(R.string.baseScore);
        amountEarned = (TextView) findViewById(R.id.amountEarned);


        amountEarned.setText(tvScore + earned);
    }

    public void radio7clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio7_1:
                if (checked) {
                    radio7_1.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct7 = false;
                    break;
                }
            case R.id.radio7_2:
                if (checked) {
                    radio7_2.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct7 = true;
                    break;
                }
            case R.id.radio7_3:
                if (checked) {
                    radio7_3.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct7 = false;
                    break;
                }
            case R.id.radio7_4:
                if (checked) {
                    radio7_4.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct7 = false;
                    break;
                }
        }
    }

    public void confirmAnswer(View view) {

        if (correct7) {
            Toast.makeText(Question7.this, "That answer is correct! You earned $700!", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, SplashScreen.class);
            n.putExtra("totalScore", 700);
            startActivity(n);
        }
        else {
            Toast.makeText(Question7.this, "That answer is incorrect! You didn't earn anything.", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, SplashScreen.class);
            n.putExtra("totalScore", 0);
            startActivity(n);
        }
    }
}