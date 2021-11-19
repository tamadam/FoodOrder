package com.example.foodorder;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Adapters.CustomAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//MAIN ACTIVITY

public class QuestionActivity extends AppCompatActivity {

    LinearLayout homeButton;
    LinearLayout profileButton;
    LinearLayout questionButton;
    LinearLayout settingsButton;
    FloatingActionButton goToBasketButton;
    ImageView noDataImage;


    RecyclerView recyclerView;

    CustomAdapter adapter;

    MyDataBaseHelper myDB;
    ArrayList<String> food_quantity, food_prize;

    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        questionButton = findViewById(R.id.questionButton);
        settingsButton = findViewById(R.id.settingsButton);
        goToBasketButton = findViewById(R.id.goToBasketButton);
        noDataImage = findViewById(R.id.noDataImage);


        recyclerView = findViewById(R.id.recyclerView);
        deleteButton = findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
                recreate();
            }
        });

        goToBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this, BasketActivity.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        /*
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this,QuestionActivity.class);
                startActivity(intent);
            }
        });

         */

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDataBaseHelper(QuestionActivity.this);
        food_quantity = new ArrayList<>();
        food_prize = new ArrayList<>();

        storeDataInArray();
        adapter = new CustomAdapter(QuestionActivity.this, food_quantity, food_prize);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(QuestionActivity.this));
    }

    private void delete() {
        MyDataBaseHelper myDB = new MyDataBaseHelper(this);
        myDB.deleteAllData();
    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            noDataImage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                noDataImage.setVisibility(View.GONE);
                food_quantity.add(cursor.getString(1));
                food_prize.add(cursor.getString(2) + " Ft");
            }
        }
    }
}
