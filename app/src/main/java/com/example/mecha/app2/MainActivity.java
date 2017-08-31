package com.example.mecha.app2;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    Button botonT, botonA, botonS, botonLV, botonCT, botonWV, botonMaps;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlace de parte grafica con lógica
        et = (EditText) findViewById(R.id.et);
        saludo = (TextView) findViewById(R.id.Bienvenido);
        botonT = (Button) findViewById(R.id.botonT);
        botonA = (Button) findViewById(R.id.botonA);
        botonS = (Button) findViewById(R.id.Bsensor);
        botonLV = (Button) findViewById(R.id.botonLV);
        botonCT = (Button) findViewById(R.id.botonCT);
        botonWV = (Button) findViewById(R.id.botonWV);
        botonMaps = (Button) findViewById(R.id.botonMaps);

        ln = (LinearLayout) findViewById(R.id.mainlo);




        botonT.setOnClickListener(this);
        botonA.setOnClickListener(this);
        botonS.setOnClickListener(this);
        botonLV.setOnClickListener(this);
        botonCT.setOnClickListener(this);
        botonWV.setOnClickListener(this);
        botonMaps.setOnClickListener(this);
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
            case R.id.botonT:
                Toast.makeText(getApplicationContext(), "esto un toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.botonA:
                String msj = et.getText().toString();
                if(TextUtils.isEmpty(msj)) {
                    Toast.makeText(getApplicationContext(), "Complete el campo de texto!", Toast
                            .LENGTH_SHORT).show();
                }else {
                    //paso contexto y cuál quiero crear
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //nombre dee lo que mando y lo que mando
                    intent.putExtra("DATO", msj);
                    startActivity(intent);
                }
                break;
            case R.id.Bsensor:
                Intent intentS = new Intent(this, SensorActivity.class);
                startActivity(intentS);
                break;
            case R.id.botonLV:
                Intent view = new Intent(this, ListViewActivity.class);
                startActivity(view);
                break;
            case R.id.botonCT:
                Intent cambiar = new Intent(this, ChangeTitleActivity.class);
                startActivity(cambiar);
                break;
            case R.id.botonWV:
                Intent web = new Intent(this, WebViewActivity.class);
                startActivity(web);
                break;
            case R.id.botonMaps:
                Intent map = new Intent(this, MapsActivity.class);
                startActivity(map);
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
