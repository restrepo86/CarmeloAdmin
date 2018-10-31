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
        row.put("ancho", puerta.getAncho());
        row.put("alto", puerta.getAlto());
        row.put("material", puerta.getMaterial());
        row.put("idImagen", puerta.getIdImagen());
        db.insert(tableName, null, row);
    }

    public List<Puerta> listar(){
        List<Puerta> listaPuertas = new ArrayList<>();
        query = "".concat("SELECT id, ancho, alto, material, idImagen FROM "+tableName);
        Cursor cursor = db.rawQuery(query,null);
        Puerta puerta = null;
        if(cursor.moveToFirst()){
            do {
                puerta = new Puerta();
                puerta.setId(cursor.getInt(cursor.getColumnIndex("id")));
                puerta.setAncho(cursor.getFloat(cursor.getColumnIndex("ancho")));
                puerta.setAlto(cursor.getFloat(cursor.getColumnIndex("alto")));
                puerta.setMaterial(cursor.getString(cursor.getColumnIndex("material")));
                puerta.setIdImagen(cursor.getInt(cursor.getColumnIndex("idImagen")));
                listaPuertas.add(puerta);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return listaPuertas;
    }
}
