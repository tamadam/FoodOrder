package com.example.foodorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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

    ImageView profilePic;



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
        profilePic = findViewById(R.id.profilePic);

        personName.setFocusable(false);
        personName.setClickable(false);


        personAddress.setFocusable(false);
        personAddress.setClickable(false);

        personEmail.setFocusable(false);
        personEmail.setClickable(false);

        personPhone.setFocusable(false);
        personPhone.setClickable(false);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);


        final String getFullName = googleSignInAccount.getDisplayName();
        final String getEmail = googleSignInAccount.getEmail();
        Uri personPhoto = googleSignInAccount.getPhotoUrl();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //nameSaved = prefs.getString("name","");
        //personName.setText(nameSaved);
        personName.setText(""+ getFullName);
        addressSaved = prefs.getString("address", "");
        personAddress.setText(addressSaved);
        //emailSaved = prefs.getString("email","");
        //personEmail.setText(emailSaved);
        personEmail.setText(""+getEmail);
        phoneSaved = prefs.getString("phone","");
        personPhone.setText(phoneSaved);

        Glide.with(this).load(String.valueOf(personPhoto)).into(profilePic);
        refreshTextView();




        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editable){

                    personAddress.setFocusableInTouchMode(true);

                    personPhone.setFocusableInTouchMode(true);
                    changeButton.setText("Save");
                    editable = !editable;
                }
                else{

                    personAddress.setFocusableInTouchMode(false);

                    personPhone.setFocusableInTouchMode(false);

                    personAddress.clearFocus();

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
