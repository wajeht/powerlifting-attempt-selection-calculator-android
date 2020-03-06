package com.jawstrength.powerliftingattemptselectioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //TextView result = findViewById(R.id.txtResult);

        int sq1Attempt = getIntent().getExtras().getInt("Squat1st");
        int sq2Attempt = getIntent().getExtras().getInt("Squat2nd");
        int sq3Attempt = getIntent().getExtras().getInt("Squat3rd");
        //result.setText(Integer.toString(sq1Attempt));

        int bn1Attempt = getIntent().getExtras().getInt("Bench1st");
        int bn2Attempt = getIntent().getExtras().getInt("Bench2nd");
        int bn3Attempt = getIntent().getExtras().getInt("Bench3rd");

        int dl1Attempt = getIntent().getExtras().getInt("Deadlift1st");
        int dl2Attempt = getIntent().getExtras().getInt("Deadlift2nd");
        int dl3Attempt = getIntent().getExtras().getInt("Deadlift3rd");










    }
}
