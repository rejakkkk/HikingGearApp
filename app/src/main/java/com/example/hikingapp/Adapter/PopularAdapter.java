package com.example.hikingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hikingapp.Model.ModelGear;
import com.example.hikingapp.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<ModelGear> modelGears;

    public PopularAdapter(ArrayList<ModelGear> modelGears) {
        this.modelGears = modelGears;
    }


    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular, parent, false);
        return new PopularAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        holder.titleGear.setText(modelGears.get(position).getTitle());
        holder.brandGear.setText(modelGears.get(position).getBrand());
        holder.priceGear.setText(modelGears.get(position).getPrice());
        holder.backgroundLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.popular_background));
        String picUrl="";
        switch (position){
            case 0: {
                picUrl = "sepatu1";
                break;
            }
            case 1:{
                picUrl = "jaket1";
                break;
            }
            case 2:{
                picUrl = "celana1";
                break;
            }
            case 3:{
                picUrl = "sendal1";
                break;
            }
            case 4:{
                picUrl = "topi1";
                break;
            }
        }
        int drawabbleResourcesId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawabbleResourcesId).into(holder.picGear);

    }

    @Override
    public int getItemCount() {

        return modelGears.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleGear, brandGear, priceGear, addBtn;
        ImageView picGear;
        ConstraintLayout backgroundLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            picGear= itemView.findViewById(R.id.popularpic);
            titleGear=itemView.findViewById(R.id.titlepopular);
            brandGear=itemView.findViewById(R.id.brandpopular);
            priceGear = itemView.findViewById(R.id.pricepopular);
            addBtn = itemView.findViewById(R.id.addBtn);

            backgroundLayout=itemView.findViewById(R.id.backgroundpopular);

        }
    }
}
