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

public class Question2 extends AppCompatActivity {

    String earned;
    TextView amountEarned;
    RadioButton radio2_1, radio2_2, radio2_3, radio2_4;
    private boolean correct2;
    String tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        radio2_1 = (RadioButton) findViewById(R.id.radio2_1);
        radio2_2 = (RadioButton) findViewById(R.id.radio2_2);
        radio2_3 = (RadioButton) findViewById(R.id.radio2_3);
        radio2_4 = (RadioButton) findViewById(R.id.radio2_4);

        Intent recInt = getIntent();

        earned = (String) String.valueOf(recInt.getIntExtra("totalScore", 0));
        tvScore = getString(R.string.baseScore);
        amountEarned = (TextView) findViewById(R.id.amountEarned);

        //Updates earning text view based on passed information from previous activity
        amountEarned.setText(tvScore + earned);
    }

    public void radio2clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio2_1:
                if (checked) {
                    radio2_1.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct2 = true;
                    break;
                }
            case R.id.radio2_2:
                if (checked) {
                    radio2_2.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct2 = false;
                    break;
                }
            case R.id.radio2_3:
                if (checked) {
                    radio2_3.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct2 = false;
                    break;
                }
            case R.id.radio2_4:
                if (checked) {
                    radio2_4.setBackgroundColor(Color.parseColor("#FFF100"));
                    correct2 = false;
                    break;
                }
        }
    }

    public void confirmAnswer(View view) {

        if (correct2) {
            Toast.makeText(Question2.this, "That answer is correct! You earned $200!", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question3.class);
            n.putExtra("totalScore", 200);
            startActivity(n);
        }
        else {
            Toast.makeText(Question2.this, "That answer is incorrect! You didn't earn anything.", Toast.LENGTH_LONG).show();

            Intent n = new Intent(this, Question3.class);
            n.putExtra("totalScore", 0);
            startActivity(n);
        }
    }
}