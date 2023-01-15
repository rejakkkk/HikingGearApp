package com.example.hikingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hikingapp.Adapter.CategoryAdapter;
import com.example.hikingapp.Adapter.PopularAdapter;
import com.example.hikingapp.Model.ModelCategory;
import com.example.hikingapp.Model.ModelGear;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterCategory, adapterPopular, adapterLastview;
    private RecyclerView recyclerViewCategory, recyclerViewPopular, recyclerViewLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerViewCategory();
        setRecyclerViewPopular();
        setRecyclerViewLv();
    }

    private void setRecyclerViewCategory(){
        LinearLayoutManager categoryLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory = findViewById(R.id.recyclerViewCategory);
        recyclerViewCategory.setLayoutManager(categoryLayoutManager);

        ArrayList<ModelCategory> category = new ArrayList<>();
        category.add(new ModelCategory("Sepatu", "sepatu"));
        category.add(new ModelCategory("Jaket", "jaket"));
        category.add(new ModelCategory("Celana", "celana"));
        category.add(new ModelCategory("Topi","topi"));
        category.add(new ModelCategory("Sendal", "sandal"));

        adapterCategory = new CategoryAdapter(category);
        recyclerViewCategory.setAdapter(adapterCategory);
    }

    private void setRecyclerViewPopular(){
        LinearLayoutManager popularLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopular = findViewById(R.id.recyclerViewPopular);
        recyclerViewPopular.setLayoutManager(popularLayoutManager);

        ArrayList<ModelGear> gearList = new ArrayList<>();
        gearList.add(new ModelGear("Tiger Claw","Eiger","gambarsepatu","Rp 350.000"));
        gearList.add(new ModelGear("Vermillion","Consina","gambarjaket","Rp 250.000"));
        gearList.add(new ModelGear("Everest V1","Arei","gambarcelana","Rp 150.000"));
        gearList.add(new ModelGear("Tomahawk","Eiger","gambarsendal","Rp 130.000"));
        gearList.add(new ModelGear("Genoa","Arei","gambartopi","Rp 50.000"));

        adapterPopular= new PopularAdapter(gearList);
        recyclerViewPopular.setAdapter(adapterPopular);
    }

    private void setRecyclerViewLv(){
        LinearLayoutManager LvLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewLv = findViewById(R.id.recyclerViewLastview);
        recyclerViewLv.setLayoutManager(LvLayoutManager);

        ArrayList<ModelGear> gearList = new ArrayList<>();
        gearList.add(new ModelGear("Tiger Claw","Eiger","gambarsepatu","Rp 350.000"));
        gearList.add(new ModelGear("Vermillion","Consina","gambarjaket","Rp 250.000"));
        gearList.add(new ModelGear("Everest V1","Arei","gambarcelana","Rp 150.000"));
        gearList.add(new ModelGear("Tomahawk","Eiger","gambarsendal","Rp 130.000"));
        gearList.add(new ModelGear("Genoa","Arei","gambartopi","Rp 50.000"));

        adapterLastview= new PopularAdapter(gearList);
        recyclerViewLv.setAdapter(adapterPopular);
    }
}