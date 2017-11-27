package com.makingdevs.stuffstorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
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
    private FruitManager fruitManager = FruitManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFruitList = (RecyclerView) findViewById(R.id.fruit_list);
        fruitAdapter = new FruitAdapter(fruitManager);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mFruitList.setLayoutManager(mLayoutManager);
        mFruitList.setItemAnimator(new DefaultItemAnimator());
        mFruitList.setAdapter(fruitAdapter);
        prepareData();
    }

    private void prepareData(){
        fruitManager.addFruit(new Fruit("Tipo 1", "Chica", "Punch", "Rifadez"));
        fruitManager.addFruit(new Fruit("Tipo 2", "Chica", "Punch", "Rifadez"));
        fruitManager.addFruit(new Fruit("Tipo 3", "Chica", "Punch", "Rifadez"));
        fruitManager.addFruit(new Fruit("Tipo 4", "Chica", "Punch", "Rifadez"));
        fruitManager.addFruit(new Fruit("Tipo 5", "Chica", "Punch", "Rifadez"));
        fruitManager.addFruit(new Fruit("Tipo 6", "Chica", "Punch", "Rifadez"));
        fruitManager.addFruit(new Fruit("Tipo 7", "Chica", "Punch", "Rifadez"));
        fruitManager.addFruit(new Fruit("Tipo 8", "Chica", "Punch", "Rifadez"));
        fruitAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_in_button:
                Intent intent = NewFruitActivity.newIntentWithContext(this.getBaseContext());
                startActivity(intent);
                break;
            case R.id.add_in_menu:
                System.out.println("ADD 2");
                break;
            case R.id.list:
                System.out.println("LIST");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}