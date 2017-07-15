package com.example.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nilton on 23/06/2017.
 */

public class MiConexion extends SQLiteOpenHelper {
    public MiConexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "DBProyecto8", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //---- Tabla Cargo
        String TABLA_CARGO ="create table Tb_Cargo(id_cargo text, nom_cargo text);";
        db.execSQL(TABLA_CARGO);
        db.execSQL("insert into Tb_Cargo values('C001','Gerente');");
        db.execSQL("insert into Tb_Cargo values('C002','Administrador');");

        //---- Tabla Usuario
        String TABLA_USUARIO="create table Tb_Usuario(cod_usuario text, nom_usuario text, ape_usuario text, tip_usuario text," +
                "email_usuario text, pwd_usuario text, id_cargo text);";
        db.execSQL(TABLA_USUARIO);
        db.execSQL("insert into Tb_Usuario values('U001','Nilton','Ramos Inocente','Proveedor','nilton20@gmail.com','nilton1234','C001');");
        db.execSQL("insert into Tb_Usuario values('U002','Michell','Ramirez','Proveedor','michellrq25@gmail.com','12345','C001');");

        //--- Tabla Marca
        String TABLA_MARCA="create table Tb_Marca(cod_marca integer, descrip_marca text, modelo text);";
        db.execSQL(TABLA_MARCA);
        db.execSQL("insert into Tb_Marca values(1111, 'Toyota', 'Fortuner');");
        db.execSQL("insert into Tb_Marca values(2222, 'Cargador Frontal', 'Grove');");
        db.execSQL("insert into Tb_Marca values(2223, 'Agua', 'Mineral');");

        //--- Tabla Responsable
        String TABLA_RESPONSABLE ="create table Tb_Responsable(cod_resp integer, nom_resp text, ape_resp text, sexo_resp text," +
                " dni text, tel_resp text);";
        db.execSQL(TABLA_RESPONSABLE);
        db.execSQL("insert into Tb_Responsable values(3333,'Richard','Lopez','Masculino','47567898','989878767');");

        //--- Tabla proveedor
        String TABLA__PROVEEDOR="create table Tb_Proveedor(cod_prov integer, nom_prov text, ape_prov text, sexo_prov text," +
                "tel_prov text, correo_prov text);";
        db.execSQL(TABLA__PROVEEDOR);
        db.execSQL("insert into Tb_Proveedor values(4444,'Jose','Leonardo','Masculino','978767878','jose@hotmail.com');");

        //--- Tabla Activos
        String TABLA_ACTIVOS="create table Tb_Activos(cod_activo text, tipo_activo text, fechacompra text," +
                "serie integer, placa text, estado text, codigobarra integer, cod_marca integer, cod_resp integer, cod_prov integer);";
        db.execSQL(TABLA_ACTIVOS);
        db.execSQL("insert into Tb_Activos values('987800087898','Maquinaria','2017-07-15',123456789,'MAE234','Activo','1',1111,3333,4444);");
        db.execSQL("insert into Tb_Activos values('987800087316','Equipos','2017-07-15',10480659,'MP0125','Activo','2',2222,3333,4444);");
        db.execSQL("insert into Tb_Activos values('7750430001858','Equipos','2017-07-15',103456769,'EQA657','Activo','3',2223,3333,4444);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
