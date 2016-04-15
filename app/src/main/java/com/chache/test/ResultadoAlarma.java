package com.chache.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by prest079 on 13/04/2016.
 */
public class ResultadoAlarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarma_resultado);

        TextView textView = (TextView) findViewById(R.id.textView5);
        TextView textView2 = (TextView) findViewById(R.id.textView6);

        Bundle bundle = getIntent().getExtras();

        textView.setText(bundle.getString("Parada"));
        textView2.setText(bundle.getString("Destino"));
    }
}
