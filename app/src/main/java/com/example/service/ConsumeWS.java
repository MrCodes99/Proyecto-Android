package com.example.service;

import com.example.beans.ActivoBean;

import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ConsumeWS {
    public String Grabar(String cod,String nom){
        String res="";
        try {
//click derecho // add as a library
            SoapObject soap = new SoapObject("http://services.edu.cibertec","Grabar");

            soap.addProperty("cod",cod);
            soap.addProperty("nom",nom);

            SoapSerializationEnvelope envelope=
                    new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.bodyOut =soap;
            envelope.dotNet=true;
            envelope.encodingStyle =SoapSerializationEnvelope.XSD;

            HttpTransportSE transporte=null;
            try{
                String URL="http://10.0.2.2:8080/Semana12MI/services/MiServicio?wsdl";
                transporte = new HttpTransportSE(URL);
                transporte.debug=true;
                transporte.call("http://services.edu.cibertec/Grabar",envelope);
                res=envelope.getResponse().toString();
            }catch(Exception e){
                res = e.getMessage();
            }
        }catch (Exception e ){
            res = e.getMessage();
        }
        return res;
    }
    public ArrayList<ActivoBean> ListarActivo(){
        ArrayList<ActivoBean> activos=new ArrayList<ActivoBean>();
        try {
//click derecho // add as a library
            SoapObject soap = new SoapObject("http://services.edu.cibertec","ListarActivo");


            SoapSerializationEnvelope envelope=
                    new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.bodyOut =soap;
            envelope.dotNet=true;
            envelope.encodingStyle =SoapSerializationEnvelope.XSD;

            HttpTransportSE transporte=null;
            try{
                String URL="http://10.0.2.2:8080/Semana12MI/services/MiServicio?wsdl";
                transporte = new HttpTransportSE(URL);
                transporte.debug=true;
                transporte.call("http://services.edu.cibertec/ListarActivo",envelope);
                SoapObject tabla=(SoapObject)envelope.bodyIn;
                SoapObject row;
                ActivoBean bean;
                for(int i=0; i<tabla.getPropertyCount();i++){
                    row = (SoapObject)tabla.getProperty(i);
                    bean=new ActivoBean();
                    bean.setCod_activo(row.getProperty("cod_activo").toString());// es el nombre del arreglo que te devuelve el webservice
                    bean.setTipo_activo(row.getProperty("cod_activo").toString()); // Falta los demas campos
                    // bean.setIdCargo(Integer.parseInt(row.getProperty()
                    activos.add(bean);
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return activos;
    }


}
