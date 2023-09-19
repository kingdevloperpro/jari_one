package com.jahir.fast.one.in_ex;

import retrofit2.Call;
import retrofit2.http.GET;

public interface one_Ex_Serc {
    @GET("json")
    Call<one_Ex_Res> getLocation();
}