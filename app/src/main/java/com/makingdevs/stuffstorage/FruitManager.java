package com.makingdevs.stuffstorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by makingdevs on 23/11/17.
 */

public class FruitManager {

    private static FruitManager fruitManager = null;

    private static List<Fruit> fruits;

    private FruitManager(){
        this.fruits = new ArrayList<Fruit>();
    }

    public static FruitManager getInstance(){
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

    public List<Fruit> getFruits(){ return fruits; }

}
