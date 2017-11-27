package com.makingdevs.stuffstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewFruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fruit);
    }

    public static Intent newIntentWithContext(Context baseContext) {
        Intent intent = new Intent(baseContext, NewFruitActivity.class);
        return intent;
    }
}
