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
            @Field("nom_cli") String nom,
            @Field("prenom_cli") String prenom,
            @Field("cni_cli") String cni,
            @Field("email_cli") String email,
            @Field("telephone_cli") String telephone,
            @Field("photo_cli") String photo,
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
            @Field("username_cli") String username,
            @Field("mot_de_passe") String password
    );

    //@FormUrlEncoded
    @POST("display_voyages.php")
    Call<List<Voyage>>getVoyage2();
}
