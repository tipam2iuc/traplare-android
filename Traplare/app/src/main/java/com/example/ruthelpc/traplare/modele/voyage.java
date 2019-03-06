package com.example.ruthelpc.traplare.modele;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class voyage {


    public voyage(Date date_depart, Date date_arrivee,
                  double tarif, String depart, String destination,
                  String compagnie, String classe) {
        this.date_depart = date_depart;
        this.date_arrivee = date_arrivee;
        this.tarif = tarif;
        this.depart = depart;
        this.destination = destination;
        this.compagnie = compagnie;
        this.classe = classe;
    }

    public int id;
    @SerializedName("date_depart")
    public Date date_depart;
    @SerializedName("date_arrivee")
    public Date date_arrivee;
    @SerializedName("tarif")
    public double tarif;
    @SerializedName("depart")
    public String depart;
    @SerializedName("destination")
    public String destination;
    @SerializedName("compagnie")
    public String compagnie;
    @SerializedName("classe")
    public String classe;
}
