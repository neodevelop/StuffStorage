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

    public FruitAdapter(List<Fruit> fruits){
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
        holder.mFruitKind.setText(fruit.getKind());
        holder.mFruitSize.setText(fruit.getSize());
        holder.mFruitProperty.setText(fruit.getProperty());
        holder.mFruitBenefit.setText(fruit.getBenefit());
    }

    @Override
    public int getItemCount() {
        return mFruits.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {

        private TextView mFruitKind;
        private TextView mFruitSize;
        private TextView mFruitProperty;
        private TextView mFruitBenefit;

        public FruitViewHolder(View itemView) {
            super(itemView);
            mFruitKind = (TextView) itemView.findViewById(R.id.fruit_kind);
            mFruitSize = (TextView) itemView.findViewById(R.id.fruit_size);
            mFruitProperty = (TextView) itemView.findViewById(R.id.fruit_property);
            mFruitBenefit = (TextView) itemView.findViewById(R.id.fruit_benefit);
        }

    }

}
