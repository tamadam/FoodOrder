package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MyReAdapter.onNoteListener {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    public static int currentMoney = 2000;
    public final static String STATE_KEY_PASSWORD = "com.example.screenlocker.password";
    public final static String SAVE = "text.android.app";



    TextView motivateTextView;
    TextView quoteTextView;
    EditText findYourFood;
    LinearLayout homeButton;
    LinearLayout profileButton;
    LinearLayout questionButton;
    LinearLayout settingsButton;
    ImageView imageViewProfile;
    FloatingActionButton goToBasketButton;
    TextView currentBalance;
    public static SharedPreferences settings;

    List<String> quotes = new ArrayList<>(Arrays.asList("Put Money Down","Start Fresh","Plan Ahead","Set Realistic Goals","Reward Your Success"));
    boolean first = true;
    Random rand = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        motivateTextView = findViewById(R.id.motivateTextView);
        quoteTextView = findViewById(R.id.quoteTextView);
        findYourFood = findViewById(R.id.findYourFood);
        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        questionButton = findViewById(R.id.questionButton);
        settingsButton = findViewById(R.id.settingsButton);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        recyclerView = findViewById(R.id.recyclerView);
        goToBasketButton = findViewById(R.id.goToBasketButton);
        currentBalance = findViewById(R.id.currentBalance);
/*
        if (savedInstanceState!=null){
            currentMoney = Integer.parseInt(savedInstanceState.getString(STATE_KEY_PASSWORD));
        }
        else{
            //currentMoney = 2000;
        }
        */


        settings = getSharedPreferences(SAVE, 0);
        currentMoney = settings.getInt(STATE_KEY_PASSWORD, 2000);





        currentBalance.setText(currentMoney + " HUF");


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        List<String> listItems = new ArrayList<>();
        listItems.add("Fruits");
        listItems.add("Vegetables");
        listItems.add("Drinks");
        listItems.add("Vitamins");


        recyclerView.setAdapter(new MyReAdapter(listItems,this));


        findYourFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FilterActivity.class);
                startActivity(intent);
            }
        });

        goToBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BasketActivity.class);
                startActivity(intent);
            }
        });


        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
/*
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });

 */
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        motivateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first){
                    quoteTextView.setText("Start Fresh");
                    motivateTextView.setText("Give me another!");
                    first = false;
                }
                else {
                    int randint = rand.nextInt(quotes.size());
                    quoteTextView.setText(quotes.get(randint));
                }

            }
        });

        imageViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        //recyclerViewCategory();

    }

    @Override
    public void onResume() {
        super.onResume();
        currentBalance.setText(currentMoney + " HUF");
        settings = getSharedPreferences(SAVE, 0);
        currentMoney = settings.getInt(STATE_KEY_PASSWORD, 2000);

    }

    @Override
    public void onNoteClick(int position) {
        Log.d("myapp",""+position);

        if (position == 0){
            Intent intent = new Intent(this, Fruits.class);
            Log.d("myapp","other "+position);
            startActivity(intent);
        }
        if (position == 1){
            Intent intent = new Intent(this, Vegetables.class);
            Log.d("myapp","other "+position);
            startActivity(intent);
        }
        if (position == 2){
            Intent intent = new Intent(this, Drinks.class);
            Log.d("myapp","other "+position);
            startActivity(intent);
        }
        if (position == 3){
            Intent intent = new Intent(this, Vitamins.class);
            Log.d("myapp","other "+position);
            startActivity(intent);
        }


    }





    /*

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryHelper> categoryList = new ArrayList<>();
        categoryList.add(new CategoryHelper("Fruits", "melon"));
        categoryList.add(new CategoryHelper("Vegetables", "repa"));
        categoryList.add(new CategoryHelper("Drinks", "drink"));
        categoryList.add(new CategoryHelper("Vitamins", "vitaminok"));


        adapter = new FoodCategories(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }

     */

}