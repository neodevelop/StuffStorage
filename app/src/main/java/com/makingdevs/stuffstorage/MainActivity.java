package com.makingdevs.stuffstorage;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_FRUIT = 0;
    private RecyclerView mFruitList;
    private FruitAdapter fruitAdapter;
    private static FruitService fruitService;
    private List<Fruit> mFruits = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFruitList = (RecyclerView) findViewById(R.id.fruit_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        if(fruitService == null){
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.134:8080/v1/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            fruitService = retrofit.create(FruitService.class);
        }

        mFruitList.setLayoutManager(mLayoutManager);
        mFruitList.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_FRUIT){
            if(resultCode == Activity.RESULT_OK) {
                if(data == null){
                    System.out.println("NO DATA");
                    return;
                }
                Fruit fruit = new Fruit();
                fruit.setBenefit(data.getStringExtra("com.fruits.benefit"));
                fruit.setKind(data.getStringExtra("com.fruits.kind"));
                fruit.setSize(data.getStringExtra("com.fruits.size"));
                fruit.setProperty(data.getStringExtra("com.fruits.property"));
                Call call = fruitService.saveFruit(fruit);
                new RemoteListFruits().execute(call);
                System.out.println(fruit);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_in_button:
                Intent intent = NewFruitActivity.newIntentWithContext(this.getBaseContext());
                startActivityForResult(intent, REQUEST_CODE_FRUIT);
                break;
            case R.id.add_in_menu:
                Intent intent2 = NewFruitActivity.newIntentWithContext(this.getBaseContext());
                startActivityForResult(intent2, REQUEST_CODE_FRUIT);
                break;
            case R.id.list:
                updateAdapter();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        Call<List<Fruit>> call = fruitService.listFruits();
        new RemoteListFruits().execute(call);
        super.onResume();
    }

    private void updateAdapter(){
        fruitAdapter = new FruitAdapter(getBaseContext(), mFruits);
        mFruitList.setAdapter(fruitAdapter);
        fruitAdapter.notifyDataSetChanged();
    }

    private class RemoteListFruits extends AsyncTask<Call, Void, List<Fruit>> {
        @Override
        protected List<Fruit> doInBackground(Call... calls) {
            try {
                Call<List<Fruit>> call = calls[0];
                Response<List<Fruit>> response = call.execute();
                List<Fruit> fruits = response.body();
                return fruits;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(List<Fruit> fruits) {
            mFruits = fruits;
            updateAdapter();
        }
    }
}