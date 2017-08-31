package com.example.mecha.app2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity implements View.OnClickListener,SensorEventListener{

    Button boton;
    TextView tvprox;
    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;
    boolean test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        boton = (Button) findViewById(R.id.botonP);
        tvprox = (TextView) findViewById(R.id.tvprox);
        ln = (LinearLayout) findViewById(R.id.sensorln);
        boton.setOnClickListener(this);

        //Declaramos sensores
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonP:
                if(test){
                    test = false;
                    tvprox.setText("");
                }else{
                    test = true;
                }
                break;
        }
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(test) {
            String tx = String.valueOf(event.values[0]);
            tvprox.setText(tx);

            float valor = Float.parseFloat(tx);

            if (valor <= 3) {
                if(valor == 3){
                    ln.setBackgroundColor(Color.YELLOW);
                }else{
                    if(valor == 1){
                        ln.setBackgroundColor(Color.RED);
                    }
                }
            } else {
                ln.setBackgroundColor(Color.WHITE);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
