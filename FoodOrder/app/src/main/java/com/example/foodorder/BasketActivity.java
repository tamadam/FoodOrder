package com.example.foodorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Adapters.BasketAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class BasketActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;
    TextView orderButtonPay;
    LinearLayout homeButton;
    LinearLayout profileButton;
    LinearLayout questionButton;
    LinearLayout settingsButton;
    FloatingActionButton goToBasketButton;
    TextView deliveryFeeText;
    public static TextView sumOfMoneyText;
    public static TextView emptyText;

    public static ArrayList<String> listNames = new ArrayList<>();
    public static ArrayList<String> listQuantity = new ArrayList<>();
    public static ArrayList<Integer> listPrices = new ArrayList();
    public static int osszegNAGY2 = 450;
    public static int tmposszeg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        questionButton = findViewById(R.id.questionButton);
        settingsButton = findViewById(R.id.settingsButton);
        goToBasketButton = findViewById(R.id.goToBasketButton);
        emptyText = findViewById(R.id.emptyText);
        deliveryFeeText = findViewById(R.id.deliveryFeeText);
        sumOfMoneyText = findViewById(R.id.sumOfMoneyText);


        orderButtonPay = findViewById(R.id.orderButtonPay);
        orderButtonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (osszegNAGY2 <= MainActivity.currentMoney) {
                    if (OrderFood.foods.size() != 0) {
                        Log.d("myapp", "PAYED");
                        Intent intent = new Intent(BasketActivity.this, MainActivity.class);
                        MyDataBaseHelper myDB = new MyDataBaseHelper(BasketActivity.this);
                        myDB.addBook(osszegNAGY2, OrderFood.quantity.size());
                        BasketAdapter.listNum.clear();
                        BasketAdapter.list.clear();
                        BasketAdapter.listPriceNum.clear();
                        OrderFood.quantity.clear();
                        OrderFood.foods.clear();
                        OrderFood.prices.clear();
                        int osszeg = MainActivity.currentMoney -= osszegNAGY2;

                        SharedPreferences.Editor mEditor = MainActivity.settings.edit();
                        mEditor.putInt(MainActivity.STATE_KEY_PASSWORD, osszeg).commit();

                        Log.d("pay", osszeg+"");



                        Toast.makeText(BasketActivity.this, "Successful order", Toast.LENGTH_SHORT).show();


                        startActivity(intent);
                    } else {
                        Toast.makeText(BasketActivity.this, "Your cart is empty", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(BasketActivity.this, "You don't have enough money on your account", Toast.LENGTH_SHORT).show();
                }
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasketActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasketActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasketActivity.this,QuestionActivity.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasketActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);

        int meret = OrderFood.foods.size();
        if (meret > 0){
            emptyText.setText("");
        }
        listNames.clear();
        listQuantity.clear();
        listPrices.clear();
        osszegNAGY2 = 450;

        for(int i = 0; i < meret; i++){
            listNames.add(OrderFood.foods.get(i));
            //BasketAdapter.list.add(OrderFood.foods.get(i));
            listQuantity.add(String.valueOf(OrderFood.quantity.get(i)));
            //BasketAdapter.listNum.add(String.valueOf(OrderFood.quantity.get(i)));
            listPrices.add(OrderFood.prices.get(i));
            int osszeg = Integer.parseInt(OrderFood.quantity.get(i)) * OrderFood.prices.get(i);
            tmposszeg = osszeg;
            osszegNAGY2 += osszeg;
        }
        /*
        for(int i = 0; i < meret; i++){
            String name = listNames.get(i);
            //String name = BasketAdapter.list.get(i);
            String quantity = listQuantity.get(i);
            //String quantity = BasketAdapter.listNum.get(i);
            //Log.d("myapp", "name: " + name + " mennyiseg: " + quantity);
        }

         */
        deliveryFeeText.setText("Delivery fee: 450 HUF");
        if (meret > 0){
            //sumOfMoneyText.setText("TOTAL: " + String.valueOf(sumOfPrices(listPrices)+450) + " HUF");
            sumOfMoneyText.setText("TOTAL: " + String.valueOf(osszegNAGY2) + " HUF");
        }
        else{
            sumOfMoneyText.setText("TOTAL: 0 HUF");
        }

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new BasketAdapter(listNames, listQuantity, listPrices);
        //adapter = new BasketAdapter(BasketAdapter.list, BasketAdapter.listNum);

        recyclerView.setAdapter(adapter);
    }

    public static void delete(int szam){
        adapter.notifyItemRemoved(szam);
    }

    private int sumOfPrices(ArrayList<Integer> listPriceNum) {
        float sum = 0;
        for (Integer elem : listPriceNum) {
            sum += elem;
        }
        return (int)sum;
    }
/*
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences settings = getSharedPreferences(MainActivity.SAVE, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(MainActivity.STATE_KEY_PASSWORD, MainActivity.currentMoney-osszegNAGY2);

        // Commit the edits!
        editor.commit();
    }

 */
/*
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MainActivity.STATE_KEY_PASSWORD, MainActivity.currentMoney);
    }

 */





}
