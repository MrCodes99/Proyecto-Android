package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beans.ActivoBean;
import com.example.conexion.MiConexion;

import java.util.ArrayList;

/**
 * Created by Nilton on 23/06/2017.
 */


public class ActivoDAO {
    // Definimos el contexto
    Context contexto;

    // definimos un metodo que nos devuelva el contexto
    public ActivoDAO(Context ctx){contexto=ctx;}

    // Definimos el metodo para buscar por parametro codigo
    public ActivoBean BuscarActivos (String cod_activo){
        ActivoBean bean = null;
        // Definimos la conexion
        MiConexion con = new MiConexion(contexto, null, null, 1);
        SQLiteDatabase sql = con.getReadableDatabase();
        Cursor cur = sql.rawQuery("SELECT * FROM Tb_Activos where cod_activo=?",
                new String[]{cod_activo});

        if(cur.moveToNext()){
            bean = new ActivoBean();
            bean.setCod_activo(cur.getString(0));
            bean.setTipo_activo(cur.getString(1));
            bean.setFechacompra(cur.getString(2));
            bean.setSerie(cur.getInt(3));
            bean.setPlaca(cur.getString(4));
            bean.setEstado(cur.getString(5));
            bean.setCodigobarras(cur.getInt(6));
            bean.setCod_marca(cur.getInt(7));
            bean.setCod_resp(cur.getInt(8));
            bean.setCod_prov(cur.getInt(9));
        }
        return bean;
    }
    // Definimos el metodo para listar
    public ArrayList<ActivoBean> listado(){
        ArrayList<ActivoBean> activos = new ArrayList<ActivoBean>();
        ActivoBean bean = null;
        MiConexion cn = new MiConexion(contexto, null, null,1);//
        SQLiteDatabase sql = cn.getReadableDatabase();
        Cursor cur = sql.rawQuery("select * from Tb_Activos",
                new String[]{});
        while(cur.moveToNext()){
            bean = new ActivoBean();
            bean.setCod_activo(cur.getString(0));
            bean.setTipo_activo(cur.getString(1));
            bean.setFechacompra(cur.getString(2));
            bean.setSerie(cur.getInt(3));
            bean.setPlaca(cur.getString(4));
            bean.setEstado(cur.getString(5));
            bean.setCodigobarras(cur.getInt(6));
            bean.setCod_marca(cur.getInt(7));
            bean.setCod_resp(cur.getInt(8));
            bean.setCod_prov(cur.getInt(9));
            activos.add(bean);
        }
        return activos;
    }

    // Metodo para grabar el Activo
    public int GrabarActivo(ActivoBean reg){
        int resultado;
        try{
            MiConexion con = new MiConexion(contexto, null, null, 1);
            SQLiteDatabase sql = con.getWritableDatabase();
            sql.execSQL("INSERT INTO Tb_Activos VALUES(?,?,?,?,?,?,?,?,?,?)",
                    new Object[]{reg.getCod_activo(),
                            reg.getTipo_activo(),
                            reg.getFechacompra(),
                            reg.getSerie(),
                            reg.getPlaca(),
                            reg.getEstado(),
                            reg.getCodigobarras(),
                            reg.getCod_marca(),
                            reg.getCod_resp(),
                            reg.getCod_prov()});
            resultado=1;
        }catch(Exception e){
            resultado =-1;
        }
        return resultado;
    }

    // metodo para actualizar los activos
    public int ActualizarActivo(ActivoBean reg){
        int resultado;
        try{
            MiConexion con = new MiConexion(contexto, null, null, 1);
            SQLiteDatabase sql = con.getWritableDatabase();
            sql.execSQL("UPDATE Tb_Activos set tipo_activo=?, fechacompra=?, serie=?, placa=?, estado=?," +
                    "codigobarra=?, cod_marca=?, cod_resp=?, cod_prov=? where cod_activo=?",
                    new Object[]{reg.getTipo_activo(),
                            reg.getFechacompra(),
                            reg.getSerie(),
                            reg.getPlaca(),
                            reg.getEstado(),
                            reg.getCodigobarras(),
                            reg.getCod_marca(),
                            reg.getCod_resp(),
                            reg.getCod_prov(),
                            reg.getCod_activo()});
            resultado=1;

        }catch(Exception e){
            resultado =-1;
        }
        return resultado;
    }
}
