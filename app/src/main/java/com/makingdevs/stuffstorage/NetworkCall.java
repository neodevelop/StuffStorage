package com.makingdevs.stuffstorage;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by makingdevs on 04/12/17.
 */

public class NetworkCall extends AsyncTask<Call, Void, String> {
    @Override
    protected String doInBackground(Call[] calls) {
        try {
            Call<List<Fruit>> call = calls[0];
            Response<List<Fruit>> response = call.execute();
            System.out.println("********************");
            List<Fruit> fruits = response.body();
            System.out.println(fruits);
            System.out.println("********************");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
