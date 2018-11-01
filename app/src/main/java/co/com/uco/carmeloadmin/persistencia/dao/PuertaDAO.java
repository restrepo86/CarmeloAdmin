package co.com.uco.carmeloadmin.persistencia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import co.com.uco.carmeloadmin.domain.Puerta;


public class PuertaDAO {
    private SQLiteDatabase db;
    private String tableName= "puerta";
    private String query;

    public PuertaDAO(SQLiteDatabase writableDatabase) {
        this.db= writableDatabase;
    }

    public void insertar(Puerta puerta){
        ContentValues row = new ContentValues();
        row.put("id", puerta.getId());
        row.put("nombre_puerta", puerta.getNombrePuerta());
        db.insert(tableName, null, row);
    }

    public List<Puerta> listar(){
        List<Puerta> listaPuertas = new ArrayList<>();
        query = "".concat("SELECT id, nombre_puerta FROM "+tableName);
        Cursor cursor = db.rawQuery(query,null);
        Puerta puerta = null;
        if(cursor.moveToFirst()){
            do {
                puerta = new Puerta();
                puerta.setId(cursor.getInt(cursor.getColumnIndex("id")));
                puerta.setNombrePuerta(cursor.getString(cursor.getColumnIndex("nombre_puerta")));
                listaPuertas.add(puerta);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return listaPuertas;
    }
}
