package com.makingdevs.stuffstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewFruitActivity extends AppCompatActivity {

    private EditText mKindInput;
    private EditText mSizeInput;
    private EditText mPropertyInput;
    private EditText mBenefitInput;
    private Button mSaveFruit;
    private Fruit mFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fruit);
        mFruit = new Fruit();
        mKindInput = (EditText) findViewById(R.id.fruit_kind_input);
        mSizeInput = (EditText) findViewById(R.id.fruit_size_input);
        mPropertyInput = (EditText) findViewById(R.id.fruit_property_input);
        mBenefitInput = (EditText) findViewById(R.id.fruit_benefit_input);
        mSaveFruit = (Button) findViewById(R.id.button_submit);
        mSaveFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFruit.setBenefit(mBenefitInput.getText().toString());
                mFruit.setKind(mKindInput.getText().toString());
                mFruit.setProperty(mPropertyInput.getText().toString());
                mFruit.setSize(mSizeInput.getText().toString());
            }
        });
    }

    public static Intent newIntentWithContext(Context baseContext) {
        Intent intent = new Intent(baseContext, NewFruitActivity.class);
        return intent;
    }
}
