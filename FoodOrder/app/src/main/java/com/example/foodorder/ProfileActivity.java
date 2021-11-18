package com.example.foodorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {

    EditText personName;
    EditText personAddress;
    EditText personEmail;
    EditText personPhone;
    Button changeButton;

    boolean editable = false;
    String name;
    String email;
    String phone;
    String address;

    String nameSaved;
    String addressSaved;
    String emailSaved;
    String phoneSaved;


    TextView profileName;
    TextView profileEmail;

    LinearLayout homeButton;
    LinearLayout profileButton;
    LinearLayout questionButton;
    LinearLayout settingsButton;
    FloatingActionButton goToBasketButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        personName = findViewById(R.id.personName);
        personAddress =findViewById(R.id.personAddress);
        personEmail =findViewById(R.id.personEmail);
        personPhone =findViewById(R.id.personPhone);
        changeButton = findViewById(R.id.changeButton);
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        questionButton = findViewById(R.id.questionButton);
        settingsButton = findViewById(R.id.settingsButton);
        goToBasketButton = findViewById(R.id.goToBasketButton);


        personName.setFocusable(false);
        personName.setClickable(false);


        personAddress.setFocusable(false);
        personAddress.setClickable(false);

        personEmail.setFocusable(false);
        personEmail.setClickable(false);

        personPhone.setFocusable(false);
        personPhone.setClickable(false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        nameSaved = prefs.getString("name","");
        personName.setText(nameSaved);
        addressSaved = prefs.getString("address", "");
        personAddress.setText(addressSaved);
        emailSaved = prefs.getString("email","");
        personEmail.setText(emailSaved);
        phoneSaved = prefs.getString("phone","");
        personPhone.setText(phoneSaved);

        refreshTextView();


        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editable){
                    personName.setFocusableInTouchMode(true);
                    personAddress.setFocusableInTouchMode(true);
                    personEmail.setFocusableInTouchMode(true);
                    personPhone.setFocusableInTouchMode(true);
                    changeButton.setText("Save");
                    editable = !editable;
                }
                else{
                    personName.setFocusableInTouchMode(false);
                    personAddress.setFocusableInTouchMode(false);
                    personEmail.setFocusableInTouchMode(false);
                    personPhone.setFocusableInTouchMode(false);
                    personName.clearFocus();
                    personAddress.clearFocus();
                    personEmail.clearFocus();
                    personPhone.clearFocus();
                    changeButton.setText("Change");
                    Toast.makeText(ProfileActivity.this,"Saved", Toast.LENGTH_SHORT).show();
                    editable = !editable;

                    name = personName.getText().toString();
                    address = personAddress.getText().toString();
                    email = personEmail.getText().toString();
                    phone = personPhone.getText().toString();

                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("name",name);
                    editor.putString("address",address);
                    editor.putString("email",email);
                    editor.putString("phone",phone);
                    editor.apply();

                    refreshTextView();

                }


            }
        });

        goToBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, BasketActivity.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        /*
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        
         */
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,QuestionActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void refreshTextView() {
        profileName.setText(personName.getText());
        profileEmail.setText(personEmail.getText());
    }
}
