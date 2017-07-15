package com.example.beans;

/**
 * Created by Nilton on 24/06/2017.
 */

public class ResponsableBean {

    // Declaramos los atributos para la tabla reponsable
    private int cod_resp;
    private String nom_resp;
    private String ape_resp;
    private String sexo_resp;
    private String dni;
    private String tel_resp;

    public String toString(){
        return nom_resp;
    }

    public int getCod_resp() {
        return cod_resp;
    }

    public void setCod_resp(int cod_resp) {
        this.cod_resp = cod_resp;
    }

    public String getNom_resp() {
        return nom_resp;
    }

    public void setNom_resp(String nom_resp) {
        this.nom_resp = nom_resp;
    }

    public String getApe_resp() {
        return ape_resp;
    }

    public void setApe_resp(String ape_resp) {
        this.ape_resp = ape_resp;
    }

    public String getSexo_resp() {
        return sexo_resp;
    }

    public void setSexo_resp(String sexo_resp) {
        this.sexo_resp = sexo_resp;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTel_resp() {
        return tel_resp;
    }

    public void setTel_resp(String tel_resp) {
        this.tel_resp = tel_resp;
    }
}
