package com.alexbirichevskiy.simplealculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


public class SettingActivity extends AppCompatActivity {
    public static final String appTheme = "APP_THEME";
    public static final String nameSharedPreference = "THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.ActivityBackgroundLight));
        setContentView(R.layout.activity_setting);

        RadioButton radioButtonLight = findViewById(R.id.lightThemeButton);
        RadioButton radioButtonDark = findViewById(R.id.DarkThemeButton);

        radioButtonDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(R.style.ActivityBackgroundDark);
                recreate();
            }
        });

        radioButtonLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(R.style.ActivityBackgroundLight);
                recreate();
            }
        });
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
}