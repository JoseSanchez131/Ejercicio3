package com.example.marsanchez.ejercicio3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class Consultas extends AppCompatActivity {

    TextView textView;
    EditText editBuscador;
    Button consultaAlumnos, consultaProfesores, consultaTodo, btnBorrar, consultaAlumnosCurso;
    private MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        consultaAlumnos = (Button) findViewById(R.id.consultaAlumnos);
        consultaProfesores = (Button) findViewById(R.id.consultaProfesores);
        consultaTodo = (Button) findViewById(R.id.consultaTodo);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        consultaAlumnosCurso = (Button) findViewById(R.id.consultaAlumnosCurso);
        editBuscador = (EditText) findViewById(R.id.editBuscador);
        textView = (TextView) findViewById(R.id.textView);

        consultaAlumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarAlumnos();
            }
        });
        consultaProfesores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarProfesores();
            }
        });
        consultaTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTodo();
            }
        });
        consultaAlumnosCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarAlumnosCurso();
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarTextView();
            }
        });
    }





    public void mostrarAlumnos() {

        dbAdapter = new MyDBAdapter(getApplicationContext());
        dbAdapter.open();
        ArrayList<String> alumnos = dbAdapter.RecuperarEstudiantes();

        for (int i = 0; i < alumnos.size(); i++) {
            textView.setText(textView.getText() + " \n" + alumnos.get(i));
        }

    }

    public void mostrarProfesores() {
        dbAdapter = new MyDBAdapter(getApplicationContext());
        dbAdapter.open();
        ArrayList<String> profesores = dbAdapter.RecuperarProfesores();

        for (int i = 0; i < profesores.size(); i++) {
            textView.setText(textView.getText() + " \n" + profesores.get(i));
        }
    }

    public void mostrarTodo() {
        dbAdapter = new MyDBAdapter(getApplicationContext());
        dbAdapter.open();
        ArrayList<String> todo = dbAdapter.RecuperarTodo();

        for (int i = 0; i < todo.size(); i++) {
            textView.setText(textView.getText() + " \n " + todo.get(i));
        }

    }

    public void mostrarAlumnosCiclo() {
        dbAdapter = new MyDBAdapter(getApplicationContext());
        dbAdapter.open();
        String query = editBuscador.getText().toString();
        ArrayList<String> alumnoPorCiclo = dbAdapter.RecuperarEstudiantesXCiclo();

        for (int i = 0; i < alumnoPorCiclo.size(); i++) {
            textView.setText(textView.getText() + " \n " + alumnoPorCiclo.get(i));
        }
    }

    public void mostrarAlumnosCurso() {
        dbAdapter = new MyDBAdapter(getApplicationContext());
        dbAdapter.open();
        String query = editBuscador.getText().toString();
        ArrayList<String> alumnoPorCurso = dbAdapter.RecuperarEstudiantesXCurso();

        for (int i = 0; i < alumnoPorCurso.size(); i++) {
            textView.setText(textView.getText() + " \n " + alumnoPorCurso.get(i));
        }
    }


    public void borrarTextView() {
        textView.setText("");
    }
}