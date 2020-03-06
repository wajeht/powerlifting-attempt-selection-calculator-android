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
        EditText sqWeightID = findViewById(R.id.sqWeight);
        EditText sqRpeID = findViewById(R.id.sqRpe);

        EditText bnRepID = findViewById(R.id.bnRep);
        EditText bnWeightID = findViewById(R.id.bnWeight);
        EditText bnRpeID = findViewById(R.id.bnRpe);

        EditText dlRepID = findViewById(R.id.dlRep);
        EditText dlWeightID = findViewById(R.id.dlWeight);
        EditText dlRpeID = findViewById(R.id.dlRpe);

        final Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),"Hello toast",Toast.LENGTH_SHORT).show();

//                int sqRepInput = Integer.parseInt(sqRepID.getText().toString());
//                int sqWeightInput = Integer.parseInt(sqRepID.getText().toString());
//                int sqRpeInput = Integer.parseInt(sqRepID.getText().toString());
//                double sq1RM = calculate1RM(sqRepInput,sqWeightInput, sqRpeInput);


//                Intent resultActivity = new Intent(MainActivity.this, ResultActivity.class);
//                resultActivity.putExtra("Squat one rep max", sq1RM);
//                startActivity(resultActivity);

                Intent  i = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(i);









            }
        });

    }


    public double calculate1RM(int rep, int weight, int rpe)
    {
        return (weight*((10-(rpe+1))+rep)*0.03)+weight;
    }
}
