package com.jahir.fast.one.one_Layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.jahir.fast.one.R;
import com.sdk.ads.ads.AllNativeAds;
import com.sdk.ads.ads.IntertitialAdsEvent;

public class one_Act_Cat extends AppCompatActivity {

    LinearLayout videocall, chatgpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two__cat);

        IntertitialAdsEvent.CallInterstitial(this);
        IntertitialAdsEvent.ShowInterstitialAdsOnCreate(this);
        AllNativeAds.NativeAds(this, findViewById(R.id.big_native));



        videocall = findViewById(R.id.videocall);
        chatgpt = findViewById(R.id.chatgpt);

        videocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(one_Act_Cat.this, one_Act_VC_Room.class));
            }
        });


        chatgpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(one_Act_Cat.this, one_Act_Chat_Room.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        IntertitialAdsEvent.ShowInterstitialAdsOnBack(this);
    }
}