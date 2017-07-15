package com.example.beans;

/**
 * Created by Nilton on 03/07/2017.
 */

public class UsuarioBean {

    private String cod_usuario;
    private String nom_usuario;
    private String ape_usuario;
    private String tip_usuario;
    private String email_usuario;
    private String pwd_usuario;
    private String id_cargo;

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getApe_usuario() {
        return ape_usuario;
    }

    public void setApe_usuario(String ape_usuario) {
        this.ape_usuario = ape_usuario;
    }

    public String getTip_usuario() {
        return tip_usuario;
    }

    public void setTip_usuario(String tip_usuario) {
        this.tip_usuario = tip_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getPwd_usuario() {
        return pwd_usuario;
    }

    public void setPwd_usuario(String pwd_usuario) {
        this.pwd_usuario = pwd_usuario;
    }

    public String getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }
}
