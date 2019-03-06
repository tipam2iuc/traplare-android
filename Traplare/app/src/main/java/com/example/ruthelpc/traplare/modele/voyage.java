package com.example.ruthelpc.traplare.modele;

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
    public Date date_depart;
    public Date date_arrivee;
    public double tarif;
    public String depart;
    public String destination;
    public String compagnie;
    public String classe;
}
