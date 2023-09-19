package com.jahir.fast.one.one_Utils;


import android.content.Context;
import android.content.SharedPreferences;

public class one__SP_Pref {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String FirstTimeswipe = "FirstTimeswipe";
    String ADSShowPosition = "ADSShowPosition";

    public one__SP_Pref(Context context) {

        sharedPreferences = context.getSharedPreferences("AdsKeyStore", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public boolean getFirstTimeswipe() {
        return sharedPreferences.getBoolean(FirstTimeswipe, false);
    }

    public void setFirstTimeswipe(boolean firsttime) {
        editor.putBoolean(FirstTimeswipe, firsttime).apply();
    }

    public int getADSShowPosition() {
        return sharedPreferences.getInt(ADSShowPosition, 0);
    }

    public void setADSShowPosition(int ADSShowPositionn) {
        editor.putInt(ADSShowPosition, ADSShowPositionn).apply();
    }

}
