package com.jahir.fast.one.one_Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class one__OneTimePref {

    final String USER_PREFS = "USER PREFS";
    SharedPreferences appSharedPref;
    SharedPreferences.Editor prefEditor;

    public boolean getFirTime() {
        return appSharedPref.getBoolean("first", false);
    }

    public void setFirTime(boolean firTime) {
        prefEditor.putBoolean("first", firTime).commit();
    }

    public one__OneTimePref(Context context) {
        appSharedPref = context.getSharedPreferences(USER_PREFS, Activity.MODE_PRIVATE);
        prefEditor = appSharedPref.edit();
    }
}