package co.com.uco.carmeloadmin.persistencia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import co.com.uco.carmeloadmin.domain.Pieza;

public class PiezaDAO {
    private SQLiteDatabase db;
    private String tableName= "pieza";
    private String query;

    public PiezaDAO(SQLiteDatabase writableDatabase) {
        this.db= writableDatabase;
    }

    public void insertar(Pieza pieza){
        ContentValues row = new ContentValues();
        row.put("id", pieza.getId());
        row.put("ancho", pieza.getAncho());
        row.put("alto", pieza.getAlto());
        row.put("material", pieza.getMaterial());
        db.insert(tableName, null, row);
    }

    public List<Pieza> listar(){
        List<Pieza> listaPiezas = new ArrayList<>();
        query = "".concat("SELECT id, ancho, alto, material FROM "+tableName);
        Cursor cursor = db.rawQuery(query,null);
        Pieza pieza = null;
        if(cursor.moveToFirst()){
            do {
                pieza = new Pieza();
                pieza.setId(cursor.getInt(cursor.getColumnIndex("id")));
                pieza.setAncho(cursor.getFloat(cursor.getColumnIndex("ancho")));
                pieza.setAlto(cursor.getFloat(cursor.getColumnIndex("alto")));
                pieza.setMaterial(cursor.getString(cursor.getColumnIndex("material")));
                listaPiezas.add(pieza);
            }while(cursor.moveToNext());
            cursor.close();
        }
        else{
            listaPiezas.clear();
        }
        return listaPiezas;
    }
}
