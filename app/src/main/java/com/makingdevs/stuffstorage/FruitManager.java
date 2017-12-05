package com.makingdevs.stuffstorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by makingdevs on 23/11/17.
 */

public class FruitManager {

    private static FruitManager fruitManager = null;

    private static List<Fruit> fruits = null;

    private static FruitService fruitService;

    private FruitManager(){
        this.fruits = new ArrayList<Fruit>();
    }

    public static FruitManager getInstance(){
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
        if(fruitManager == null)
            fruitManager = new FruitManager();
        return fruitManager;
    }

    public int size(){
        return this.fruits.size();
    }

    public void addFruit(Fruit fruit){
        this.fruits.add(fruit);
    }

    public Fruit getFruit(int index){
        return this.fruits.get(index);
    }

    public List<Fruit> getFruits(){

        return fruits;
    }

}
