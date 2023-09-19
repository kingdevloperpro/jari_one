package com.jahir.fast.one.one_Layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.jahir.fast.one.R;
import com.sdk.ads.ads.AllNativeAds;
import com.sdk.ads.ads.IntertitialAdsEvent;

public class one_Act_Age extends AppCompatActivity {

    private AppCompatButton age_next;
    private RadioButton r1, r2, r3;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two__age);

        IntertitialAdsEvent.CallInterstitial(this);
        IntertitialAdsEvent.ShowInterstitialAdsOnCreate(this);
        AllNativeAds.NativeAds(this, findViewById(R.id.big_native));
        //check 2nd native

        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        radioGroup = findViewById(R.id.radioGroup);
        age_next = findViewById(R.id.age_next);

        age_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(one_Act_Age.this, one_Act_Cat.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        IntertitialAdsEvent.ShowInterstitialAdsOnBack(this);
    }
}