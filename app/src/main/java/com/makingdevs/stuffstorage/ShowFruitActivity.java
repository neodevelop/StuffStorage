package com.makingdevs.stuffstorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowFruitActivity extends AppCompatActivity {

    private TextView mKindLabel;
    private TextView mSizeLabel;
    private TextView mPropertyLabel;
    private TextView mBenefitLabel;
    private Button mDeleteFruit;
    private static Fruit mFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fruit);
        mKindLabel = (TextView) findViewById(R.id.fruit_kind_label);
        mSizeLabel = (TextView) findViewById(R.id.fruit_size_label);
        mPropertyLabel = (TextView) findViewById(R.id.fruit_property_label);
        mBenefitLabel = (TextView) findViewById(R.id.fruit_benefit_label);
        mDeleteFruit = (Button) findViewById(R.id.button_submit);
        mKindLabel.setText(mFruit.getKind());
        mSizeLabel.setText(mFruit.getSize());
        mPropertyLabel.setText(mFruit.getProperty());
        mBenefitLabel.setText(mFruit.getBenefit());
        mDeleteFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public static Intent newIntentWithContext(Context mContext, Fruit fruit) {
        mFruit = fruit;
        Intent intent = new Intent(mContext, ShowFruitActivity.class);
        return intent;
    }
}
