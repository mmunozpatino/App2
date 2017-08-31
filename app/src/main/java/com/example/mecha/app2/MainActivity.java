package com.example.mecha.app2;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener, SensorEventListener{
    TextView saludo;
    EditText et;
    String texto;
    Button boton, botonN, botonR, botonT, botonA, botonS;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;
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
        botonT = (Button) findViewById(R.id.botonT);
        botonA = (Button) findViewById(R.id.botonA);
        botonS = (Button) findViewById(R.id.Bsensor);
        ln = (LinearLayout) findViewById(R.id.mainlo);


        boton.setOnClickListener(this);
        botonN.setOnClickListener(this);
        botonR.setOnClickListener(this);
        botonT.setOnClickListener(this);
        botonA.setOnClickListener(this);
        botonS.setOnClickListener(this);
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
                break;
            case R.id.botonT:
                Toast.makeText(getApplicationContext(), "esto un toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.botonA:
                String msj = et.getText().toString();
                //paso contexto y cuál quiero crear
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //nombre dee lo que mando y lo que mando
                intent.putExtra("DATO", msj);
                startActivity(intent);
                break;
            case R.id.Bsensor:
                Intent intentS = new Intent(this, SensorActivity.class);
                startActivity(intentS);
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
