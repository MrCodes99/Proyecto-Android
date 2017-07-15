package com.example.Adaptador;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.beans.ActivoBean;
import com.example.nilton.proyecto_movil_2017.R;

import java.util.ArrayList;

/**
 * Created by MICHELL on 14/07/2017.
 */

public class LVMainAdapter extends ArrayAdapter<ActivoBean> {
    public LVMainAdapter(Context context) {
        super(context, 0, new ArrayList<ActivoBean>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_activos, parent, false);

        TextView tvCodigo, tvTipoActivo, tvSerie, tvPlaca, tvEstado, tvCodigoBarra;

        tvCodigo = (TextView) convertView.findViewById(R.id.tvCodigo);
        tvTipoActivo = (TextView) convertView.findViewById(R.id.tvTipoActivo);
        tvSerie = (TextView) convertView.findViewById(R.id.tvSerie);
        tvPlaca = (TextView) convertView.findViewById(R.id.tvPlaca);
        tvEstado = (TextView) convertView.findViewById(R.id.tvEstado);

        ActivoBean activo = getItem(position);

        tvCodigo.setText(activo.getCod_activo());
        tvTipoActivo.setText(activo.getTipo_activo());
        tvSerie.setText(String.valueOf(activo.getSerie()));
        tvPlaca.setText(activo.getPlaca());
        tvEstado.setText(activo.getEstado());

        return convertView;
    }
}
