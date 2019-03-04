package com.example.ruthelpc.traplare;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecyclerInterface {
    String JSONURL = "https://lototototo.000webhostapp.com/traplare/";

    @GET("display_voyages.php")
    Call<String> getString();
}
