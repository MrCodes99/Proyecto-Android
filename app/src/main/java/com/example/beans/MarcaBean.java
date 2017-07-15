package com.example.beans;

/**
 * Created by Nilton on 24/06/2017.
 */

public class MarcaBean {
    // Definimos los atributos para la tabla Tb_Marca
    private int cod_marca;
    private String descrip_marca;
    private String modelo;

    public String toString() {return descrip_marca+ " " +modelo;}

    public int getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(int cod_marca) {
        this.cod_marca = cod_marca;
    }

    public String getDescrip_marca() {
        return descrip_marca;
    }

    public void setDescrip_marca(String descrip_marca) {
        this.descrip_marca = descrip_marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    }
