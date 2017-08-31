package com.example.mecha.app2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mecha on 31/8/2017.
 */

public class BandasAdapter extends ArrayAdapter<Bandas> {
    Context conext;
    int layoutResourceId;
    Bandas[] data = null;
    public BandasAdapter(@NonNull Context context, @LayoutRes int resource, Bandas[] data) {
        super(context, resource, data);

        this.conext = context;
        this.layoutResourceId = resource;
        this.data = data;
    }

    public View getView(int posicion, View convertView, ViewGroup parent){
        View row = convertView;
        BandasHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)conext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new BandasHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById(R.id.texto);

            row.setTag(holder);
        }else{
            holder = (BandasHolder) row.getTag();
        }

        Bandas bandas = data[posicion];
        holder.texto.setText(bandas.title);
        holder.imagen.setImageResource(bandas.icon);

        return row;
    }

    static class BandasHolder{
        ImageView imagen;
        TextView texto;
    }
}
