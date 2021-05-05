package com.alexbirichevskiy.simplealculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvInput;
    TextView tvOutput;
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
    Button buttonPlus;
    Button buttonDiv;
    Button buttonMin;
    Button buttonMult;
    Button buttonEqually;
    Button buttonC;
    Button buttonDel;
    Calculations calc;

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
        buttonPlus = findViewById(R.id.button_plus);
        buttonMin = findViewById(R.id.button_min);
        buttonDiv = findViewById(R.id.button_div);
        buttonMult = findViewById(R.id.button_multiply);
        buttonEqually = findViewById(R.id.button_equally);
        buttonC = findViewById(R.id.button_c);
        buttonDel = findViewById(R.id.button_del);

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
        buttonPlus.setOnClickListener(this);
        buttonMin.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMult.setOnClickListener(this);
        buttonEqually.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonDel.setOnClickListener(this);

        tvInput = findViewById(R.id.editTextInput);
        tvOutput = findViewById(R.id.editTextOutput);
        tvOutput.setText("");
        displayInput = new StringBuilder();
        calc = new Calculations();
    }

    @Override
    public void onClick(View v) {
        inputSym(v, button0);
        inputSym(v, button1);
        inputSym(v, button2);
        inputSym(v, button3);
        inputSym(v, button4);
        inputSym(v, button5);
        inputSym(v, button6);
        inputSym(v, button7);
        inputSym(v, button8);
        inputSym(v, button9);
        inputSym(v, buttonPoint);
        inputSym(v, buttonEqually);
        inputArithmSym(v, buttonPlus);
        inputArithmSym(v, buttonMin);
        inputArithmSym(v, buttonMult);
        inputArithmSym(v, buttonDiv);
        calculate(v, buttonEqually);
        deleteAll(v, buttonC);
        deleteOneChar(v, buttonDel);
    }

    public void inputSym (View v, Button button) {
        if (v.getId() == button.getId()) {
            tvInput.setText(displayInput.append(button.getText()));
        }
    }

    public void inputArithmSym (View v, Button button) {
        if (v.getId() == button.getId()) {
            if (!tvOutput.getText().toString().equals("")){
                displayInput.delete(0,displayInput.length()).append(tvOutput.getText());
                tvInput.setText(displayInput.append(button.getText()));
            }
            else {
                tvInput.setText(displayInput.append(button.getText()));
            }
        }
    }

    public void calculate (View v, Button button) {
        if (v.getId() == button.getId()) {
            calc.parseInput(displayInput);
            tvOutput.setText(calc.getSum());
            calc.setSum(0.0);
        }
    }

    public void deleteOneChar (View v, Button button){
        if (v.getId() == button.getId()) {
            if (displayInput.length() != 0) {
                displayInput.deleteCharAt(displayInput.length() - 1);
                tvInput.setText(displayInput);
            }
        }
    }

    public void deleteAll (View v, Button button){
        if (v.getId() == button.getId()) {
            displayInput.delete(0,displayInput.length());
            calc.setSum(0.0);
            tvInput.setText(displayInput);
            tvOutput.setText("");
        }
    }
}