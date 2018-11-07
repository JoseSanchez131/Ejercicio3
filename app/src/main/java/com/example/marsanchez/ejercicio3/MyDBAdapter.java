package com.example.marsanchez.ejercicio3;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;

public class MyDBAdapter {


    private static final String DATABASE_NAME = "dbClase.db";
    private static final String DATABASE_TABLE = "Estudiante";
    private static final String DATABASE_TABLE2 = "Profesores";

    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_CREATE_ESTUDIANTE = "CREATE TABLE " +DATABASE_TABLE+ "(_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso integer );" ;
    private static final String DATABASE_CREATE_PROFESORES = "CREATE TABLE " +DATABASE_TABLE2+ "(_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso integer, despacho text );" ;
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS " +DATABASE_TABLE+";";
    private static final String DATABASE_DROP2 = "DROP TABLE IF EXISTS " +DATABASE_TABLE2+";";

    private final Context context;

    private MyDbHelper dbHelper;

    private SQLiteDatabase db;

    public MyDBAdapter (Context c)
    {

        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION );

    }

    public void open()
    {

        try
        {

            db = dbHelper.getWritableDatabase();

        }catch (SQLiteException e)
        {

            db = dbHelper.getReadableDatabase();

        }

    }

    public void insertarEstudiantes (String nombre, int edad, String ciclo, int curso)
    {
        ContentValues newValues = new ContentValues();

        newValues.put("nombre", nombre);
        newValues.put("edad", edad);
        newValues.put("ciclo", ciclo);
        newValues.put("curso", curso);

        db.insert(DATABASE_TABLE,null,newValues);


    }

    public void insertarProfesores(String nombre, int edad, String ciclo, int curso, String despacho)
    {
        ContentValues newValues = new ContentValues();

        newValues.put("nombre", nombre);
        newValues.put("edad", edad);
        newValues.put("ciclo", ciclo);
        newValues.put("curso", curso);
        newValues.put("despacho",despacho);

        db.insert(DATABASE_TABLE2,null,newValues);


    }

    public ArrayList <String> RecuperarProfesores(){

        ArrayList <String> profesores = new ArrayList <String>();
        Cursor cursor = db.query(DATABASE_TABLE2,null,null,null,null,null,null);
        if (cursor != null && ((Cursor) cursor).moveToFirst())
        {
            do{

                profesores.add("NOMBRE: "+cursor.getString(1)
                +" - EDAD: " +cursor.getString(2)
                + " - CICLO: " +cursor.getString(3)
                + " - CURSO: " +cursor.getString(4)
                + " - DESPACHO: " +cursor.getString(5));

            }
            while (cursor.moveToNext());


        }
        return profesores;

    }
    public ArrayList <String> RecuperarEstudiantes(){

        ArrayList <String> estudiantes = new ArrayList <String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && ((Cursor) cursor).moveToFirst())
        {
            do{

                estudiantes.add("NOMBRE: "+cursor.getString(1)
                        +" - EDAD: " +cursor.getString(2)
                        + " - CICLO: " +cursor.getString(3)
                        + " - CURSO: " +cursor.getString(4));

            }
            while (cursor.moveToNext());


        }
        return estudiantes;

    }



    public ArrayList <String> RecuperarEstudiantesXCiclo(){

        ArrayList <String> estudiantes = new ArrayList <String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,"ciclo",null,null);
        if (cursor != null && ((Cursor) cursor).moveToFirst())
        {
            do{

                estudiantes.add("NOMBRE: "+cursor.getString(1)
                        +" - EDAD: " +cursor.getString(2)
                        + " - CICLO: " +cursor.getString(3)
                        + " - CURSO: " +cursor.getString(4));

            }
            while (cursor.moveToNext());


        }
        return estudiantes;

    }
    public ArrayList <String> RecuperarEstudiantesXCurso(){

        ArrayList <String> estudiantes = new ArrayList <String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,"curso",null,null);
        if (cursor != null && ((Cursor) cursor).moveToFirst())
        {
            do{

                estudiantes.add("NOMBRE: "+cursor.getString(1)
                        +" - EDAD: " +cursor.getString(2)
                        + " - CICLO: " +cursor.getString(3)
                        + " - CURSO: " +cursor.getString(4));

            }
            while (cursor.moveToNext());


        }
        return estudiantes;

    }  public ArrayList <String> RecuperarTodo(){

        ArrayList <String> todos = new ArrayList <String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        Cursor cursor2 = db.query(DATABASE_TABLE2,null,null,null,null,null,null);
        if ((cursor != null && ((Cursor) cursor).moveToFirst()) && (cursor2 != null && ((Cursor) cursor2).moveToFirst()))
        {
            do{
                todos.add("NOMBRE: "+cursor.getString(1)
                        +" - EDAD: " +cursor.getString(2)
                        + " - CICLO: " +cursor.getString(3)
                        + " - CURSO: " +cursor.getString(4));

            }
            while (cursor.moveToNext());
            do{
                todos.add("NOMBRE: "+cursor2.getString(1)
                        +" - EDAD: " +cursor2.getString(2)
                        + " - CICLO: " +cursor2.getString(3)
                        + " - CURSO: " +cursor2.getString(4)
                        + " - DESPACHO: " +cursor2.getString(5));
            }
            while (cursor2.moveToNext());


        }
        return todos;

    }

    private static class MyDbHelper extends SQLiteOpenHelper {


        public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_ESTUDIANTE);
            db.execSQL(DATABASE_CREATE_PROFESORES);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
