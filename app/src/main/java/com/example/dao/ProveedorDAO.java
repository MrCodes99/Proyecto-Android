package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beans.ProveedorBean;
import com.example.beans.ResponsableBean;
import com.example.conexion.MiConexion;

import java.util.ArrayList;

/**
 * Created by Nilton on 24/06/2017.
 */

public class ProveedorDAO {
    // Definimos el contexto
    Context contexto;

    // Definimos el construtor para el contexto creado
    public ProveedorDAO(Context ctx) {
        contexto = ctx;
    }

    // Definimos el metodo para Listar
    public ArrayList<ProveedorBean> listado() {
        ArrayList<ProveedorBean> proveedor = new ArrayList<ProveedorBean>();
        // definimos la conexion
        MiConexion con = new MiConexion(contexto, null, null, 1);
        SQLiteDatabase db = con.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM Tb_Proveedor", new String[]{});
        ProveedorBean bean;

        while (cur.moveToNext()) {
            bean = new ProveedorBean();
            bean.setCod_prov(cur.getInt(0));
            bean.setNom_prov(cur.getString(1));
            bean.setApe_prov(cur.getString(2));
            bean.setSexo_prov(cur.getString(3));
            bean.setTel_prov(cur.getString(4));
            bean.setCorreo_prov(cur.getString(5));
            proveedor.add(bean);
        }
        return proveedor;
    }
}