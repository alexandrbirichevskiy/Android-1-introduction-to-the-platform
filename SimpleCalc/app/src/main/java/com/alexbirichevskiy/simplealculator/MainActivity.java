package com.alexbirichevskiy.simplealculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvInput;
    private TextView tvOutput;
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
    private Button buttonMinus;
    private Button buttonMult;
    private Button buttonEqually;
    private Button buttonC;
    private Button buttonDel;
    private Calculations calc;
    private final String textNull = "";
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    public static String YOUR_THEME = "YOUR_THEME";
    public static final String appTheme = "APP_THEME";
    public static final String nameSharedPreference = "THEME";
    private MyTheme myTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.ActivityBackgroundLight));
        setContentView(R.layout.activity_main);

        myTheme = new MyTheme();
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
        buttonMinus = findViewById(R.id.button_minus);
        buttonDiv = findViewById(R.id.button_div);
        buttonMult = findViewById(R.id.button_multiply);
        buttonEqually = findViewById(R.id.button_equally);
        buttonC = findViewById(R.id.button_c);
        buttonDel = findViewById(R.id.button_del);
        tvInput = findViewById(R.id.editTextInput);
        tvOutput = findViewById(R.id.editTextOutput);

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
        buttonMinus.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMult.setOnClickListener(this);
        buttonEqually.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonDel.setOnClickListener(this);

        tvOutput.setText(textNull);
        calc = new Calculations(buttonPlus, buttonDiv, buttonMinus, buttonMult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.buttonSetting){
            Intent runSettings = new Intent(MainActivity.this, SettingActivity.class);
            startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);        }
        return true;
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
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
        inputArithmSym(v, buttonMinus);
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
            if (!tvOutput.getText().toString().equals(textNull)){
                calc.getDisplayInput().delete(0,calc.getDisplayInput().length())
                                                    .append(tvOutput.getText());
                tvInput.setText(calc.getDisplayInput().append(button.getText()));
                tvOutput.setText(textNull);
            }
            else {
                tvInput.setText(calc.getDisplayInput().append(button.getText()));
            }
        }
    }

    public void calculate (View v, Button button) {
        if (v.getId() == button.getId()) {
            calc.dataProcessing(calc.getDisplayInput());
            tvOutput.setText(calc.getSum());
            calc.setSum(0.0);
        }
    }

    public void deleteOneChar (View v, Button button){
        if (v.getId() == button.getId()) {
            if (calc.getDisplayInput().length() != 0) {
                calc.getDisplayInput().deleteCharAt(calc.getDisplayInput().length() - 1);
                tvInput.setText(calc.getDisplayInput());
                tvOutput.setText(textNull);
            }
        }
    }

    public void deleteAll (View v, Button button){
        if (v.getId() == button.getId()) {
            calc.getDisplayInput().delete(0,calc.getDisplayInput().length());
            calc.setSum(0.0);
            tvInput.setText(calc.getDisplayInput());
            tvOutput.setText(textNull);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK){
            myTheme = data.getParcelableExtra(YOUR_THEME);
            changeAppTheme(myTheme);
        }
    }

    private void changeAppTheme(MyTheme myTheme) {
        int newTheme = Integer.parseInt(String.valueOf(myTheme));
        setAppTheme(newTheme);
    }

    private void setAppTheme(int code){
        SharedPreferences sharedPreferences = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        sharedPreferences.edit()
                .putInt(appTheme, code)
                .apply();
    }

    private int getAppTheme(int code){
        return getCodeStyle(code);
    }

    private int getCodeStyle (int codeStyle){
        SharedPreferences sharedPreferences = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        return sharedPreferences.getInt(appTheme, codeStyle);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}