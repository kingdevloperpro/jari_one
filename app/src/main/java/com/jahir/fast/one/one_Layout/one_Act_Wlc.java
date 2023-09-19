package com.jahir.fast.one.one_Layout;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import com.jahir.fast.one.one_Chat.one_Act_Chat;
import com.jahir.fast.one.R;
import com.jahir.fast.one.databinding.ExitDialoggBinding;
import com.sdk.ads.Comman;
import com.sdk.ads.LocalSave.ModelPrefrences;
import com.sdk.ads.ads.AllNativeAds;
import com.sdk.ads.ads.MoreAppUtils;

public class one_Act_Wlc extends AppCompatActivity {

    private AppCompatButton welcome;
    ModelPrefrences modelPrefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two__wlc);

        if (Comman.mainResModel != null && Comman.mainResModel.getData().getExtraFields().getAds().equalsIgnoreCase("on")) {
            AllNativeAds.NativeBanner(this, findViewById(R.id.adsContainer));
        }

        welcome = findViewById(R.id.welcome);
        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isStoragePermissionGranted(0)) {

                    if (Comman.mainResModel != null && Comman.mainResModel.getData().getExtraFields().getIsLongApp().equalsIgnoreCase("on")) {
                        startActivity(new Intent(one_Act_Wlc.this, one_Act_Sex.class));
                    } else {
                        startActivity(new Intent(one_Act_Wlc.this, one_Act_Chat.class));
                    }
                }
            }
        });

    }

    public boolean isStoragePermissionGranted(int request) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.CAMERA
                        , Manifest.permission.INTERNET}, request);
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {

        if (Comman.mainResModel.getData().getExtraFields().getExtraNewScreen().equalsIgnoreCase("off")) {
            MoreAppUtils.exitDialog(this);
        } else {
            final Dialog dialog = new Dialog(this);
            ExitDialoggBinding binding1 = ExitDialoggBinding.inflate(((Activity) this).getLayoutInflater());
            dialog.setContentView(binding1.getRoot());
            dialog.setCancelable(true);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            AllNativeAds.NativeAdsNew(this, binding1.adsContainer1);
            binding1.done.setOnClickListener(v -> {
                finishAffinity();

            });

            binding1.cancel.setOnClickListener(view -> dialog.dismiss());
            dialog.show();
        }}
}