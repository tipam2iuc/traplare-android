package com.example.ruthelpc.traplare.modele;

import java.util.Date;

public class voyage {
    enum classe{
        VIP,
        NORMAL,
        ECONOMIQUE
    }


    public Date date_depart;
    public Date date_arrivee;
    public double tarif;
    public agence agence_depart;
    public String depart;
    public String destination;
    public agence agence_arrive;
    public classe classe;



    public voyage(String destination, String depart){
        this.depart = depart;
        this.destination = destination;
    }
}
