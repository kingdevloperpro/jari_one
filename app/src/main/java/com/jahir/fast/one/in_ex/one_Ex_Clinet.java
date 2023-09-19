package com.jahir.fast.one.in_ex;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class one_Ex_Clinet {

    public static final String BASE_URL = "http://ip-api.com/";

    public static one_Ex_Serc getGeoApiService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(one_Ex_Serc.class);
    }

}
