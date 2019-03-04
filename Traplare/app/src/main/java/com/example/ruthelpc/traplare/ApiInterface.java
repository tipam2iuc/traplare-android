package com.example.ruthelpc.traplare;

import android.app.TimePickerDialog;
import android.util.JsonReader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("inscription.php")
    Call<users> inscription(
            @Field("username") String username,
            @Field("name") String name,
            @Field("cni") String cni,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<users> login(
            @Field("username") String username,
            @Field("password") String password
    );

    //@FormUrlEncoded
    @POST("display_voyages.php")
    Call< List<Voyage2>>getVoyage2();
}
