package com.example.mecha.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    ListView lista;
    //String[] valores = new String[] {"Holanda","España","USA","India","China","Mexico","Uruguay",
    //"Asia","Francia","Ecuador","Chile"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lista = (ListView) findViewById(R.id.lista);

        //vamos a usar adaptadores que nos permiten llenar elementos a nuestra conveniencia
        //Parametros:  contexto y elemento a llenar
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout
                .simple_expandable_list_item_1, valores);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Posicion: "+position,Toast.LENGTH_SHORT)
                        .show();
            }
        });
        */
        Bandas bandas_data[] = new Bandas[]{
                new Bandas(R.drawable.ic_launcher,"Coldplay"),
                new Bandas(R.drawable.ic_launcher,"Fire"),
                new Bandas(R.drawable.ic_launcher,"Muse"),
                new Bandas(R.drawable.ic_launcher,"The Killers"),
                new Bandas(R.drawable.ic_launcher,"Red Hot Chilli Pepers"),
                new Bandas(R.drawable.ic_launcher,"Nirvana"),
                new Bandas(R.drawable.ic_launcher,"Cuarteto de Nos"),
                new Bandas(R.drawable.ic_launcher,"Coldplay"),
                new Bandas(R.drawable.ic_launcher,"STP"),
                new Bandas(R.drawable.ic_launcher,"Placebo"),
                new Bandas(R.drawable.ic_launcher,"Metallica")
        };

        BandasAdapter adapter = new BandasAdapter(this, R.layout.listview_item_row, bandas_data);
        lista = (ListView) findViewById(R.id.lista);
        View header = (View) getLayoutInflater().inflate(R.layout.lits_header_row, null);
        lista.addHeaderView(header);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.texto);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
