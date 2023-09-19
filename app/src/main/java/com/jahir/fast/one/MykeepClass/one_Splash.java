package com.jahir.fast.one.MykeepClass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.jahir.fast.one.mvvmbalaji.SelectLanguage_Activity;
import com.jahir.fast.one.one_Layout.one_Act_Wlc;
import com.sdk.ads.Comman;
import com.sdk.ads.LocalSave.Common;
import com.sdk.ads.ads.SplashBetaAds;
import com.sdk.ads.ads.TransferClass;
import com.jahir.fast.one.R;

@SuppressLint("CustomSplashScreen")
public class one_Splash extends SplashBaseActivity {

    public  static int int_Language=1;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.two__sp);

    }

    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (!isDevMode())
        getSetting();
    }



    public SharedPreferences getPrefs() {
        return getSharedPreferences(Common.SHARED_PREFS, MODE_PRIVATE);
    }

    public void moveToNext() {

        if (Common.isNetworkConnected(one_Splash.this)) {
            try {
                SplashBetaAds.ShowInterstitialAd(this, () -> {
                    if (Comman.mainResModel.getData().getExtraFields().getExtraNewScreen().equalsIgnoreCase("on")) {
                        int_Language=1;
                        Intent intent = new Intent(one_Splash.this, SelectLanguage_Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        TransferClass.setToNextActivity(one_Splash.this, one_Act_Wlc.class);

                    }
                });
            } catch (Exception e) {
                SplashBetaAds.ShowInterstitialAd(this, () -> {
                    if (Comman.mainResModel.getData().getExtraFields().getExtraNewScreen().equalsIgnoreCase("on")) {
                        int_Language=1;
                        Intent intent = new Intent(one_Splash.this, SelectLanguage_Activity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        TransferClass.setToNextActivity(one_Splash.this, one_Act_Wlc.class);
                    }
                });
            }
        } else {
            Toast.makeText(this, "No Active Internet/WiFi Connection!", Toast.LENGTH_SHORT).show();
        }
    }

}
