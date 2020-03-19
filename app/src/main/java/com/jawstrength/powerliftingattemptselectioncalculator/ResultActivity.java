package com.jawstrength.powerliftingattemptselectioncalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class ResultActivity extends AppCompatActivity {

    private static DecimalFormat df = new DecimalFormat("#.#");

    public ArrayList<Integer> Total_Squat = new ArrayList<>(9);
    public ArrayList<Integer> Total_Bench = new ArrayList<>(9);
    public ArrayList<Integer> Total_Deadlift = new ArrayList<>(9);

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView sqe1RM = findViewById(R.id.txtSquat);
        TextView bne1RM = findViewById(R.id.txtBench);
        TextView dle1RM = findViewById(R.id.txtDeadlift);


        final TextView textViewWilks = findViewById(R.id.textViewWilks);


        // assign id to textviews
        // squat attempts id
        final TextView sq1Low = findViewById(R.id.sq1Low);
        final TextView sq1Normal = findViewById(R.id.sq1Normal);
        final TextView sq1High = findViewById(R.id.sq1High);

        final TextView sq2Low = findViewById(R.id.sq2Low);
        final TextView sq2Normal = findViewById(R.id.sq2Normal);
        final TextView sq2High = findViewById(R.id.sq2High);

        final TextView sq3Low = findViewById(R.id.sq3Low);
        final TextView sq3Normal = findViewById(R.id.sq3Normal);
        final TextView sq3High = findViewById(R.id.sq3High);

        // bench attempts id
        final TextView bn1Low = findViewById(R.id.bn1Low);
        final TextView bn1Normal = findViewById(R.id.bn1Normal);
        final TextView bn1High = findViewById(R.id.bn1High);

        final TextView bn2Low = findViewById(R.id.bn2Low);
        final TextView bn2Normal = findViewById(R.id.bn2Normal);
        final TextView bn2High = findViewById(R.id.bn2High);

        final TextView bn3Low = findViewById(R.id.bn3Low);
        final TextView bn3Normal = findViewById(R.id.bn3Normal);
        final TextView bn3High = findViewById(R.id.bn3High);

        // deadlift attempts id
        final TextView dl1Low = findViewById(R.id.dl1Low);
        final TextView dl1Normal = findViewById(R.id.dl1Normal);
        final TextView dl1High = findViewById(R.id.dl1High);

        final TextView dl2Low = findViewById(R.id.dl2Low);
        final TextView dl2Normal = findViewById(R.id.dl2Normal);
        final TextView dl2High = findViewById(R.id.dl2High);

        final TextView dl3Low = findViewById(R.id.dl3Low);
        final TextView dl3Normal = findViewById(R.id.dl3Normal);
        final TextView dl3High = findViewById(R.id.dl3High);

        final TextView textViewTotal = findViewById(R.id.textViewTotal);

        final double wilks = getIntent().getExtras().getDouble(MainActivity.WILKS);
        textViewWilks.setText(String.valueOf((int)(wilks * (showTotal() / 2.2))));

        Log.d(MainActivity.ATTEMPTS_BENCH_1, String.valueOf(wilks));


        // get user data from mainActivity
        final int sq1Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_SQUAT_1);
        final int sq2Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_SQUAT_2);
        final int sq3Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_SQUAT_3);

        final int bn1Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_BENCH_1);
        final int bn2Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_BENCH_2);
        final int bn3Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_BENCH_3);

        final int dl1Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_DEADLIFT_1);
        final int dl2Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_DEADLIFT_2);
        final int dl3Attempt = getIntent().getExtras().getInt(MainActivity.ATTEMPTS_DEADLIFT_3);

        // e1rm
        int squatMAX = getIntent().getExtras().getInt(MainActivity.MAX_SQUAT);
        int benchMAX = getIntent().getExtras().getInt(MainActivity.MAX_BENCH);
        int deadliftMAX = getIntent().getExtras().getInt(MainActivity.MAX_DEADLIFT);

        sqe1RM.setText("SQUAT e1RM: " + String.valueOf(squatMAX));
        bne1RM.setText("BENCH e1RM: " + String.valueOf(benchMAX));
        dle1RM.setText("DEADLIFT e1RM: " + String.valueOf(deadliftMAX));


        // print out squat attempts
        sq1Low.setText(String.valueOf((int) (sq1Attempt - (sq1Attempt * 0.01))));
        sq1Normal.setText(String.valueOf(sq1Attempt));
        sq1High.setText(String.valueOf((int) (sq1Attempt + (sq1Attempt * 0.02))));

        sq2Low.setText(String.valueOf((int) (sq2Attempt - (sq2Attempt * 0.01))));
        sq2Normal.setText(String.valueOf(sq2Attempt));
        sq2High.setText(String.valueOf((int) (sq2Attempt + (sq2Attempt * 0.02))));

        sq3Low.setText(String.valueOf((int) (sq3Attempt - (sq3Attempt * 0.01))));
        sq3Normal.setText(String.valueOf(sq3Attempt));
        sq3High.setText(String.valueOf((int) (sq3Attempt + (sq3Attempt * 0.02))));

        // print out bench attempts
        bn1Low.setText(String.valueOf((int) (bn1Attempt - (bn1Attempt * 0.01))));
        bn1Normal.setText(String.valueOf(bn1Attempt));
        bn1High.setText(String.valueOf((int) (bn1Attempt + (bn1Attempt * 0.02))));

        bn2Low.setText(String.valueOf((int) (bn2Attempt - (bn2Attempt * 0.01))));
        bn2Normal.setText(String.valueOf(bn2Attempt));
        bn2High.setText(String.valueOf((int) (bn2Attempt + (bn2Attempt * 0.02))));

        bn3Low.setText(String.valueOf((int) (bn3Attempt - (bn3Attempt * 0.01))));
        bn3Normal.setText(String.valueOf(bn3Attempt));
        bn3High.setText(String.valueOf((int) (bn3Attempt + (bn3Attempt * 0.02))));

        // print out deadlift attempts
        dl1Low.setText(String.valueOf((int) (dl1Attempt - (dl1Attempt * 0.01))));
        dl1Normal.setText(String.valueOf(dl1Attempt));
        dl1High.setText(String.valueOf((int) (dl1Attempt + (dl1Attempt * 0.02))));

        dl2Low.setText(String.valueOf((int) (dl2Attempt - (dl2Attempt * 0.01))));
        dl2Normal.setText(String.valueOf(dl2Attempt));
        dl2High.setText(String.valueOf((int) (dl2Attempt + (dl2Attempt * 0.02))));

        dl3Low.setText(String.valueOf((int) (dl3Attempt - (dl3Attempt * 0.01))));
        dl3Normal.setText(String.valueOf(dl3Attempt));
        dl3High.setText(String.valueOf((int) (dl3Attempt + (dl3Attempt * 0.02))));

        textViewTotal.setText(String.valueOf(showTotal()));

