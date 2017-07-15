package com.example.nilton.proyecto_movil_2017;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.Adaptador.LVMainAdapter;
import com.example.beans.ActivoBean;
import com.example.beans.UsuarioBean;
import com.example.dao.ActivoDAO;

import java.util.ArrayList;

public class ListadoActivosActivity extends AppCompatActivity implements View.OnClickListener{
        FloatingActionButton btnnuevo;
        ListView lstactivos;
        LVMainAdapter mLVMainAdapter;

    private void iniciaComponentes(){
        btnnuevo = (FloatingActionButton) findViewById(R.id.btnNuevoActivo);
        lstactivos = (ListView)findViewById(R.id.lstActivos);

        btnnuevo.setOnClickListener(this);
    }

    private void cargarActivos(){
        ActivoDAO dao = new ActivoDAO(this);
        ArrayList<ActivoBean> activos = dao.listado();

        mLVMainAdapter = new LVMainAdapter(ListadoActivosActivity.this);
        lstactivos.setAdapter(mLVMainAdapter);

        mLVMainAdapter.addAll(activos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_activos);
        iniciaComponentes();
        cargarActivos();
    }

    @Override
    public void onClick(View v) {
        if(v== btnnuevo){
            Intent ir = new Intent(this, ConsultasActivosActivity.class);
            startActivity(ir);
        }
    }
}
