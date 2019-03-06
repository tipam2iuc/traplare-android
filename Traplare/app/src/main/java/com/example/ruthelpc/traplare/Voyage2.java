package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Voyage2 {
    @SerializedName("compagnie")
    private String compagnie;
    @SerializedName("message")
    private String message;

    @SerializedName("depart")
    private String depart;

    @SerializedName("destination")
    private String destination;
    @SerializedName("date_depart")
    private Date date_depart;
    @SerializedName("date_arrivee")
    private Date date_arrivee;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

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