// squat 1st attemtp
        sq1Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq1Attempt - (sq1Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq1Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq1Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq1Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    Total_Squat.remove((Integer) ((int) (sq1Attempt - (sq1Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq1Low.setBackground(null);
                    sq1Low.setBackgroundTintList(null);
                    sq1Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        sq1Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((Integer) (sq1Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));


                    sq1Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq1Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq1Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    Total_Squat.remove((Integer) (sq1Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq1Normal.setBackground(null);
                    sq1Normal.setBackgroundTintList(null);
                    sq1Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        sq1High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq1Attempt + (sq1Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq1High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq1High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq1High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    Total_Squat.remove((Integer) ((int) (sq1Attempt + (sq1Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq1High.setBackground(null);
                    sq1High.setBackgroundTintList(null);
                    sq1High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        //sq 2nd attempt
        sq2Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq2Attempt - (sq2Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));


                    sq2Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq2Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq2Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    Total_Squat.remove((Integer) ((int) (sq2Attempt - (sq2Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq2Low.setBackground(null);
                    sq2Low.setBackgroundTintList(null);
                    sq2Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        sq2Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq2Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));



                    textViewWilks.setText(String.valueOf(df.format((wilks * (showTotal() / 2.2)))));

                    sq2Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq2Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq2Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    Total_Squat.remove((Integer) ((int) (sq2Attempt)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq2Normal.setBackground(null);
                    sq2Normal.setBackgroundTintList(null);
                    sq2Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        sq2High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq2Attempt + (sq2Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));



                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq2High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq2High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq2High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {




                    Total_Squat.remove((Integer) ((int) (sq2Attempt + (sq2Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq2High.setBackground(null);
                    sq2High.setBackgroundTintList(null);
                    sq2High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });


//sq 2nd attempt
        sq3Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq3Attempt - (sq3Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));


                    sq3Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq3Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq3Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {



                    Total_Squat.remove((Integer) ((int) (sq3Attempt - (sq3Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq3Low.setBackground(null);
                    sq3Low.setBackgroundTintList(null);
                    sq3Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        sq3Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq3Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));


                    sq3Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq3Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq3Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {



                    Total_Squat.remove((Integer) ((int) (sq3Attempt)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq3Normal.setBackground(null);
                    sq3Normal.setBackgroundTintList(null);
                    sq3Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        sq3High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Squat.add((int) (sq3Attempt + (sq3Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));


                    sq3High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    sq3High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    sq3High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    Total_Squat.remove((Integer) ((int) (sq3Attempt + (sq3Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    sq3High.setBackground(null);
                    sq3High.setBackgroundTintList(null);
                    sq3High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });



// bnuat 1st attemtp
        bn1Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn1Attempt - (bn1Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn1Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn1Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn1Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    Total_Bench.remove((Integer) ((int) (bn1Attempt - (bn1Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn1Low.setBackground(null);
                    bn1Low.setBackgroundTintList(null);
                    bn1Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        bn1Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((Integer) (bn1Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn1Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn1Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn1Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    Total_Bench.remove((Integer) (bn1Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn1Normal.setBackground(null);
                    bn1Normal.setBackgroundTintList(null);
                    bn1Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        bn1High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn1Attempt + (bn1Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn1High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn1High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn1High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    Total_Bench.remove((Integer) ((int) (bn1Attempt + (bn1Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn1High.setBackground(null);
                    bn1High.setBackgroundTintList(null);
                    bn1High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        //bn 2nd attempt
        bn2Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn2Attempt - (bn2Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn2Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn2Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn2Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    Total_Bench.remove((Integer) ((int) (bn2Attempt - (bn2Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn2Low.setBackground(null);
                    bn2Low.setBackgroundTintList(null);
                    bn2Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        bn2Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn2Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn2Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn2Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn2Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    Total_Bench.remove((Integer) ((int) (bn2Attempt)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn2Normal.setBackground(null);
                    bn2Normal.setBackgroundTintList(null);
                    bn2Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        bn2High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn2Attempt + (bn2Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn2High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn2High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn2High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    Total_Bench.remove((Integer) ((int) (bn2Attempt + (bn2Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn2High.setBackground(null);
                    bn2High.setBackgroundTintList(null);
                    bn2High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });


//bn 2nd attempt
        bn3Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn3Attempt - (bn3Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));


                    bn3Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn3Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn3Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    Total_Bench.remove((Integer) ((int) (bn3Attempt - (bn3Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn3Low.setBackground(null);
                    bn3Low.setBackgroundTintList(null);
                    bn3Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        bn3Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn3Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn3Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn3Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn3Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    Total_Bench.remove((Integer) ((int) (bn3Attempt)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn3Normal.setBackground(null);
                    bn3Normal.setBackgroundTintList(null);
                    bn3Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        bn3High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Bench.add((int) (bn3Attempt + (bn3Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn3High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    bn3High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    bn3High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    Total_Bench.remove((Integer) ((int) (bn3Attempt + (bn3Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    bn3High.setBackground(null);
                    bn3High.setBackgroundTintList(null);
                    bn3High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });


// dluat 1st attemtp
        dl1Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl1Attempt - (dl1Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl1Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl1Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl1Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    Total_Deadlift.remove((Integer) ((int) (dl1Attempt - (dl1Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    dl1Low.setBackground(null);
                    dl1Low.setBackgroundTintList(null);
                    dl1Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        dl1Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((Integer) (dl1Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl1Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl1Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl1Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    Total_Deadlift.remove((Integer) (dl1Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl1Normal.setBackground(null);
                    dl1Normal.setBackgroundTintList(null);
                    dl1Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        dl1High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl1Attempt + (dl1Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl1High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl1High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl1High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    Total_Deadlift.remove((Integer) ((int) (dl1Attempt + (dl1Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl1High.setBackground(null);
                    dl1High.setBackgroundTintList(null);
                    dl1High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        //dl 2nd attempt
        dl2Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl2Attempt - (dl2Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));


                    dl2Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl2Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl2Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    Total_Deadlift.remove((Integer) ((int) (dl2Attempt - (dl2Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl2Low.setBackground(null);
                    dl2Low.setBackgroundTintList(null);
                    dl2Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        dl2Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl2Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl2Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl2Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl2Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    Total_Deadlift.remove((Integer) ((int) (dl2Attempt)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl2Normal.setBackground(null);
                    dl2Normal.setBackgroundTintList(null);
                    dl2Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        dl2High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl2Attempt + (dl2Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl2High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl2High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl2High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    Total_Deadlift.remove((Integer) ((int) (dl2Attempt + (dl2Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl2High.setBackground(null);
                    dl2High.setBackgroundTintList(null);
                    dl2High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });


//dl 2nd attempt
        dl3Low.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl3Attempt - (dl3Attempt * 0.01)));
                    textViewTotal.setText(String.valueOf(showTotal()));


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl3Low.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl3Low.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl3Low.setTextColor(Color.parseColor("#FFFFFF"));
                } else {

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    Total_Deadlift.remove((Integer) ((int) (dl3Attempt - (dl3Attempt * 0.01))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    dl3Low.setBackground(null);
                    dl3Low.setBackgroundTintList(null);
                    dl3Low.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        dl3Normal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl3Attempt));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl3Normal.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl3Normal.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl3Normal.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    Total_Deadlift.remove((Integer) ((int) (dl3Attempt)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    dl3Normal.setBackground(null);
                    dl3Normal.setBackgroundTintList(null);
                    dl3Normal.setTextColor(Color.parseColor("#000000"));
                }
            }
        });

        dl3High.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                boolean isClick = !v.isSelected();
                v.setSelected(isClick);
                if (isClick) {
                    Total_Deadlift.add((int) (dl3Attempt + (dl3Attempt * 0.02)));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    dl3High.setBackground(getResources().getDrawable(R.drawable.rounded_conners));
                    dl3High.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    dl3High.setTextColor(Color.parseColor("#FFFFFF"));
                } else {


                    textViewWilks.setText(df.format((wilks * (showTotal() / 2.2))));

                    Total_Deadlift.remove((Integer) ((int) (dl3Attempt + (dl3Attempt * 0.02))));
                    textViewTotal.setText(String.valueOf(showTotal()));

                    dl3High.setBackground(null);
                    dl3High.setBackgroundTintList(null);
                    dl3High.setTextColor(Color.parseColor("#000000"));
                }
            }
        });




    }


    public int highestSquatAttempt()
    {
        int max = 0;

        if (!Total_Squat.isEmpty())
        {
            max = Collections.max(Total_Squat);
        }

        return  max;
    }


    public int highestBenchAttempt()
    {
        int max = 0;

        if (!Total_Bench.isEmpty())
        {
            max = Collections.max(Total_Bench);
        }

        return  max;
    }

    public int highestDeadliftAttempt()
    {
        int max = 0;

        if (!Total_Deadlift.isEmpty())
        {
            max = Collections.max(Total_Deadlift);
        }

        return  max;
    }



    public int showTotal()
    {
//
//        Total.add(highestBenchAttempt());
//        Total.add(highestSquatAttempt());
//        Total.add(highestDeadliftAttempt());

//        int sum = 0;
//
//            if(Total.isEmpty())
//            {
//                sum = highestSquatAttempt() + highestBenchAttempt() + highestDeadliftAttempt();
//
//            }
//            else{
//                for (int i = 0; i < Total.size(); i++)
//                {
//                    sum = Total.remove(i);
//                }
//            }

        return highestSquatAttempt() + highestBenchAttempt() + highestDeadliftAttempt();
    }
}