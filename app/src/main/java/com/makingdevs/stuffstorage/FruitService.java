package com.makingdevs.stuffstorage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by makingdevs on 01/12/17.
 */

public interface FruitService {

    @GET("/fruit")
    Call<List<Fruit>> listFruits();

    @GET("/fruit/{id}")
    Call<Fruit> getSingleFruit(@Path("id") int id);

    @POST("/fruit")
    Call<Fruit> saveFruit(@Body Fruit fruit);
}
