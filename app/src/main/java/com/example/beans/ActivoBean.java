package com.example.beans;

/**
 * Created by Nilton on 23/06/2017.
 */

public class ActivoBean {
    // Agregar
    private String cod_activo;
    private String tipo_activo;
    private String fechacompra;
    private int serie;
    private String placa;
    private String estado;
    private int codigobarras;
    private int cod_marca;
    private int cod_resp;
    private int cod_prov;

    public String toString(){return cod_activo+ " "+tipo_activo+" "+fechacompra+" "+serie+" "+placa+" "+estado+" "+codigobarras+" "+
    cod_marca+ " "+cod_resp+" "+cod_prov;}

    public String getCod_activo() {
        return cod_activo;
    }

    public void setCod_activo(String cod_activo) {
        this.cod_activo = cod_activo;
    }

    public String getTipo_activo() {
        return tipo_activo;
    }

    public void setTipo_activo(String tipo_activo) {
        this.tipo_activo = tipo_activo;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(int codigobarras) {
        this.codigobarras = codigobarras;
    }

    public int getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(int cod_marca) {
        this.cod_marca = cod_marca;
    }

    public int getCod_resp() {
        return cod_resp;
    }

    public void setCod_resp(int cod_resp) {
        this.cod_resp = cod_resp;
    }

    public int getCod_prov() {
        return cod_prov;
    }

    public void setCod_prov(int cod_prov) {
        this.cod_prov = cod_prov;
    }
}
