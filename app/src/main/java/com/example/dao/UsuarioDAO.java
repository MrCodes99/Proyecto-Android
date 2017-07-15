package com.example.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.beans.UsuarioBean;
import com.example.conexion.MiConexion;

/**
 * Created by Nilton on 03/07/2017.
 */

public class UsuarioDAO {
    Context contexto;

     public UsuarioDAO(Context ctx){contexto=ctx;}

    // Definimos metodo Login para acceder al Activity principal
    public UsuarioBean Login(String email_usuario, String pwd_usuario){
        UsuarioBean bean = null;
        MiConexion con = new MiConexion(contexto, null, null, 1);
        SQLiteDatabase sql = con.getReadableDatabase();
        Cursor cur = sql.rawQuery("SELECT * FROM Tb_Usuario where email_usuario=? and pwd_usuario=?",
                new String[]{email_usuario, pwd_usuario});

        if(cur.moveToNext()){
            bean = new UsuarioBean();
            bean.setId_cargo(cur.getString(0));
            bean.setNom_usuario(cur.getString(1));
            bean.setApe_usuario(cur.getString(2));
            bean.setTip_usuario(cur.getString(3));
            bean.setEmail_usuario( cur.getString(4));
            bean.setPwd_usuario(cur.getString(5));
            bean.setId_cargo(cur.getString(6));

        }
        return bean;
    }

    // Definimos metodo para buscar por un parametro
    public UsuarioBean Buscar(String cod_usuario){
        UsuarioBean bean = null;
        MiConexion con = new MiConexion(contexto, null, null, 1);
        SQLiteDatabase sql = con.getReadableDatabase();
        Cursor cur = sql.rawQuery("SELECT * FROM Tb_Usuario where cod_usuario=?",
                new String[]{cod_usuario});

        if(cur.moveToNext()){
            bean = new UsuarioBean();
            bean.setId_cargo(cur.getString(0));
            bean.setNom_usuario(cur.getString(1));
            bean.setApe_usuario(cur.getString(2));
            bean.setTip_usuario(cur.getString(3));
            bean.setEmail_usuario( cur.getString(4));
            bean.setPwd_usuario(cur.getString(5));
            bean.setId_cargo(cur.getString(6));
        }
        return bean;
    }
}
