package com.sdk.ads.client;

import com.sdk.ads.ResModel.MainResModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("getApps/jahir-it-park/chatai_one/asfdgsg26df/getData.json")
    Call<MainResModel> doGetListData();

    @GET("getApps/jahir-it-park/chatai_one/asfdgsg26df/getData2.json")
    Call<MainResModel> doGetListData2();

    @GET("getApps/jahir-it-park/chatai_one/asfdgsg26df/getData.json")
    Call<MainResModel> doGetListData_Def();

}
