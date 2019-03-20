package com.example.ruthelpc.traplare;

import com.google.gson.annotations.SerializedName;

public class client_connected {
    public client_connected(String username_cli,
                            String prenom_cli,
                            String nom_cli,
                            String cni_cli,
                            String email_cli,
                            String telephone_cli,
                            String photo_cli,
                            String mot_de_passe_cli) {
        this.username_cli = username_cli;
        this.prenom_cli = prenom_cli;
        this.nom_cli = nom_cli;
        this.cni_cli = cni_cli;
        this.email_cli = email_cli;
        this.telephone_cli = telephone_cli;
        this.photo_cli = photo_cli;
        this.mot_de_passe_cli = mot_de_passe_cli;
    }

    public String getUsername_cli() {
        return username_cli;
    }

    public void setUsername_cli(String username_cli) {
        this.username_cli = username_cli;
    }

    public String getPrenom_cli() {
        return prenom_cli;
    }

    public void setPrenom_cli(String prenom_cli) {
        this.prenom_cli = prenom_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public String getCni_cli() {
        return cni_cli;
    }

    public void setCni_cli(String cni_cli) {
        this.cni_cli = cni_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    public String getTelephone_cli() {
        return telephone_cli;
    }

    public void setTelephone_cli(String telephone_cli) {
        this.telephone_cli = telephone_cli;
    }

    public String getPhoto_cli() {
        return photo_cli;
    }

    public void setPhoto_cli(String photo_cli) {
        this.photo_cli = photo_cli;
    }

    public String getMot_de_passe_cli() {
        return mot_de_passe_cli;
    }

    public void setMot_de_passe_cli(String mot_de_passe_cli) {
        this.mot_de_passe_cli = mot_de_passe_cli;
    }

    private String username_cli;
    private String prenom_cli;
    private String nom_cli;
    private String cni_cli;
    private String email_cli;
    private String telephone_cli;
    private String photo_cli;
    private String mot_de_passe_cli;
}
