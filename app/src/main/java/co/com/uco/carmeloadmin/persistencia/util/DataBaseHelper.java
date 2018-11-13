package co.com.uco.carmeloadmin.persistencia.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private String createTableUsuario = "CREATE TABLE USUARIO(id INTEGER PRIMARY KEY, nombreUsuario TEXT, contrasenia TEXT)";
    private String createTablePuerta = "CREATE TABLE PUERTA(id INTEGER PRIMARY KEY, nombre_puerta TEXT, imagenPuerta BLOB)";


    public DataBaseHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTableUsuario);
        db.execSQL(createTablePuerta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("USUARIO"));
        db.execSQL(createTableUsuario);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PUERTA"));
        db.execSQL(createTablePuerta);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("USUARIO"));
        db.execSQL(createTableUsuario);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PUERTA"));
        db.execSQL(createTablePuerta);

    }
}
