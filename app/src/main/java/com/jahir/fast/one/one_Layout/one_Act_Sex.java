package com.jahir.fast.one.one_Layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.jahir.fast.one.R;
import com.sdk.ads.ads.AllNativeAds;
import com.sdk.ads.ads.IntertitialAdsEvent;

public class one_Act_Sex extends AppCompatActivity {

    private AppCompatButton gender_next;
    private LinearLayout ll_male, ll_female;
    private ImageView chk_male, chk_female;
    private boolean checker = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two__sex);

        IntertitialAdsEvent.CallInterstitial(this);
        IntertitialAdsEvent.ShowInterstitialAdsOnCreate(this);
        AllNativeAds.NativeAds(this, findViewById(R.id.big_native));


        gender_next = findViewById(R.id.gender_next);
        ll_male = findViewById(R.id.ll_male);
        ll_female = findViewById(R.id.ll_female);
        chk_male = findViewById(R.id.chk_male);
        chk_female = findViewById(R.id.chk_female);

        ll_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = true;
                chk_male.setImageResource(R.drawable.check);
                chk_female.setImageResource(R.drawable.uncheck);
            }
        });

        ll_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = true;
                chk_male.setImageResource(R.drawable.uncheck);
                chk_female.setImageResource(R.drawable.check);
            }
        });

        gender_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker) {
                    startActivity(new Intent(one_Act_Sex.this, one_Act_Age.class));
                } else {
                    Toast.makeText(one_Act_Sex.this, "select gender first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        IntertitialAdsEvent.ShowInterstitialAdsOnBack(this);
    }
}