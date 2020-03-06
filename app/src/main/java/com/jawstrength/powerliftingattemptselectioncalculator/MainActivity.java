package com.jawstrength.powerliftingattemptselectioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.xml.transform.Result;


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

                //Toast.makeText(getApplicationContext(),"Hello toast",Toast.LENGTH_SHORT).show();

                int sqRepInput = Integer.parseInt(sqRepID.getText().toString());
                int sqWeightInput = Integer.parseInt(sqWeightID.getText().toString());
                int sqRpeInput = Integer.parseInt(sqRpeID.getText().toString());

                int sq1RM = calculate1RM(sqRepInput,sqWeightInput, sqRpeInput);

                Log.d("TAG", String.valueOf(sq1RM));


                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Squat 1RM", sq1RM);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }


    public int calculate1RM(int rep, int weight, int rpe)
    {
        return (int)((weight*((10-(rpe+1))+rep)*0.03)+weight);
    }
}
