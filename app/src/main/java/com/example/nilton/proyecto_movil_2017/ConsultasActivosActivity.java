package com.example.nilton.proyecto_movil_2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.beans.ActivoBean;
import com.example.beans.MarcaBean;
import com.example.beans.ProveedorBean;
import com.example.beans.ResponsableBean;
import com.example.dao.ActivoDAO;
import com.example.dao.MarcaDAO;
import com.example.dao.ProveedorDAO;
import com.example.dao.ResponableDAO;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class ConsultasActivosActivity extends AppCompatActivity implements View.OnClickListener {

    // Definimos los componentes
    EditText edtcodigoactivo, edtfechacompra, edtserie, edtplaca, edtcodigobarra;
    Spinner spntipoactivo, spnestadoactivo, spnmarca, spnresponsable, spnproveedor;
    Button btnbuscaractivo, btnguardaractivo, btnscanner, btnguardar;

    // Definimos varios metodos publicos ArrayList Marca, proveedor y responsable
    ArrayList<MarcaBean> marcas;
    ArrayList<ResponsableBean> responsables;
    ArrayList<ProveedorBean> proveedores;

    private void iniciaComponentes() {
        edtcodigoactivo = (EditText) findViewById(R.id.edtCodigoActivo);
        spntipoactivo = (Spinner) findViewById(R.id.spnEstadoActivo);
        edtfechacompra = (EditText) findViewById(R.id.edtFechaCompra);
        edtserie = (EditText) findViewById(R.id.edtSerie);
        edtplaca = (EditText) findViewById(R.id.edtPlaca);
        spnestadoactivo = (Spinner) findViewById(R.id.spnEstadoActivo);
        edtcodigobarra = (EditText) findViewById(R.id.edtCodigoBarra);
        spnmarca = (Spinner) findViewById(R.id.spnMarca);
        spnresponsable = (Spinner) findViewById(R.id.spnResponsable);
        spnproveedor = (Spinner) findViewById(R.id.spnProveedor);
        btnbuscaractivo = (Button) findViewById(R.id.btnBuscarActivo);
        btnguardaractivo = (Button) findViewById(R.id.btnGuardarActivo);
        btnscanner = (Button) findViewById(R.id.btnScanner);
        btnguardar = (Button) findViewById(R.id.btnGuardar);

        // Definimos los metodos OnClickListener para los botones buscar y actuaizar activos
        btnbuscaractivo.setOnClickListener(this);
        btnguardaractivo.setOnClickListener(this);
        btnscanner.setOnClickListener(this);
        btnguardar.setOnClickListener(this);
    }

    // Definimos un metodo para cargar datos al Spinner Marca
    private void CargarMarcas() {
        MarcaDAO dao = new MarcaDAO(this);
        marcas = dao.Listado();
        ArrayAdapter<MarcaBean> adaptador =
                new ArrayAdapter<MarcaBean>(this, android.R.layout.simple_list_item_1, marcas);
        spnmarca.setAdapter(adaptador);
    }

    private void CargarResponsable() {
        ResponableDAO dao = new ResponableDAO(this);
        responsables = dao.listado();
        ArrayAdapter<ResponsableBean> adaptador =
                new ArrayAdapter<ResponsableBean>(this, android.R.layout.simple_list_item_1, responsables);
        spnresponsable.setAdapter(adaptador);
    }

    private void CargarProveedores() {
        ProveedorDAO dao = new ProveedorDAO(this);
        proveedores = dao.listado();
        ArrayAdapter<ProveedorBean> adaptador =
                new ArrayAdapter<ProveedorBean>(this, android.R.layout.simple_list_item_1, proveedores);
        spnproveedor.setAdapter(adaptador);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas_activos);
        iniciaComponentes();
        CargarMarcas();
        CargarResponsable();
        CargarProveedores();
    }

    // Declaramos varios metodos para captura las posiciones de los Spinner
    private int getPosition(int cod_marca) {
        int pos = -1;
        for (int i = 0; i < marcas.size(); i++) {
            MarcaBean bean = marcas.get(i);
            //if(bean.getCod_marca().equals("")){
            if (bean.getCod_marca() == cod_marca) {
                pos = i;
                break;
            }

        }
        return pos;
    }

    // Definimos la posicion para capturar el idResponsable y enviarlo a spinner
    private int getPosition1(int cod_resp) {
        int pos1 = -1;
        for (int i = 0; i < responsables.size(); i++) {
            ResponsableBean resp = responsables.get(i);
            //if(resp.getCod_resp().equals("")){
            if (resp.getCod_resp() == cod_resp) {
                pos1 = i;
                break;
            }

        }
        return pos1;
    }

    // Definimos la posicion para capturar el codigo de proveedor para que posicione en el spinner
    private int getPosition2(int cod_prov) {
        int pos2 = -1;
        for (int i = 0; i < proveedores.size(); i++) {
            ProveedorBean prov = proveedores.get(i);
            //if(prov.getCod_prov().equals("")){
            if (prov.getCod_prov() == cod_prov) {
                pos2 = i;
                break;
            }
        }
        return pos2;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

// invoco a la camara para usar como scanner
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanningResult != null) {
            String cod = scanningResult.getContents();
            edtcodigoactivo.setText(cod);
            // codigoScanner = scanningResult.getContents();
            //contentTxt.setText(codigoScanner);

        }

    }

    @Override
    public void onClick(View v) {

        if (v == btnscanner) {
            //Para scanear
            new IntentIntegrator(this).initiateScan();

        }

        if (v == btnbuscaractivo) {
            ActivoDAO dao = new ActivoDAO(this);
            ActivoBean bean = dao.BuscarActivos(edtcodigoactivo.getText().toString());
            if (bean != null) {
                spntipoactivo.setSelected(Boolean.getBoolean(bean.getTipo_activo()));
                edtfechacompra.setText(bean.getFechacompra());
                edtserie.setText(String.valueOf(bean.getSerie()));
                edtplaca.setText(bean.getPlaca());
                spnestadoactivo.setSelected(Boolean.getBoolean(bean.getEstado()));
                edtcodigobarra.setText(String.valueOf(bean.getCodigobarras()));
                int pos = getPosition(bean.getCod_marca());
                spnmarca.setSelection(pos);
                int pos1 = getPosition1(bean.getCod_resp());
                spnproveedor.setSelection(pos1);
                int pos2 = getPosition2(bean.getCod_prov());
                spnresponsable.setSelection(pos2);

            }
        }
        if (v == btnguardaractivo) {
            ActivoDAO dao = new ActivoDAO(this);
            ActivoBean activo = new ActivoBean();
            activo.setCod_activo(edtcodigoactivo.getText().toString());
            activo.setTipo_activo(spnestadoactivo.getSelectedItem().toString());
            activo.setFechacompra(edtfechacompra.getText().toString());
            activo.setSerie(Integer.parseInt(edtserie.getText().toString()));
            activo.setPlaca(edtplaca.getText().toString());
            activo.setEstado(spnestadoactivo.getSelectedItem().toString());
            activo.setCodigobarras(Integer.parseInt(edtcodigobarra.getText().toString()));
            activo.setCod_marca(((MarcaBean) spnmarca.getItemAtPosition(spnmarca.getSelectedItemPosition())).getCod_marca());
            activo.setCod_prov(((ProveedorBean) spnproveedor.getItemAtPosition(spnproveedor.getSelectedItemPosition())).getCod_prov());
            activo.setCod_resp(((ResponsableBean) spnresponsable.getItemAtPosition(spnresponsable.getSelectedItemPosition())).getCod_resp());

            // Definimos el metodo actualizar
            dao.ActualizarActivo(activo);
        }
        if (v == btnguardar) {
            ActivoDAO dao = new ActivoDAO(this);
            ActivoBean activo = new ActivoBean();

            activo.setCod_activo(edtcodigoactivo.getText().toString());
            activo.setTipo_activo(spnestadoactivo.getSelectedItem().toString());
            activo.setFechacompra(edtfechacompra.getText().toString());
            activo.setSerie(Integer.parseInt(edtserie.getText().toString()));
            activo.setPlaca(edtplaca.getText().toString());
            activo.setEstado(spnestadoactivo.getSelectedItem().toString());
            activo.setCodigobarras(Integer.parseInt(edtcodigobarra.getText().toString()));
            activo.setCod_marca(((MarcaBean) spnmarca.getItemAtPosition(spnmarca.getSelectedItemPosition())).getCod_marca());
            activo.setCod_prov(((ProveedorBean) spnproveedor.getItemAtPosition(spnproveedor.getSelectedItemPosition())).getCod_prov());
            activo.setCod_resp(((ResponsableBean) spnresponsable.getItemAtPosition(spnresponsable.getSelectedItemPosition())).getCod_resp());

            // Guardamos el registro Activo
            // int result;
            //if(edtcodigoactivo.isEnabled()){
            dao.GrabarActivo(activo);
            //} else {
            //  result = dao.ActualizarActivo(activo);
            //}
            //Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();

            Intent ir = new Intent(this, ListadoActivosActivity.class);
            startActivity(ir);
        }

    }

}

