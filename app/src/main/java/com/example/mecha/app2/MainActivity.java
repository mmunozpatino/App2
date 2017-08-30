package com.example.mecha.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    TextView saludo;
    EditText et;
    String texto;
    Button boton, botonN, botonR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlace de parte grafica con lógica
        et = (EditText) findViewById(R.id.editText);
        saludo = (TextView) findViewById(R.id.Bienvenido);
        boton = (Button) findViewById(R.id.boton);
        botonN = (Button) findViewById(R.id.botonN);
        botonR = (Button) findViewById(R.id.botonR);

        boton.setOnClickListener(this);
        botonN.setOnClickListener(this);
        botonR.setOnClickListener(this);
        //et.setText("cambiamos texto");
        //Relaciono el textview que hice antes
        /*saludo = (TextView) findViewById(R.id.Bienvenido);
        saludo.setText("hola desde el onCreate");*/
    }

    /* Otra manera de tomar los clicks es creando metodo por metodo
        en la llamada no se usan (), solo el nombre

        public void tomarTexto (View v){
            texto = et.getText().toString();
            saludo.setText("holaa");
        }
     */


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton:
                String dato = et.getText().toString();
                saludo.setText(dato);
                break;
            case R.id.botonN:
                saludo.setText("boton 2");
                break;
            case R.id.botonR:
                saludo.setText(R.string.bienvenido);
        }
    }
}
