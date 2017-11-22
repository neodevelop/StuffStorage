package com.makingdevs.stuffstorage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by makingdevs on 21/11/17.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<Fruit> mFruits;

    public FruitAdapter(List fruits){
        this.mFruits = fruits;
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fruit, parent, false);

        return new FruitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        Fruit fruit = mFruits.get(position);
        holder.mFruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruits.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {

        private TextView mFruitName;

        public FruitViewHolder(View itemView) {
            super(itemView);
            mFruitName = (TextView) itemView.findViewById(R.id.fruit_name);
        }

    }

}
