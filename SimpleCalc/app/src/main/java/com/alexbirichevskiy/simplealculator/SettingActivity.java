package com.alexbirichevskiy.simplealculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SettingActivity extends AppCompatActivity {
    public static final String appTheme = "APP_THEME";
    public static final String nameSharedPreference = "THEME";
    public static String YOUR_THEME = "YOUR_THEME";
    private int theme;

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
                theme = R.style.ActivityBackgroundDark;
                setAppTheme(theme);
                Intent intentResult = new Intent();
                intentResult.putExtra(YOUR_THEME, createTheme());
                setResult(RESULT_OK, intentResult);
                recreate();
            }
        });

        radioButtonLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = R.style.ActivityBackgroundLight;
                setAppTheme(theme);
                Intent intentResult = new Intent();
                intentResult.putExtra(YOUR_THEME, createTheme());
                setResult(RESULT_OK, intentResult);
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

    private MyTheme createTheme(){
        return new MyTheme(theme);
    }
}