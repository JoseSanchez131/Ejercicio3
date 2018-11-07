package com.example.marsanchez.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class estudiantes extends AppCompatActivity {

    private MyDBAdapter dbAdapter;

    public estudiantes (){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes);


        final EditText editText1 = (EditText) findViewById(R.id.editText1);

        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        final EditText editText3 = (EditText) findViewById(R.id.editText3);

        final EditText editText4 = (EditText) findViewById(R.id.editText4);

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
                dbAdapter.insertarEstudiantes(nombre,edad,ciclo,curso);
                //VOLVER PAGINA PRINCIPAL
                startActivity(intent);
            }
        });



    }
}
