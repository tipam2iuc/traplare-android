package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

public class user_reservation {
    @SerializedName("nom_user")
    private String nom_user;
    @SerializedName("nom")
    private String nom;

    @SerializedName("prenom_user")
    private String prenom_user;
    @SerializedName("prenom")
    private String prenom;

    @SerializedName("cni")
    private  String cni;

    @SerializedName("username")
    private  String username;

    @SerializedName("idvoyage")
    private  int idvoyage;

    @SerializedName("date_reservation")
    private String date_reservation;

    @SerializedName("telephone_user")
    private String telephone_user;

    @SerializedName("email")
    private String email;

    @SerializedName("telephone")
    private String telephone;

    @SerializedName("code")
    private String code;

    public String getNom() {
        return nom;
    }
    public String getNom_user() {
        return nom_user;
    }
    public String getPrenom_user() {
        return prenom_user;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getDate_reservation() {
        return date_reservation;
    }
    public String getCni() {
        return cni;
    }
    public int getIdvoyage() {
        return idvoyage;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getCode() {
        return code;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getTelephone_user() {
        return telephone_user;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setCni(String cni) {
        this.cni = cni;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNom_user(String nom) {
        this.nom_user = nom;
    }
    public void setIdvoyage(int idvoyage) {
        this.idvoyage = idvoyage;
    }


    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @SerializedName("message")
    private String message;

    @SerializedName("success")
    private String success;





}
