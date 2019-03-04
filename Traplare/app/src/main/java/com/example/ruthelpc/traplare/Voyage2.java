package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

public class Voyage2 {
    @SerializedName("compagnie")
    private String compagnie;
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }
}
