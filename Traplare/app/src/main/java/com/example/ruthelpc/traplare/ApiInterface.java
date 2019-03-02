package com.example.ruthelpc.traplare;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/inscription.php")
    Call<users> inscription(
            @Field("username") String username,
            @Field("name") String name,
            @Field("cni") String cni,
            @Field("password") String password
    );
}
