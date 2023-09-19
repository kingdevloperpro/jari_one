package com.jahir.fast.one.MykeepClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SettingInterface {

    @GET("getApps/jahir-it-park/chatai_one/asfdgsg26df/setting.json")
    Call<Setting> getSetting();
}