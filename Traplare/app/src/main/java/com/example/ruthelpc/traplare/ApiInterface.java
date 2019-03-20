package com.example.ruthelpc.traplare;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("controlleur/register.php")
    Call<client> register(
            @Field("username_cli") String username,
            @Field("telephone_cli") String telephone,
            @Field("mot_de_passe") String mot_de_passe
    );

    @FormUrlEncoded
    @POST("add_reservation.php")
    Call<Reservation> reservation
            (
                    @Field("idvoyage") int idvoyage ,
                    @Field("iduser") int iduser ,
                    @Field("date_reservation") String date_reservation ,
                    @Field("cni") String cni,
                    @Field("prenom") String prenom ,
                    @Field("nom") String nom ,
                    @Field("telephone") String telephone
            );

    @FormUrlEncoded
    @POST("controlleur/login.php")
    Call<client> login(
            @Field("telephone_cli") String telephone_cli,
            @Field("mot_de_passe") String password
    );

    //@FormUrlEncoded
    @POST("controlleur/travels_list.php")
    Call<List<Voyage>>getVoyage();
}
