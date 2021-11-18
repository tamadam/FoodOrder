package com.example.foodorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Adapters.FruitsAdapter;
import com.example.foodorder.Models.FruitsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Vegetables extends AppCompatActivity {

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
        setContentView(R.layout.activity_vegetables);
        recyclerView = findViewById(R.id.recyclerView);
        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        questionButton = findViewById(R.id.questionButton);
        settingsButton = findViewById(R.id.settingsButton);
        goToBasketButton = findViewById(R.id.goToBasketButton);


        list.add(new FruitsModel(R.drawable.repapicture, "Carrot","150","Sárga nagyon", "1"));
        list.add(new FruitsModel(R.drawable.retek, "Radish","200","Finike","1"));
        list.add(new FruitsModel(R.drawable.hagyma, "Onion","300","Sárgadinnye","1"));
        list.add(new FruitsModel(R.drawable.kaposzta, "Cabbage","399","Görögdinnye","1"));
        list.add(new FruitsModel(R.drawable.burgonya, "Potato","120","Narancs","1"));
        list.add(new FruitsModel(R.drawable.uborka, "Cucumber","110","zöld","1"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new FruitsAdapter(list, this));

        goToBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Vegetables.this, BasketActivity.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Vegetables.this,MainActivity.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Vegetables.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Vegetables.this,QuestionActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Vegetables.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
