package com.alexbirichevskiy.simplealculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    StringBuilder displayInput;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPoint = findViewById(R.id.button_point);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);

        tv = findViewById(R.id.editText);
        displayInput = new StringBuilder();
    }

    @Override
    public void onClick(View v) {
        inputDig(v, button0);
        inputDig(v, button1);
        inputDig(v, button2);
        inputDig(v, button3);
        inputDig(v, button4);
        inputDig(v, button5);
        inputDig(v, button6);
        inputDig(v, button7);
        inputDig(v, button8);
        inputDig(v, button9);
        inputDig(v, buttonPoint);
    }

    public void inputDig (View v, Button button) {
        if (v.getId() == button.getId()) {
            tv.setText(displayInput.append(button.getText()));
        }
    }
}