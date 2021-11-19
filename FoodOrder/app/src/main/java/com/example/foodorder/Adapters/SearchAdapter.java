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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchAdapterHolder> {

    public static ArrayList<FruitsModel> myItems;
    Context context;


    public SearchAdapter(ArrayList<FruitsModel> items, Context context){
        this.myItems = items;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_searchfood, parent, false);
        return new SearchAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapterHolder holder, int position) {
        FruitsModel current = myItems.get(position);
        holder.imageViewSearch.setImageResource(current.getImage());
        holder.textViewSearch.setText(current.getName());
        holder.textViewSearch2.setText(current.getPrice() + " Ft");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FruitsBuy.class);
                intent.putExtra("image", current.getImage());
                intent.putExtra("price", current.getPrice());
                intent.putExtra("description", current.getDescription());
                intent.putExtra("name", current.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    public void filterList(ArrayList<FruitsModel> filteredList){
        myItems = filteredList;
        notifyDataSetChanged();
    }

    public static class SearchAdapterHolder extends RecyclerView.ViewHolder{

        public ImageView imageViewSearch;
        public TextView textViewSearch;
        public TextView textViewSearch2;

        public SearchAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSearch = itemView.findViewById(R.id.imageViewSearch);
            textViewSearch = itemView.findViewById(R.id.textViewSearch);
            textViewSearch2 = itemView.findViewById(R.id.textViewSearch2);

        }
    }


}
