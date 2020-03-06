package com.jawstrength.powerliftingattemptselectioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText sqRepID = findViewById(R.id.sqRep);
        final EditText sqWeightID = findViewById(R.id.sqWeight);
        final EditText sqRpeID = findViewById(R.id.sqRpe);

        final EditText bnRepID = findViewById(R.id.bnRep);
        final EditText bnWeightID = findViewById(R.id.bnWeight);
        final EditText bnRpeID = findViewById(R.id.bnRpe);

        final EditText dlRepID = findViewById(R.id.dlRep);
        final EditText dlWeightID = findViewById(R.id.dlWeight);
        final EditText dlRpeID = findViewById(R.id.dlRpe);

        final Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sqRepInput = Integer.parseInt(sqRepID.getText().toString());
                int sqWeightInput = Integer.parseInt(sqWeightID.getText().toString());
                int sqRpeInput = Integer.parseInt(sqRpeID.getText().toString());
                int sq1RM = oneRepMax(sqRepInput,sqWeightInput, sqRpeInput);
                int sq1st = firstAttempt(sq1RM);
                int sq2nd = secondAttempt(sq1RM);
                int sq3rd = thirdAttempt(sq1RM);

                int bnRepInput = Integer.parseInt(bnRepID.getText().toString());
                int bnWeightInput = Integer.parseInt(bnWeightID.getText().toString());
                int bnRpeInput = Integer.parseInt(bnRpeID.getText().toString());
                int bn1RM = oneRepMax(bnRepInput,bnWeightInput, bnRpeInput);
                int bn1st = firstAttempt(bn1RM);
                int bn2nd = secondAttempt(bn1RM);
                int bn3rd = thirdAttempt(bn1RM);

                int dlRepInput = Integer.parseInt(dlRepID.getText().toString());
                int dlWeightInput = Integer.parseInt(dlWeightID.getText().toString());
                int dlRpeInput = Integer.parseInt(dlRpeID.getText().toString());
                int dl1RM = oneRepMax(dlRepInput,dlWeightInput, dlRpeInput);
                int dl1st = firstAttempt(dl1RM);
                int dl2nd = secondAttempt(dl1RM);
                int dl3rd = thirdAttempt(dl1RM);


                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Squat1st", sq1st);
                bundle.putInt("Squat2nd", sq2nd);
                bundle.putInt("Squat3rd", sq3rd);

                bundle.putInt("Bench1st", bn1st);
                bundle.putInt("Bench2nd", bn2nd);
                bundle.putInt("Bench3rd", bn3rd);

                bundle.putInt("Deadlift1st", dl1st);
                bundle.putInt("Deadlift2nd", dl2nd);
                bundle.putInt("Deadlift3rd", dl3rd);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public int firstAttempt(int oneRepMax)
    {
        return (int)(oneRepMax * 0.90);
    }

    public int secondAttempt(int oneRepMax)
    {
        return (int)(oneRepMax * 0.95);
    }

    public int thirdAttempt(int oneRepMax)
    {
        return oneRepMax;
    }

    public int oneRepMax(int rep, int weight, int rpe)
    {
        return (int)((weight*((10-(rpe+1))+rep)*0.03)+weight);
    }
}
