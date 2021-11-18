package com.example.foodorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FruitsBuy extends AppCompatActivity {

   ImageView detailImage;
   TextView nameFoodOrder;
   TextView descriptionText;
   ImageView add;
   ImageView subtract;
   TextView quantity;
   TextView priceText;
   LinearLayout addToBasket;
   LinearLayout goBackToArukLayout;

   int original;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruitsbuy);

        detailImage = findViewById(R.id.detailImage);
        nameFoodOrder = findViewById(R.id.nameFoodOrder);
        descriptionText = findViewById(R.id.descriptionText);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        quantity = findViewById(R.id.quantity);
        addToBasket = findViewById(R.id.addToBasket);
        priceText = findViewById(R.id.priceText);
        goBackToArukLayout = findViewById(R.id.goBackToArukLayout);


        int image = getIntent().getIntExtra("image", 0);
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        original = price;
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");

        detailImage.setImageResource(image);
        nameFoodOrder.setText(name);
        descriptionText.setText(description);
        priceText.setText(String.valueOf(price));


        goBackToArukLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam = Integer.parseInt((String) quantity.getText());
                szam += 1;
                quantity.setText(String.valueOf(szam));
                int ar = Integer.parseInt((String) priceText.getText());
                ar += original;
                priceText.setText(String.valueOf(ar));

            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam = Integer.parseInt((String) quantity.getText());
                int ar = Integer.parseInt((String) priceText.getText());

                if (szam > 1){
                    szam -= 1;
                    quantity.setText(String.valueOf(szam));
                    ar -= original;
                    priceText.setText(String.valueOf(ar));
                }
            }
        });


        addToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderFood.foods.add(name);
                OrderFood.prices.add((int)price);
                OrderFood.quantity.add((String.valueOf(quantity.getText())));

                //OrderFood.list.add(new FruitsModel(image,name,String.valueOf(price),description,String.valueOf(quantity.getText())));
                Log.d("myapp", "ORDER FOOD "+ String.valueOf(quantity.getText()));
                quantity.setText("1");
                priceText.setText(String.valueOf(original));
                Toast.makeText(FruitsBuy.this, "Item added to the basket", Toast.LENGTH_SHORT).show();
                finish();
            }
        });




    }
}
