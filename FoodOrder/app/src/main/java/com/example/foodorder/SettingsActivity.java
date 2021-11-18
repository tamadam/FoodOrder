package com.example.foodorder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    TextView addMoney;
    TextView finishButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        addMoney = findViewById(R.id.addMoney);
        finishButton  = findViewById(R.id.finishButton);



        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor mEditor = MainActivity.settings.edit();
                mEditor.putInt(MainActivity.STATE_KEY_PASSWORD, MainActivity.currentMoney += 100).commit();


            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
