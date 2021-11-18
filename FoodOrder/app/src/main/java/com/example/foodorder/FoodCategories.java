package com.example.foodorder;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodCategories extends RecyclerView.Adapter<FoodCategories.ViewHolder>{
    ArrayList<CategoryHelper> categoryHelper;

    private RecyclerViewClickListener listener;


    public FoodCategories(ArrayList<CategoryHelper> categoryHelper) {
        this.categoryHelper = categoryHelper;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category,parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryHelper.get(position).getPicture());
        String pictureUrl="";
        switch (position){
            case 0: {
                pictureUrl="melon";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
                holder.categoryName.setText("Fruits");
                break;
            }
            case 1: {
                pictureUrl="repa";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
                holder.categoryName.setText("Vegetables");
                break;
            }
            case 2: {
                pictureUrl="drink";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
                holder.categoryName.setText("Drinks");

                break;
            }
            case 3: {
                pictureUrl="vitaminok";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
                holder.categoryName.setText("Vitamins");
                break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(pictureUrl,"drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPicture);
    }


    @Override
    public int getItemCount() {
        return categoryHelper.size();
    }


    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPicture;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPicture=itemView.findViewById(R.id.categoryPicture);
            mainLayout=itemView.findViewById(R.id.mainLayout);

        }
    }


}
