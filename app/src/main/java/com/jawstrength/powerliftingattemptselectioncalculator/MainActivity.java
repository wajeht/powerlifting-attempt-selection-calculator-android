package com.jawstrength.powerliftingattemptselectioncalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String MAX_SQUAT = "sq";
    public static final String MAX_BENCH = "bn";
    public static final String MAX_DEADLIFT = "dl";

    public static final String ATTEMPTS_SQUAT_1 = "squat 1st attempt";
    public static final String ATTEMPTS_SQUAT_2 = "squat 2nd attempt";
    public static final String ATTEMPTS_SQUAT_3 = "squat 3rd attempts";

    public static final String ATTEMPTS_BENCH_1 = "bench 1st attempt";
    public static final String ATTEMPTS_BENCH_2 = "bench 2nd attempt";
    public static final String ATTEMPTS_BENCH_3 = "bench 3rd attempts";

    public static final String ATTEMPTS_DEADLIFT_1 = "deadlift 1st attempt";
    public static final String ATTEMPTS_DEADLIFT_2 = "deadlift 2nd attempt";
    public static final String ATTEMPTS_DEADLIFT_3 = "deadlift 3rd attempts";

    public static final String WILKS = "body weight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText bodyWeightID = findViewById(R.id.bodyweight);

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


        // error handling if use dind't input all fields
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sqRepID.getText().toString().isEmpty() ||
                        sqWeightID.getText().toString().isEmpty() ||
                        sqRpeID.getText().toString().isEmpty() ||

                        bnRepID.getText().toString().isEmpty() ||
                        bnWeightID.getText().toString().isEmpty() ||
                        bnRpeID.getText().toString().isEmpty() ||

                        bodyWeightID.getText().toString().isEmpty() ||

                        dlRepID.getText().toString().isEmpty() ||
                        dlWeightID.getText().toString().isEmpty() ||
                        dlRpeID.getText().toString().isEmpty())
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setMessage("Please provide all input fields!");
                    alertDialog.setCancelable(false);
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                    TextView messageText = (TextView)alertDialog.findViewById(android.R.id.message);
                    messageText.setGravity(Gravity.CENTER);

                    Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();

                    //Changing the weight to negative pushes it to the left.
                    layoutParams.weight = 14;
                    btnPositive.setLayoutParams(layoutParams);

                } else {
                    // assign id, calculate one max, and attempts
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

                    int bodyweight = Integer.parseInt(bodyWeightID.getText().toString());

                    double wilks = wilks(bodyweight);

                    // passing 1rm to resultActivity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putDouble(MainActivity.WILKS, wilks);

                    bundle.putInt(MainActivity.MAX_SQUAT, sq1RM);
                    bundle.putInt(MainActivity.MAX_BENCH, bn1RM);
                    bundle.putInt(MainActivity.MAX_DEADLIFT, dl1RM);

                    bundle.putInt(MainActivity.ATTEMPTS_SQUAT_1, sq1st);
                    bundle.putInt(MainActivity.ATTEMPTS_SQUAT_2, sq2nd);
                    bundle.putInt(MainActivity.ATTEMPTS_SQUAT_3, sq3rd);

                    bundle.putInt(MainActivity.ATTEMPTS_BENCH_1, bn1st);
                    bundle.putInt(MainActivity.ATTEMPTS_BENCH_2, bn2nd);
                    bundle.putInt(MainActivity.ATTEMPTS_BENCH_3, bn3rd);

                    bundle.putInt(MainActivity.ATTEMPTS_DEADLIFT_1, dl1st);
                    bundle.putInt(MainActivity.ATTEMPTS_DEADLIFT_2, dl2nd);
                    bundle.putInt(MainActivity.ATTEMPTS_DEADLIFT_3, dl3rd);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    public void openAbout(View view)
    {
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        alertDialog.setMessage("This app is free forever, but it still cost effort to maintain it on AppStore. \n \n Want to buy a cup of coffee?");
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes!!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.parse("http://paypal.me/akonyein"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.show();
        TextView messageText = (TextView)alertDialog.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);

        Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();

        //Changing the weight to negative pushes it to the left.
        layoutParams.weight = 1.5f;
        btnPositive.setLayoutParams(layoutParams);

    }

    public int firstAttempt(int oneRepMax)
    {
        return (int)(oneRepMax * 0.91);
    }

    public int secondAttempt(int oneRepMax)
    {
        return (int)(oneRepMax * 0.96);
    }

    public int thirdAttempt(int oneRepMax)
    {
        return oneRepMax;
    }

    public int oneRepMax(int rep, int weight, int rpe)
    {
        return (int)((weight*((10-(rpe+1))+rep)*0.03)+weight);
    }

    public double wilks(int bodyweight)
    {
        double bw = (bodyweight / 2.2);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        RadioButton radioButton_male = findViewById(R.id.RadioButton_Male);
        RadioButton radioButton_female = findViewById(R.id.RadioButton_Femal);

        double result = 0;

        if (radioButton_male.isChecked())
        {
            result = 500/
                (
                    ((-216.0475144))+
                    ((16.2606339)*(bw))-
                    ((0.002388645)*(Math.pow(bw,2)))-
                    ((0.00113732)*(Math.pow(bw,3)))+
                    ((0.00000701863)*(Math.pow(bw,4)))-
                    ((0.00000001291)*(Math.pow(bw,5)))
                );

        }
        else if (radioButton_female.isChecked())
        {
            result = 500/
                (
                    ((594.31747775582))-
                    ((27.23842536447)*(bw))+
                    ((0.82112226871)*(Math.pow(bw,2)))-
                    ((0.00930733913)*(Math.pow(bw,3)))+
                    ((0.00004731582)*(Math.pow(bw,4)))-
                    ((0.00000009054)*(Math.pow(bw,5)))
                );
        }
        return result;
    }
}
