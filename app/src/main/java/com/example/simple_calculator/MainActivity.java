package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btnDot, btnClear, btnDiv, btnMult, btnPlus, btnMinus, btnCalc;

    Button[] digits = new Button[10];

    TextView screen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < digits.length; i++){
            int id = getResources().getIdentifier("btn" + i, "id", getPackageName());
            digits[i] = (Button) findViewById(id);
        }

        btnDot  = (Button) findViewById(R.id.btnDot);
        btnDiv  = (Button) findViewById(R.id.btnDiv);
        btnMult  = (Button) findViewById(R.id.btnMult);
        btnPlus  = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnCalc  = (Button) findViewById(R.id.btnCalc);
        btnClear  = (Button) findViewById(R.id.btnClear);

        screen = (TextView) findViewById(R.id.screen);

        int counter = 0;
        for (Button digit: digits) {
            final int finalCounter = counter;
            digit.setOnClickListener((v)->{screen.setText(screen.getText()+ "" + finalCounter);});
            counter++;
        }

        btnDot.setOnClickListener(
                (v)->{screen.setText(screen.getText()+ ".");});

        btnDiv.setOnClickListener(
                (v)->{

                });

        btnMult.setOnClickListener(
                (v)->{});

        btnPlus.setOnClickListener((v)->{});

        btnMinus.setOnClickListener(
                (v)->{});

        btnCalc.setOnClickListener(
                (v)->{});

        btnClear.setOnClickListener(
                (v)->{screen.setText("");});
    }
}