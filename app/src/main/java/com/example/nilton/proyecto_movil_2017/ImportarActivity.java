package com.example.nilton.proyecto_movil_2017;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.beans.ActivoBean;
import com.example.service.ConsumeWS;

import java.util.ArrayList;

public class ImportarActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnimportar;
    ArrayList<ActivoBean> activos;
    ProgressDialog pd;

    private void iniciaComponentes(){
        btnimportar = (Button)findViewById(R.id.btnImportar);

        btnimportar.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importar);
    }

    @Override
    public void onClick(View v) {

        pd = ProgressDialog.show(this,"Conectando","Espere porFavor..", true,false);

        new ImportarActivo().execute();

        ConsumeWS ws = new ConsumeWS();

    }
    private class ImportarActivo extends AsyncTask<String , Void , Object>{
        @Override
        protected Object doInBackground(String... params) {
            ConsumeWS ws = new ConsumeWS();
            activos = ws.ListarActivo();
            /*ConsumeWS ws=new ConsumeWS();
            //result = ws.Grabar("XX", "XXXX");
            //ArrayList<CursoBean> lista=ws.Listar();
            result=""+ws.Listar().size();*/
            return null;
        }
        protected void onPostExecute(Object rst){
            pd.dismiss(); //-->descargar
            Toast.makeText(getApplicationContext(),
                    "Importado " + activos.size(), Toast.LENGTH_LONG).show();
        }
    }

}
