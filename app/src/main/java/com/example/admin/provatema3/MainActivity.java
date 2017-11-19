package com.example.admin.provatema3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS="Mis Preferencias";

    EditText actualizarDia, actualizarMes;
    TextView dia, mes;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actualizarDia = (EditText) findViewById(R.id.actualizarDia);
        actualizarMes = (EditText) findViewById(R.id.actualizarMes);
        dia = (TextView) findViewById(R.id.dia);
        mes = (TextView) findViewById(R.id.mes);
        guardar = (Button)findViewById(R.id.botonActualizar);

        SharedPreferences sp =  getSharedPreferences(PREFS, MODE_PRIVATE);
        dia.setText(sp.getString("dia",""));
        mes.setText(sp.getString("mes",""));

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp =  getSharedPreferences(PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("dia",actualizarDia.getText().toString());
                editor.putString("mes",actualizarMes.getText().toString());
                editor.commit();

                // destruye esta actividad y la vuelve a abrir
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }
}


