package com.example.foodorder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    ImageView addMoney;
    ImageView minusMoney;
    TextView finishButton;
    EditText moneyEditText;
    TextView newBalance;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        addMoney = findViewById(R.id.addMoney);
        minusMoney = findViewById(R.id.minusMoney);
        finishButton  = findViewById(R.id.finishButton);
        moneyEditText = findViewById(R.id.moneyEditText);
        moneyEditText.setText("0");
        newBalance = findViewById(R.id.newBalance);
        newBalance.setText("New balance: " + MainActivity.currentMoney + " Ft");


        moneyEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    counter = Integer.parseInt(moneyEditText.getText().toString());
                    int value = MainActivity.currentMoney + counter;
                    newBalance.setText("New balance: " + value + " Ft");
                }
            }
        });



        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SharedPreferences.Editor mEditor = MainActivity.settings.edit();
                //mEditor.putInt(MainActivity.STATE_KEY_PASSWORD, MainActivity.currentMoney += 100).commit();
                if (Integer.parseInt(moneyEditText.getText().toString()) > 0){
                    counter = Integer.parseInt(moneyEditText.getText().toString());
                }

                counter += 100;

                moneyEditText.setText("" + counter);

                int value = MainActivity.currentMoney + counter;
                newBalance.setText("New balance: " + value + " Ft");

            }
        });

        minusMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences.Editor mEditor = MainActivity.settings.edit();
                //mEditor.putInt(MainActivity.STATE_KEY_PASSWORD, MainActivity.currentMoney -= 100).commit();

                if (Integer.parseInt(moneyEditText.getText().toString()) > 0){
                    counter = Integer.parseInt(moneyEditText.getText().toString());
                }

                counter -= 100;
                if (counter <= 0) {
                    counter = 0;
                }

                moneyEditText.setText("" + counter);

                int value = MainActivity.currentMoney + counter;
                newBalance.setText("New balance: " + value + " Ft");


            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam = Integer.parseInt(moneyEditText.getText().toString());
                SharedPreferences.Editor mEditor = MainActivity.settings.edit();
                mEditor.putInt(MainActivity.STATE_KEY_PASSWORD, MainActivity.currentMoney += szam).commit();

                if (szam == 0){
                    Toast.makeText(SettingsActivity.this,"No money added", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(SettingsActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }


}
