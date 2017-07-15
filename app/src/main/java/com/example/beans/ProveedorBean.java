package com.example.beans;

/**
 * Created by Nilton on 24/06/2017.
 */

public class ProveedorBean {

    private int cod_prov;
    private String nom_prov;
    private String ape_prov;
    private String sexo_prov;
    private String tel_prov;
    private String correo_prov;

    public String toString(){return nom_prov;}

    public int getCod_prov() {
        return cod_prov;
    }

    public void setCod_prov(int cod_prov) {
        this.cod_prov = cod_prov;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getApe_prov() {
        return ape_prov;
    }

    public void setApe_prov(String ape_prov) {
        this.ape_prov = ape_prov;
    }

    public String getSexo_prov() {
        return sexo_prov;
    }

    public void setSexo_prov(String sexo_prov) {
        this.sexo_prov = sexo_prov;
    }

    public String getTel_prov() {
        return tel_prov;
    }

    public void setTel_prov(String tel_prov) {
        this.tel_prov = tel_prov;
    }

    public String getCorreo_prov() {
        return correo_prov;
    }

    public void setCorreo_prov(String correo_prov) {
        this.correo_prov = correo_prov;
    }
}
