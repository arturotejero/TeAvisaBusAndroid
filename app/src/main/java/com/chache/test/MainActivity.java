package com.chache.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    final Button btnProgramarAlarma = (Button)findViewById(R.id.buttonSetAlarm);
    final Button btnBuscar = (Button)findViewById(R.id.btnBuscar);
    final EditText txtParada = (EditText)findViewById(R.id.editParada);
    final Spinner cmbLineas = (Spinner)findViewById(R.id.spinnerLinea);
    final Spinner cmbDestino = (Spinner)findViewById(R.id.spinnerDestino);
    final String[] numeroLinea = new String[]{"Linea1","Linea2","Linea3","Linea4","Linea5"};
    final ArrayAdapter<String> adaptadorLineas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numeroLinea);
    final String [] horasDePaso = new String[] {"08:00","09:00","10:00","11:00","12:00"};
    final ArrayAdapter<String> adaptadorHoras = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, horasDePaso);
    final String [] paradaDestino = new String [] {"250", "300", "500"};
    final ArrayAdapter <String> adaptadorDestino = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paradaDestino);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Llamar webservice y obtener las paradas
                adaptadorLineas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cmbLineas.setAdapter(adaptadorLineas);

                cmbLineas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        adaptadorHoras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        cmbLineas.setAdapter(adaptadorHoras);

                        adaptadorDestino.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        cmbDestino.setAdapter(adaptadorDestino);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        btnProgramarAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent (MainActivity.this, ResultadoAlarma.class);

                Bundle bundle = new Bundle();
                bundle.putString("Parada", txtParada.getText().toString());
                bundle.putString("Destino", "Destino");
                intent.putExtras(bundle);

            startActivity(intent);
            }
        });
    }
}