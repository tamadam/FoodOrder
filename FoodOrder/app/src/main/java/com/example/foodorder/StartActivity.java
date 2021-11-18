package com.example.foodorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.foodorder.Models.FruitsModel;

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
        OrderFood.allItems.add(new FruitsModel(R.drawable.ananasz, "Ananasz","600","Ananasz","1"));
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


    }
    public void onClick(View v) {
        startActivity(new Intent(StartActivity.this, MainActivity.class));
    }

}
