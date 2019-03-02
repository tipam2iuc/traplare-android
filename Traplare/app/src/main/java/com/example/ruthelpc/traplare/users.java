package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

public class users {

    @SerializedName("username")
    private String username;
    @SerializedName("name")
    private String name;
    @SerializedName("cni")
    private String cni;
    @SerializedName("password")
    private String password;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private String success;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
