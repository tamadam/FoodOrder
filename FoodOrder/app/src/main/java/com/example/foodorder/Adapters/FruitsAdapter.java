package com.example.foodorder.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.FruitsBuy;
import com.example.foodorder.Models.FruitsModel;
import com.example.foodorder.R;

import java.util.ArrayList;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.viewholder> {

    public static int image_id;

    ArrayList<FruitsModel> list;
    Context context;





    public FruitsAdapter(ArrayList<FruitsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final FruitsModel model = list.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FruitsBuy.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("name", model.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView mainName, price, description, count;
        ImageView minusButton, plusButton;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.addImage);
            mainName = itemView.findViewById(R.id.nameFood2);
            price = itemView.findViewById(R.id.price);
            description = itemView.findViewById(R.id.description);



        }
/*
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.plusButton){
                image_id = 1;
            }
            if(view.getId()==R.id.minusButton){
                image_id = 2;
            }

            onNoteListener.onNoteClick(getAdapterPosition());
        }

 */
    }

}
