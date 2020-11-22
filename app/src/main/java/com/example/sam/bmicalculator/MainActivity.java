package com.example.sam.bmicalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context ctx = MainActivity.this;

        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final TextView result = findViewById(R.id.result);

        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sHeight = height.getText().toString();
                double dHeight = Double.parseDouble(sHeight) / 100;

                String sWeight = weight.getText().toString();
                double dWeight = Double.parseDouble(sWeight);

                double bmi = dWeight / (dHeight * dHeight);
                Toast.makeText(ctx, "BMI = " + bmi, Toast.LENGTH_LONG).show();

                String res;

                if (bmi >= 40) {
                    res = ("BMI = " + bmi + ", 고도비만");

                } else if (bmi >= 35) {
                    res = ("BMI = " + bmi + ", 중등도 비만 (2단계 비만)");

                } else if (bmi >= 30) {
                    res = ("BMI = " + bmi + ", 경도 비만 (1단계 비만)");

                } else if (bmi >= 25) {
                    res = ("BMI = " + bmi + ", 과체중");

                } else if (bmi >= 18.5) {
                    res = ("BMI = " + bmi + ", 정상");

                } else {
                    res = ("BMI = " + bmi + ", 저체중");

                }

                result.setText(res);

            }

        });

    }

}
