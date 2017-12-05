package com.makingdevs.stuffstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShowFruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fruit);
    }

    public static Intent newIntentWithContext(Context mContext, Fruit fruit) {
        Intent intent = new Intent(mContext, ShowFruitActivity.class);
        return intent;
    }
}
