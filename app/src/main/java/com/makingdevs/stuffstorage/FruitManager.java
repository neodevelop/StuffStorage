package com.makingdevs.stuffstorage;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by makingdevs on 23/11/17.
 */

public class FruitManager {

    private static FruitManager fruitManager = null;

    private static List<Fruit> mFruits = null;

    private static FruitService fruitService;

    private FruitManager(){
        this.mFruits = new ArrayList<Fruit>();
    }

    public static FruitManager getInstance(){
        if(fruitService == null){
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.8:8080/v1/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
           fruitService = retrofit.create(FruitService.class);
        }
        if(fruitManager == null)
            fruitManager = new FruitManager();
        return fruitManager;
    }

    public int size(){
        return this.mFruits.size();
    }

    public void addFruit(Fruit fruit){
        this.mFruits.add(fruit);
    }

    public Fruit getFruit(int index){
        return this.mFruits.get(index);
    }

    public List<Fruit> getFruits(){
        Call<List<Fruit>> call = fruitService.listFruits();
        new RemoteListFruits().execute(call);
        return mFruits;
    }

    private class RemoteListFruits extends AsyncTask<Call, Void, List<Fruit>> {
        @Override
        protected List<Fruit> doInBackground(Call... calls) {
            try {
                Call<List<Fruit>> call = calls[0];
                Response<List<Fruit>> response = call.execute();
                List<Fruit> fruits = response.body();
                System.out.println(fruits);
                mFruits = fruits;
                return fruits;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(List<Fruit> fruits) {
            mFruits = fruits;
        }
    }
}
