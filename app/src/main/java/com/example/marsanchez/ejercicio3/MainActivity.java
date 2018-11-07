package com.example.marsanchez.ejercicio3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS="My preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, estudiantes.class);
        final Intent intent2 = new Intent(this, Profesores.class);
        final Intent intent3 = new Intent(this, Consultas.class);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                SharedPreferences.Editor editor=mySharedPreferences.edit();

                editor.putString("nombre", "Jose");
                editor.putString("nombreUsuario", "Josagi");
                editor.putString("fechaNacimiento", "05/11/1993");
                editor.putBoolean("sexo", true);

                editor.commit();
            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

                String nombre = mySharedPreferences.getString("nombre", "Jose");
                String nombreUsuario = mySharedPreferences.getString("nombreUsuario", "Josagi");
                String fechaNacimiento = mySharedPreferences.getString("fechaNacimiento", "05/11/1993");
                boolean sexo = mySharedPreferences.getBoolean("sexo", true);

                Toast.makeText(MainActivity.this, "Nombre: " + nombre + ", Nombre usuario: " + nombreUsuario + ", fecha nacimiento: " + fechaNacimiento + ", sexo: " + sexo, Toast.LENGTH_SHORT).show();
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(intent);

            }
        });

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });


    }



}
