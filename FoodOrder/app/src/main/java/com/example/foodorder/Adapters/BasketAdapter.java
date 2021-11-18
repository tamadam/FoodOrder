package com.example.foodorder.Adapters;

import android.content.Intent;
import android.media.Image;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.BasketActivity;
import com.example.foodorder.Models.FruitsModel;
import com.example.foodorder.OrderFood;
import com.example.foodorder.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.viewholder> {

    public static ArrayList<String> list; //names
    public static ArrayList<String> listNum; //quantity
    public static ArrayList<Integer> listPriceNum;
    public static int osszegNAGY = 450;

    public BasketAdapter(ArrayList<String> list,ArrayList<String> listNum, ArrayList<Integer> listPriceNum) {
        this.list = list;
        this.listNum = listNum;
        this.listPriceNum = listPriceNum;

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_basket,parent, false);

        return new BasketAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        holder.nameFood2.setText(list.get(position));
        holder.quantity2.setText("Quantity: " + listNum.get(position));
        int osszeg = Integer.parseInt(listNum.get(position))*listPriceNum.get(position);
        osszegNAGY += osszeg;
        holder.priceTextView.setText( (osszeg) + " FT");
        //holder.priceTextView.setText(String.valueOf(Integer.parseInt(listNum.get(position))*listPriceNum.get(position)) + " FT");
        //int sum = sumOfPrices(total);


        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int osszeg = Integer.parseInt(listNum.get(holder.getAdapterPosition()))*listPriceNum.get(holder.getAdapterPosition());

                list.remove(holder.getAdapterPosition());
                listNum.remove(holder.getAdapterPosition());
                listPriceNum.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(),listNum.size());
                notifyItemRangeChanged(holder.getAdapterPosition(),list.size());
                notifyItemRangeChanged(holder.getAdapterPosition(),listPriceNum.size());
                //BasketActivity.listNames.remove(holder.getAdapterPosition());
                //BasketActivity.listQuantity.remove(holder.getAdapterPosition());

                //BasketActivity.adapter.notifyItemRemoved(holder.getAdapterPosition());
                OrderFood.foods.clear();
                OrderFood.quantity.clear();
                OrderFood.foods = new ArrayList<>(list);
                OrderFood.quantity = new ArrayList<>(listNum);
                OrderFood.prices.clear();
                OrderFood.prices = new ArrayList<>(listPriceNum);

                osszegNAGY = sumOfNewList(listNum,listPriceNum);
                BasketActivity.osszegNAGY2 = osszegNAGY + 450;

                //BasketActivity.sumOfMoneyText.setText("TOTAL: " + String.valueOf(sumOfPrices(listPriceNum)+450) + " FT");
                BasketActivity.sumOfMoneyText.setText("TOTAL: " + (osszegNAGY + 450) + " FT");
                if (OrderFood.foods.size() == 0){
                    BasketActivity.emptyText.setText("Your cart is empty, find yourself a healthy food and come back");
                    BasketActivity.sumOfMoneyText.setText("TOTAL: 0 FT");
                }

            }
        });

    }

    private int sumOfNewList(ArrayList<String> listNum, ArrayList<Integer> listPriceNum) {
        int osszeg = 0;
        for(int i = 0; i < listNum.size(); i++){
            osszeg += (Integer.parseInt(listNum.get(i)))*listPriceNum.get(i);
        }
        return osszeg;
    }

    private int sumOfPrices(ArrayList<Integer> listPriceNum) {
        float sum = 0;
        for(Integer elem: listPriceNum){
            sum += elem;
        }
        return (int)sum;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView nameFood2;
        TextView quantity2;
        TextView priceTextView;

        ImageView imageViewDelete;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            nameFood2 = itemView.findViewById(R.id.nameFood2);
            quantity2 = itemView.findViewById(R.id.quantity2);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);
            priceTextView = itemView.findViewById(R.id.priceTextView);
        }
    }
}
