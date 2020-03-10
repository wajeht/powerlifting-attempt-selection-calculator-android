package com.jawstrength.powerliftingattemptselectioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // assign id
        TextView sq1Low = findViewById(R.id.sq1Low);
        TextView sq1Normal = findViewById(R.id.sq1Normal);
        TextView sq1High = findViewById(R.id.sq1High);

        TextView sq2Low = findViewById(R.id.sq2Low);
        TextView sq2Normal = findViewById(R.id.sq2Normal);
        TextView sq2High = findViewById(R.id.sq2High);

        TextView sq3Low = findViewById(R.id.sq3Low);
        TextView sq3Normal = findViewById(R.id.sq3Normal);
        TextView sq3High = findViewById(R.id.sq3High);

        TextView bn1Low = findViewById(R.id.bn1Low);
        TextView bn1Normal = findViewById(R.id.bn1Normal);
        TextView bn1High = findViewById(R.id.bn1High);

        TextView bn2Low = findViewById(R.id.bn2Low);
        TextView bn2Normal = findViewById(R.id.bn2Normal);
        TextView bn2High = findViewById(R.id.bn2High);

        TextView bn3Low = findViewById(R.id.bn3Low);
        TextView bn3Normal = findViewById(R.id.bn3Normal);
        TextView bn3High = findViewById(R.id.bn3High);

        TextView dl1Low = findViewById(R.id.dl1Low);
        TextView dl1Normal = findViewById(R.id.dl1Normal);
        TextView dl1High = findViewById(R.id.dl1High);

        TextView dl2Low = findViewById(R.id.dl2Low);
        TextView dl2Normal = findViewById(R.id.dl2Normal);
        TextView dl2High = findViewById(R.id.dl2High);

        TextView dl3Low = findViewById(R.id.dl3Low);
        TextView dl3Normal = findViewById(R.id.dl3Normal);
        TextView dl3High = findViewById(R.id.dl3High);

        // get user data from mainActivity
        int sq1Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_SQUAT_1);
        int sq2Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_SQUAT_2);
        int sq3Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_SQUAT_3);

        int bn1Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_BENCH_1);
        int bn2Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_BENCH_2);
        int bn3Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_BENCH_3);

        int dl1Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_DEADLIFT_1);
        int dl2Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_DEADLIFT_2);
        int dl3Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_DEADLIFT_3);

        // print out squat attempts
        sq1Low.setText(String.valueOf((int)(sq1Attempt-(sq1Attempt * 0.01))));
        sq1Normal.setText(String.valueOf(sq1Attempt));
        sq1High.setText(String.valueOf((int)(sq1Attempt+(sq1Attempt * 0.02))));

        sq2Low.setText(String.valueOf((int)(sq2Attempt-(sq2Attempt * 0.01))));
        sq2Normal.setText(String.valueOf(sq2Attempt));
        sq2High.setText(String.valueOf((int)(sq2Attempt+(sq2Attempt * 0.02))));

        sq3Low.setText(String.valueOf((int)(sq3Attempt-(sq3Attempt * 0.01))));
        sq3Normal.setText(String.valueOf(sq3Attempt));
        sq3High.setText(String.valueOf((int)(sq3Attempt+(sq3Attempt * 0.02))));

        // print out bench attempts
        bn1Low.setText(String.valueOf((int)(bn1Attempt-(bn1Attempt * 0.01))));
        bn1Normal.setText(String.valueOf(bn1Attempt));
        bn1High.setText(String.valueOf((int)(bn1Attempt+(bn1Attempt * 0.02))));

        bn2Low.setText(String.valueOf((int)(bn2Attempt-(bn2Attempt * 0.01))));
        bn2Normal.setText(String.valueOf(bn2Attempt));
        bn2High.setText(String.valueOf((int)(bn2Attempt+(bn2Attempt * 0.02))));

        bn3Low.setText(String.valueOf((int)(bn3Attempt-(bn3Attempt * 0.01))));
        bn3Normal.setText(String.valueOf(bn3Attempt));
        bn3High.setText(String.valueOf((int)(bn3Attempt+(bn3Attempt * 0.02))));

        // print out deadlift attempts
        dl1Low.setText(String.valueOf((int)(dl1Attempt-(dl1Attempt * 0.01))));
        dl1Normal.setText(String.valueOf(dl1Attempt));
        dl1High.setText(String.valueOf((int)(dl1Attempt+(dl1Attempt * 0.02))));

        dl2Low.setText(String.valueOf((int)(dl2Attempt-(dl2Attempt * 0.01))));
        dl2Normal.setText(String.valueOf(dl2Attempt));
        dl2High.setText(String.valueOf((int)(dl2Attempt+(dl2Attempt * 0.02))));

        dl3Low.setText(String.valueOf((int)(dl3Attempt-(dl3Attempt * 0.01))));
        dl3Normal.setText(String.valueOf(dl3Attempt));
        dl3High.setText(String.valueOf((int)(dl3Attempt+(dl3Attempt * 0.02))));
    }
}
