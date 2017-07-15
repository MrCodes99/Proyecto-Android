package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beans.ResponsableBean;
import com.example.conexion.MiConexion;

import java.util.ArrayList;

/**
 * Created by Nilton on 24/06/2017.
 */

public class ResponableDAO {
    // Definimos el contexto
    Context contexto;

    // Definimos el construtor para el contexto creado
    public ResponableDAO(Context ctx){contexto=ctx;}

    // Definimos el metodo para Listar
    public ArrayList<ResponsableBean> listado(){
        ArrayList<ResponsableBean> responsable = new ArrayList<ResponsableBean>();
        // definimos la conexion
        MiConexion con = new MiConexion(contexto, null, null, 1);
        SQLiteDatabase db = con.getReadableDatabase();
        Cursor cur =db.rawQuery("SELECT * FROM Tb_Responsable", new String[]{});
        ResponsableBean bean;

        while(cur.moveToNext()){
            bean = new ResponsableBean();
            bean.setCod_resp(cur.getInt(0));
            bean.setNom_resp(cur.getString(1));
            bean.setApe_resp(cur.getString(2));
            bean.setSexo_resp(cur.getString(3));
            bean.setDni(cur.getString(4));
            bean.setTel_resp(cur.getString(5));
            responsable.add(bean);
        }
        return responsable;
    }

}
