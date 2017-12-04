package com.makingdevs.stuffstorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        //prepareData();
    }

    private void prepareData(){
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

    @Override
    protected void onResume() {
        System.out.println("onResume");
        fruitManager.getFruits();
        super.onResume();
    }
}