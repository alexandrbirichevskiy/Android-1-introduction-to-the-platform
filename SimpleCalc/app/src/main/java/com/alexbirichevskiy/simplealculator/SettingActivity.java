package com.alexbirichevskiy.simplealculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SettingActivity extends AppCompatActivity {

    private int theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(theme);
//        SettingActivity.this.setTheme(R.style.ActivityBackgroundLight);
        setContentView(R.layout.activity_setting);
        RadioButton radioButtonLight = findViewById(R.id.lightThemeButton);
        RadioButton radioButtonDark = findViewById(R.id.DarkThemeButton);
        radioButtonLight.setChecked(true);
//
        radioButtonLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = R.style.ActivityBackgroundLight;
                setTheme(theme);
                recreate();
                radioButtonLight.setChecked(true);
            }
        });

        radioButtonDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = R.style.ActivityBackgroundDark;
//                setTheme(R.style.ActivityBackgroundDark);
                setTheme(theme);
                recreate();
                radioButtonDark.setChecked(true);
            }
        });
    }
}