package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Voyage {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @SerializedName("agence_depart") private String agence_depart;
    @SerializedName("id_voy") private int id_voy;
    @SerializedName("agence_arrivee") private String agence_arrivee;
    @SerializedName("ville_depart") private String ville_depart;
    @SerializedName("ville_arrive") private String ville_arrive;
    @SerializedName("date_debut_voy") private String date_debut_voy;
    @SerializedName("date_arrivee_voy") private String date_arrivee_voy;
    @SerializedName("prix_voy") private double prix_voy;
    @SerializedName("nom_chauffeur") private String nom_chauffeur;
    @SerializedName("nom_hotesse") private String nom_hotesse;
    @SerializedName("pos_chauffeur") private String pos_chauffeur;
    @SerializedName("pos_hotesse") private String pos_hotesse;
    @SerializedName("categorie_cla") private String categorie_cla;
    @SerializedName("num_age") private String num_age;
    @SerializedName("telephone_age") private String telephone_age;
    @SerializedName("nom_com") private String nom_com;
    @SerializedName("siege_com") private String siege_com;
    @SerializedName("matricule_bus") private String matricule_bus;
    @SerializedName("nbr_siege_bus") private String nbr_siege_bus;
    @SerializedName("place_disponible") private String place_disponible;
    @SerializedName("logo_com")  private  String logo_com;

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String getLogo_com() {
        return logo_com;
    }

    public void setLogo_com(String logo_com) {
        this.logo_com = logo_com;
    }

    public String getCategorie_cla() {
        return categorie_cla;
    }

    public void setCategorie_cla(String categorie_cla) {
        this.categorie_cla = categorie_cla;
    }

    public int getId_voy() {
        return id_voy;
    }

    public void setId_voy(int id_voy) {
        this.id_voy = id_voy;
    }

    public String getAgence_depart() {
        return agence_depart;

    }

    public void setAgence_depart(String agence_depart) {
        this.agence_depart = agence_depart;
    }

    public String getAgence_arrivee() {
        return agence_arrivee;
    }

    public void setAgence_arrivee(String agence_arrivee) {
        this.agence_arrivee = agence_arrivee;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrive() {
        return ville_arrive;
    }

    public void setVille_arrive(String ville_arrive) {
        this.ville_arrive = ville_arrive;
    }

    public Date getDate_debut_voy() {
        try {
            return sdf.parse(date_debut_voy);
        } catch (ParseException e) {
            return null;
        }
    }

    public void setDate_debut_voy(String date_debut_voy) {
        this.date_debut_voy = date_debut_voy;
    }

    public Date getDate_arrivee_voy(){
        try {
            return sdf.parse(date_arrivee_voy);
        } catch (ParseException e) {
            return null;
        }
    }

    public void setDate_arrivee_voy(String date_arrivee_voy) {
        this.date_arrivee_voy = date_arrivee_voy;
    }

    public double getPrix_voy() {
        return prix_voy;
    }

    public void setPrix_voy(double prix_voy) {
        this.prix_voy = prix_voy;
    }

    public String getNom_chauffeur() {
        return nom_chauffeur;
    }

    public void setNom_chauffeur(String nom_chauffeur) {
        this.nom_chauffeur = nom_chauffeur;
    }

    public String getNom_hotesse() {
        return nom_hotesse;
    }

    public void setNom_hotesse(String nom_hotesse) {
        this.nom_hotesse = nom_hotesse;
    }

    public String getPos_chauffeur() {
        return pos_chauffeur;
    }

    public void setPos_chauffeur(String pos_chauffeur) {
        this.pos_chauffeur = pos_chauffeur;
    }

    public String getPos_hotesse() {
        return pos_hotesse;
    }

    public void setPos_hotesse(String pos_hotesse) {
        this.pos_hotesse = pos_hotesse;
    }

    public String getNum_age() {
        return num_age;
    }

    public void setNum_age(String num_age) {
        this.num_age = num_age;
    }

    public String getTelephone_age() {
        return telephone_age;
    }

    public void setTelephone_age(String telephone_age) {
        this.telephone_age = telephone_age;
    }

    public String getNom_com() {
        return nom_com;
    }

    public void setNom_com(String nom_com) {
        this.nom_com = nom_com;
    }

    public String getSiege_com() {
        return siege_com;
    }

    public void setSiege_com(String siege_com) {
        this.siege_com = siege_com;
    }

    public String getMatricule_bus() {
        return matricule_bus;
    }

    public void setMatricule_bus(String matricule_bus) {
        this.matricule_bus = matricule_bus;
    }

    public String getNbr_siege_bus() {
        return nbr_siege_bus;
    }

    public void setNbr_siege_bus(String nbr_siege_bus) {
        this.nbr_siege_bus = nbr_siege_bus;
    }

    public String getPlace_disponible() {
        return place_disponible;
    }

    public void setPlace_disponible(String place_disponible) {
        this.place_disponible = place_disponible;
    }
}