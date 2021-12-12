package com.example.foodorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foodorder.Models.FruitsModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class StartActivity extends AppCompatActivity {

    private ConstraintLayout startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startButton = findViewById(R.id.startButton);

        OrderFood.allItems.add(new FruitsModel(R.drawable.apple, "Apple","300","Finom", "1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.banana, "Banana","250","Banán sárga","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.melon, "Melon","250","Sárgadinnye","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.watermelon, "Watermelon","400","Görögdinnye","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.orange, "Orange","119","Narancs","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.ananasz, "Pineapple","600","Ananasz","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.water, "Water","120","Finom", "1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.greentea, "Green tea","399","Banán sárga","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.lemonwater, "Lemon water","499","Sárgadinnye","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.orangejuice, "Orange juice","200","Görögdinnye","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.redwine, "Red wine","550","Narancs","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.hotchoc, "Hot chocolate","250","Ananasz","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.repapicture, "Carrot","150","Sárga nagyon", "1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.retek, "Radish","200","Finike","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.hagyma, "Onion","300","Sárgadinnye","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.kaposzta, "Cabbage","399","Görögdinnye","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.burgonya, "Potato","120","Narancs","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.uborka, "Cucumber","110","zöld","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.vitaminc, "Vitamin C","1100","Finom", "1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.vitamind, "Vitamin D","1500","Banán sárga","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.multi, "Multivitamin","3000","Sárgadinnye","1"));
        OrderFood.allItems.add(new FruitsModel(R.drawable.magnesium, "Magnesium","2500","Sárgadinnye","1"));

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);

        if(googleSignInAccount != null){
            startActivity(new Intent(StartActivity.this, MainActivity.class));
            finish();
        }

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                handleSignInTask(task);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = googleSignInClient.getSignInIntent();

                activityResultLauncher.launch(signInIntent);
            }
        });
    }
    /*
    public void onClick(View v) {

    }

     */

    private void handleSignInTask(Task<GoogleSignInAccount> task){

        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);

            final String getFullname = account.getDisplayName();
            final String getEmail = account.getEmail();
            final Uri getPhotoUrl = account.getPhotoUrl();

            startActivity(new Intent(StartActivity.this, MainActivity.class));
            finish();

        } catch (ApiException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

}
