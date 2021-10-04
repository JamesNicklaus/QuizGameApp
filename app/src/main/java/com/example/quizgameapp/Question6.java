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

public class Question6 extends AppCompatActivity {

    String earned;
    TextView amountEarned;
    RadioButton radio6_1, radio6_2, radio6_3, radio6_4;
    private boolean correct6;
    String tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);

        radio6_1 = (RadioButton) findViewById(R.id.radio6_1);
        radio6_2 = (RadioButton) findViewById(R.id.radio6_2);
        radio6_3 = (RadioButton) findViewById(R.id.radio6_3);
        radio6_4 = (RadioButton) findViewById(R.id.radio6_4);

        Intent recInt = getIntent();

        earned = (String) String.valueOf(recInt.getIntExtra("totalScore", 0));
        tvScore = getString(R.string.baseScore);
        amountEarned = (TextView) findViewById(R.id.amountEarned);


        amountEarned.setText(tvScore + earned);
    }

    public void radio6clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio6_1:
                if (checked) {
                    radio6_1.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct6 = true;
                    break;
                }
            case R.id.radio6_2:
                if (checked) {
                    radio6_2.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct6 = false;
                    break;
                }
            case R.id.radio6_3:
                if (checked) {
                    radio6_3.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct6 = false;
                    break;
                }
            case R.id.radio6_4:
                if (checked) {
                    radio6_4.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct6 = false;
                    break;
                }
        }
    }

    public void confirmAnswer(View view) {

        if (correct6) {
            Toast.makeText(Question6.this, "That answer is correct! You earned $600!", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question7.class);
            n.putExtra("totalScore", 600);
            startActivity(n);
        }
        else {
            Toast.makeText(Question6.this, "That answer is incorrect! You didn't earn anything.", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question7.class);
            n.putExtra("totalScore", 0);
            startActivity(n);
        }
    }
}