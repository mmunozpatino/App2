package com.example.mecha.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeTitleActivity extends AppCompatActivity {
    Button botonC, botonC2, botonR;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_title);

        botonC = (Button) findViewById(R.id.botonC);
        botonC2 = (Button) findViewById(R.id.botonC2);
        botonR = (Button) findViewById(R.id.botonR);

        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.editText);
    }
    public void cambiarTexto(View view){
        textView.setText(editText.getText().toString());
    }
    public void otroCambio(View view){
        textView.setText("No se que cambio esperas!");
    }
    public void reset(View view){
        textView.setText("");
    }
}
