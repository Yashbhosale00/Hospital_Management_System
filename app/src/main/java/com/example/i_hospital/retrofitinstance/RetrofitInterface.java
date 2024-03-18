package com.example.i_hospital.retrofitinstance;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface{
    @FormUrlEncoded
    @GET("Webservice.asmx/CheckLoginUser")
    Call<String> checkLoginUser(
            @Query("Username") String username,
            @Query("Password") String password,
            @Query("role") String role
    );
}
