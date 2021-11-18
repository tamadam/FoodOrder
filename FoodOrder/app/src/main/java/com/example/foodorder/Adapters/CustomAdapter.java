package com.example.foodorder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList food_quantity, food_prize;



    public CustomAdapter(Context context,
                         ArrayList food_quantity,
                         ArrayList food_prize){
        this.context = context;
        this.food_quantity = food_quantity;
        this.food_prize = food_prize;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_raw,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.food_id_text.setText(String.valueOf(food_quantity.get(position)));
        holder.foodSg.setText(String.valueOf(food_prize.get(position)));
    }

    @Override
    public int getItemCount() {
        return food_quantity.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView food_id_text;
        TextView foodSg;

        public MyViewHolder(View view) {
            super(view);
            food_id_text = view.findViewById(R.id.food_id_text);
            foodSg = view.findViewById(R.id.foodSg);
        }
    }
}
