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
import com.example.hikingapp.Model.ModelCategory;
import com.example.hikingapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<ModelCategory>modelCategory;

    public CategoryAdapter(ArrayList<ModelCategory> modelCategory) {
        this.modelCategory = modelCategory;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(modelCategory.get(position).getTitle());
        holder.backgroundLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.category_background));
        String picUrl="";
        switch (position){
            case 0: {
                picUrl = "sepatu";
                break;
            }
            case 1:{
                picUrl = "jaket";
                break;
            }
            case 2:{
                picUrl = "celana";
                break;
            }
            case 3:{
                picUrl = "topi";
                break;
            }
            case 4:{
                picUrl = "sandal";
                break;
            }
        }
        int drawabbleResourcesId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawabbleResourcesId).into(holder.categoryPic);

    }

    @Override
    public int getItemCount() {

        return modelCategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout backgroundLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            categoryName=itemView.findViewById(R.id.titlecategory);
            categoryPic= itemView.findViewById(R.id.categorypic);
            backgroundLayout=itemView.findViewById(R.id.backgroundcategory);

        }
    }
}
