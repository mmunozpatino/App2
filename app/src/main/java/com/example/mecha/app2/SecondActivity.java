package com.example.mecha.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = (TextView) findViewById(R.id.tv);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if(extras != null){
            String dato = extras.getString("DATO");
            tv.setText(dato);
        }
    }
}
