package com.makingdevs.stuffstorage;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mFruitList;
    private FruitAdapter fruitAdapter;
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFruitList = (RecyclerView) findViewById(R.id.fruit_list);
        fruitAdapter = new FruitAdapter(fruitList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mFruitList.setLayoutManager(mLayoutManager);
        mFruitList.setItemAnimator(new DefaultItemAnimator());
        mFruitList.setAdapter(fruitAdapter);
        prepareData();
    }

    private void prepareData(){
        fruitList.add(new Fruit("Manzana"));
        fruitList.add(new Fruit("Mango"));
        fruitAdapter.notifyDataSetChanged();
    }
}