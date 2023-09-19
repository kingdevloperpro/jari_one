package com.jahir.fast.one.one_Layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.jahir.fast.one.one_Chat.one_Act_Chat;
import com.jahir.fast.one.R;
import com.sdk.ads.ads.AllNativeAds;
import com.sdk.ads.ads.IntertitialAdsEvent;

public class one_Act_Chat_Room extends AppCompatActivity {

    private LinearLayout room1, room2, room3, room4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two__chat_room);

        IntertitialAdsEvent.CallInterstitial(this);
        IntertitialAdsEvent.ShowInterstitialAdsOnCreate(this);
        AllNativeAds.NativeAds(this, findViewById(R.id.big_native));
        //check 2nd native


        room1 = findViewById(R.id.room1);
        room2 = findViewById(R.id.room2);
        room3 = findViewById(R.id.room3);
        room4 = findViewById(R.id.room4);

        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    private void next() {
        startActivity(new Intent(one_Act_Chat_Room.this, one_Act_Chat.class));
    }

    @Override
    public void onBackPressed() {
        IntertitialAdsEvent.ShowInterstitialAdsOnBack(this);
    }
}