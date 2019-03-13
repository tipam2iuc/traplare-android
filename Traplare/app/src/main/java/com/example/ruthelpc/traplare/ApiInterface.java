package com.example.ruthelpc.traplare;

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
            @Field("firstname") String firstname,
            @Field("cni") String cni,
            @Field("password") String password,
            @Field("lastname") String lastname,
            @Field("email") String email,
            @Field("phone") String phone
    );

    @FormUrlEncoded
    @POST("add_reservation.php")
    Call<Reservation> reservation
            (
                    @Field("date_reservation") String date_reservation ,
                    @Field("cni") String cni,
                    @Field("prenom") String prenom ,
                    @Field("nom") String nom ,
                    @Field("telephone") String telephone
            );

    @FormUrlEncoded
    @POST("liste_voyage_for_user.php")
    Call<List<user_reservation>> login(
            @Field("username") String username,
            @Field("password") String password
    );

    //@FormUrlEncoded
    @POST("display_voyages.php")
    Call<List<Voyage>>getVoyage2();
}
