package com.makingdevs.stuffstorage;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by makingdevs on 04/12/17.
 */

public class NetworkCall extends AsyncTask<Call, Void, List<Fruit>> {
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
        super.onPostExecute(fruits);
    }
}
