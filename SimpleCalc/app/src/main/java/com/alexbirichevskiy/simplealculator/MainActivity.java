package com.alexbirichevskiy.simplealculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvInput;
    private TextView tvOutput;
//    private StringBuilder displayInput;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonPoint;
    private Button buttonPlus;
    private Button buttonDiv;
    private Button buttonMin;
    private Button buttonMult;
    private Button buttonEqually;
    private Button buttonC;
    private Button buttonDel;
    private Calculations calc;
    private static final String CALC_PARAM = "EXTRA_CALC";

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
        calc = new Calculations();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        calc = (Calculations) savedInstanceState.getSerializable(CALC_PARAM);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable(CALC_PARAM, calc);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
            tvInput.setText(calc.getDisplayInput().append(button.getText()));
        }
    }

    public void inputArithmSym (View v, Button button) {
        if (v.getId() == button.getId()) {
            if (!tvOutput.getText().toString().equals("")){
                calc.getDisplayInput().delete(0,calc.getDisplayInput().length()).append(tvOutput.getText());
                tvInput.setText(calc.getDisplayInput().append(button.getText()));
                tvOutput.setText("");
            }
            else {
                tvInput.setText(calc.getDisplayInput().append(button.getText()));
            }
        }
    }

    public void calculate (View v, Button button) {
        if (v.getId() == button.getId()) {
            calc.parseInput(calc.getDisplayInput());
            tvOutput.setText(calc.getSum());
            calc.setSum(0.0);
        }
    }

    public void deleteOneChar (View v, Button button){
        if (v.getId() == button.getId()) {
            if (calc.getDisplayInput().length() != 0) {
                calc.getDisplayInput().deleteCharAt(calc.getDisplayInput().length() - 1);
                tvInput.setText(calc.getDisplayInput());
                tvOutput.setText("");
            }
        }
    }

    public void deleteAll (View v, Button button){
        if (v.getId() == button.getId()) {
            calc.getDisplayInput().delete(0,calc.getDisplayInput().length());
            calc.setSum(0.0);
            tvInput.setText(calc.getDisplayInput());
            tvOutput.setText("");
        }
    }
}