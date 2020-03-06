package com.jawstrength.powerliftingattemptselectioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView sq1Low = findViewById(R.id.sq1Low);
        TextView sq1Normal = findViewById(R.id.sq1Normal);
        TextView sq1High = findViewById(R.id.sq1High);

        TextView sq2Low = findViewById(R.id.sq2Low);
        TextView sq2Normal = findViewById(R.id.sq2Normal);
        TextView sq2High = findViewById(R.id.sq2High);

        TextView sq3Low = findViewById(R.id.sq3Low);
        TextView sq3Normal = findViewById(R.id.sq3Normal);
        TextView sq3High = findViewById(R.id.sq3High);


        int sq1Attempt = getIntent().getExtras().getInt("Squat1st");
        int sq2Attempt = getIntent().getExtras().getInt("Squat2nd");
        int sq3Attempt = getIntent().getExtras().getInt("Squat3rd");

        int bn1Attempt = getIntent().getExtras().getInt("Bench1st");
        int bn2Attempt = getIntent().getExtras().getInt("Bench2nd");
        int bn3Attempt = getIntent().getExtras().getInt("Bench3rd");

        int dl1Attempt = getIntent().getExtras().getInt("Deadlift1st");
        int dl2Attempt = getIntent().getExtras().getInt("Deadlift2nd");
        int dl3Attempt = getIntent().getExtras().getInt("Deadlift3rd");


        sq1Low.setText(String.valueOf((int)(sq1Attempt-(sq1Attempt * 0.01))));
        sq1Normal.setText(String.valueOf(sq1Attempt));
        sq1High.setText(String.valueOf((int)(sq1Attempt+(sq1Attempt * 0.02))));

        sq2Low.setText(String.valueOf((int)(sq2Attempt-(sq2Attempt * 0.01))));
        sq2Normal.setText(String.valueOf(sq2Attempt));
        sq2High.setText(String.valueOf((int)(sq2Attempt+(sq2Attempt * 0.02))));

        sq3Low.setText(String.valueOf((int)(sq3Attempt-(sq3Attempt * 0.01))));
        sq3Normal.setText(String.valueOf(sq3Attempt));
        sq3High.setText(String.valueOf((int)(sq3Attempt+(sq3Attempt * 0.02))));











    }
}
