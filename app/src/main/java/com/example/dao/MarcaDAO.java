package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beans.MarcaBean;
import com.example.conexion.MiConexion;

import java.util.ArrayList;

/**
 * Created by Nilton on 24/06/2017.
 */

public class MarcaDAO {
    // Definimos el contexto
    Context contexto;

    public MarcaDAO(Context ctx){contexto=ctx;}

    // Definimos el metodo para listar
    public ArrayList<MarcaBean> Listado(){
        ArrayList<MarcaBean> marca = new ArrayList<MarcaBean>();
        // Definimos la conexion
        MiConexion con = new MiConexion(contexto, null, null, 1);
        SQLiteDatabase sql = con.getReadableDatabase();
       Cursor cur =sql.rawQuery("SELECT * FROM Tb_Marca", new String[]{});
        MarcaBean bean = null;
        while(cur.moveToNext()){
            bean = new MarcaBean();
            bean.setCod_marca(cur.getInt(0));
            bean.setDescrip_marca(cur.getString(1));
            bean.setModelo(cur.getString(2));
            marca.add(bean);
        }
        return marca;
    }
}
