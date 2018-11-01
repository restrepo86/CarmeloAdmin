package co.com.uco.carmeloadmin.persistencia.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private String createTableParametro = "CREATE TABLE PARAMETRO(id INTEGER PRIMARY KEY, nombre TEXT, valor FLOAT)";
    private String createTableUsuario = "CREATE TABLE USUARIO(id INTEGER PRIMARY KEY, nombreUsuario TEXT, contrasenia TEXT)";
    private String createTablePieza = "CREATE TABLE PIEZA(id INTEGER PRIMARY KEY, ancho FLOAT, alto FLOAT, material TEXT)";
    private String createTableImagenPuerta = "CREATE TABLE IMAGEN(id INTEGER PRIMARY KEY, nombreImage TEXT, imagen BLOB)";

    private String createTablePuerta = "CREATE TABLE PUERTA(id INTEGER PRIMARY KEY, ancho FLOAT, alto FLOAT, material TEXT, idImagen INTEGER, FOREIGN KEY (idImagen) REFERENCES IMAGEN(id))";
    private String createTablePiezasPuerta = "CREATE TABLE PIEZASPUERTA(id INTEGER PRIMARY KEY, idPuerta INTEGER, idPieza INTEGER, cantidad INTEGER, " +
                                             "FOREIGN KEY (idPuerta) REFERENCES PUERTA(id), FOREIGN KEY (idPieza) REFERENCES PIEZA(id))";


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
        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PARAMETRO"));
        db.execSQL(createTableParametro);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("USUARIO"));
        db.execSQL(createTableUsuario);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PIEZA"));
        db.execSQL(createTablePieza);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("IMAGEN"));
        db.execSQL(createTableImagenPuerta);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PUERTA"));
        db.execSQL(createTablePuerta);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PIEZASPUERTA"));
        db.execSQL(createTablePiezasPuerta);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PARAMETRO"));
        db.execSQL(createTableParametro);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("USUARIO"));
        db.execSQL(createTableUsuario);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PIEZA"));
        db.execSQL(createTablePieza);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("IMAGEN"));
        db.execSQL(createTableImagenPuerta);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PUERTA"));
        db.execSQL(createTablePuerta);

        db.execSQL("".concat(" DROP TABLE IF EXISTS ").concat("PIEZASPUERTA"));
        db.execSQL(createTablePiezasPuerta);
    }
}
