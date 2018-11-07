package com.example.marsanchez.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
public class Profesores extends AppCompatActivity {

    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);


        final EditText editText1 = (EditText) findViewById(R.id.editText1);

        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        final EditText editText3 = (EditText) findViewById(R.id.editText3);

        final EditText editText4 = (EditText) findViewById(R.id.editText4);

        final EditText editText5 = (EditText) findViewById(R.id.editText5);

        final Button button3 = (Button) findViewById(R.id.button3);

        final Intent intent = new Intent(this, MainActivity.class);

        dbAdapter=new MyDBAdapter(this);
        dbAdapter.open();


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = editText1.getText().toString();
                int edad = Integer.parseInt(editText2.getText().toString());
                String ciclo = editText3.getText().toString();
                int curso = Integer.parseInt(editText4.getText().toString());
                final String despacho = editText5.getText().toString();
                dbAdapter.insertarProfesores(nombre,edad,ciclo,curso,despacho);

                //VOLVER PAGINA PRINCIPAL
                startActivity(intent);

            }
        });

    }
}
