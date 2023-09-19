package com.jahir.fast.one.MykeepClass;

import android.app.Activity;
import android.content.Context;
import com.sdk.ads.SdkAppController;

public class one_Controller extends SdkAppController {

    private static Context context;
    private static one_Controller mInstance;


    public Activity activity;
    public int width = 720;


    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        context = getApplicationContext();
    }

    public static synchronized one_Controller getInstance() {
        return mInstance;
    }
}
