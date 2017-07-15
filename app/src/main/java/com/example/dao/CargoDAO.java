package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beans.CargoBean;
import com.example.conexion.MiConexion;

import java.util.ArrayList;

/**
 * Created by Nilton on 03/07/2017.
 */

public class CargoDAO {
    Context contexto;

    public CargoDAO (Context ctx){contexto=ctx;}

    // Definimos el metodo para listar Cargo
    public ArrayList<CargoBean> listadoCargo(){
        ArrayList<CargoBean> cargos = new ArrayList<CargoBean>();

        MiConexion con = new MiConexion(contexto, null,null,1);
        SQLiteDatabase db = con.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM Tb_Cargo", null);
        CargoBean bean;
        while(cur.moveToNext()){
            bean = new CargoBean();
            bean.setId_cargo(cur.getString(0));
            bean.setNom_cargo(cur.getString(1));
            cargos.add(bean);
        }
        return cargos;
    }
}
