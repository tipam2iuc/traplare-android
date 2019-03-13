package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

public class user_reservation {
    @SerializedName("nom")
    private String nom;
    @SerializedName("cni")
    private  String cni;
    @SerializedName("username")
    private  String username;

    @SerializedName("password")
    private  String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SerializedName("idvoyage")
    private  int idvoyage;
    @SerializedName("date_reservation")
    private String date_reservation;

    @SerializedName("telephone")
    private String telephone;

    @SerializedName("code")
    private String code;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdvoyage() {
        return idvoyage;
    }

    public void setIdvoyage(int idvoyage) {
        this.idvoyage = idvoyage;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
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
