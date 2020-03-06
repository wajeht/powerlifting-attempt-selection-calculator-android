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

        TextView result = findViewById(R.id.txtResult);


        int sq1RMResult = getIntent().getExtras().getInt("Squat 1RM");
        result.setText(Integer.toString(sq1RMResult));


        Log.d("TAG", (String) result.getText());


        //Toast.makeText(getApplicationContext(),"Hello toast", Toast.LENGTH_LONG).show();







    }
}
