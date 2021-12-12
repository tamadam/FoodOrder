package com.example.foodorder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Adapters.FruitsAdapter;
import com.example.foodorder.Models.FruitsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fruits extends AppCompatActivity{
    TextView count;
    private RecyclerView recyclerView;
    LinearLayout homeButton;
    LinearLayout profileButton;
    LinearLayout questionButton;
    LinearLayout settingsButton;
    FloatingActionButton goToBasketButton;



    ArrayList<FruitsModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        recyclerView = findViewById(R.id.recyclerView);
        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        questionButton = findViewById(R.id.questionButton);
        settingsButton = findViewById(R.id.settingsButton);
        goToBasketButton = findViewById(R.id.goToBasketButton);




        list.add(new FruitsModel(R.drawable.apple, "Apple","300","Finom", "1"));
        list.add(new FruitsModel(R.drawable.banana, "Banana","250","Banán sárga","1"));
        list.add(new FruitsModel(R.drawable.melon, "Melon","250","Sárgadinnye","1"));
        list.add(new FruitsModel(R.drawable.watermelon, "Watermelon","400","Görögdinnye","1"));
        list.add(new FruitsModel(R.drawable.orange, "Orange","119","Narancs","1"));
        list.add(new FruitsModel(R.drawable.ananasz, "Pineapple","600","Ananasz","1"));



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new FruitsAdapter(list, this));

        goToBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fruits.this, BasketActivity.class);
                startActivity(intent);
            }
        });


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fruits.this,MainActivity.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fruits.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fruits.this,QuestionActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fruits.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }


}
