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

    float val_one = 0, val_two=0,temp;
    boolean add, sub, div, mul, activeOp;


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
                (v)->{});

        btnMult.setOnClickListener(
                (v)->{});

        btnPlus.setOnClickListener((v)->{});

        btnMinus.setOnClickListener(
                (v)->{});

        btnCalc.setOnClickListener(
                (v)->{});

        btnClear.setOnClickListener(
                (v)->{});

        btnPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(val_one ==0) {
                    val_one = Float.parseFloat(screen.getText().toString());
                    add = true;
                    activeOp = true;
                    screen.setText("");
                }else {
                    temp = Float.parseFloat(screen.getText().toString());
                    val_one = val_one+temp;
                    if (activeOp == true){
                        reset();
                        add = true;
                    }
                    temp =0;
                    screen.setText("");
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(val_one ==0) {
                    val_one = Float.parseFloat(screen.getText().toString());
                    sub = true;
                    activeOp = true;
                    screen.setText("");
                }else {
                    temp = Float.parseFloat(screen.getText().toString());
                    val_one = val_one-temp;
                    if (activeOp == true){
                        reset();
                        sub = true;
                    }
                    temp =0;
                    screen.setText("");
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(val_one ==0) {
                    val_one = Float.parseFloat(screen.getText().toString());
                    div = true;
                    activeOp = true;
                    screen.setText("");
                }else {
                    temp = Float.parseFloat(screen.getText().toString());
                    val_one = val_one/temp;
                    if (activeOp == true){
                        reset();
                        div = true;
                    }
                    temp =0;
                    screen.setText("");
                }
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(val_one ==0) {
                    val_one = Float.parseFloat(screen.getText().toString());
                    mul = true;
                    activeOp = true;
                    screen.setText("");
                }else {
                    temp = Float.parseFloat(screen.getText().toString());
                    val_one = val_one*temp;
                    if (activeOp == true){
                        reset();
                        mul = true;
                    }
                    temp =0;
                    screen.setText("");
                }
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                val_two = Float.parseFloat(screen.getText().toString());
                if(add==true){
                    screen.setText(val_one+val_two+"");
                    add = false;
                    activeOp = false;
                }
                if(sub==true){
                    screen.setText(val_one-val_two+"");
                    sub = false;
                    activeOp = false;
                }
                if(div==true){
                    screen.setText(val_one/val_two+"");
                    div=false;
                    activeOp = false;
                }
                if(mul==true){
                    screen.setText(val_one*val_two+"");
                    mul=false;
                    activeOp = false;
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                val_one = 0;
                val_two = 0;
                screen.setText("");
            }
        });
    }
    private void reset(){
        add=false;
        sub = false;
        mul = false;
        div = false;
    }
}
