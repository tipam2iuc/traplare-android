package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Voyage {
    @SerializedName("compagnie")
    private String compagnie;
    @SerializedName("id")
    private int id;
    @SerializedName("message")
    private String message;
    @SerializedName("depart")
    private String depart;
    @SerializedName("destination")
    private String destination;
    @SerializedName("date_depart")
    private String date_depart;
    @SerializedName("date_arrivee")
    private String date_arrivee;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());

    @SerializedName("tarif")
    private double tarif;
    @SerializedName("class")
    private String classe;



    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }
    public int getId() {
        return id;
    }
    public void setDepart(int id) {
        this.id = id;
    }
    public double getTarif() {return tarif;}
    public void setTarif(double tarif) {this.tarif = tarif;}
    public String getClasse() {return classe;}
    public void setClasse(String classe) {this.classe = classe;}
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public java.util.Date getDate_depart() {
        try {
            return sdf.parse(date_depart);
        } catch (ParseException e) {
        }
        return null;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public java.util.Date getDate_arrivee() {
        try {
            return sdf.parse(date_arrivee);
        } catch (ParseException e) {
        }
        return null;
    }

    public void setDate_arrivee(String date_arrivee) {
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
