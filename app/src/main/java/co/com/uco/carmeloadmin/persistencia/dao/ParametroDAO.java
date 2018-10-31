package co.com.uco.carmeloadmin.persistencia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import co.com.uco.carmeloadmin.domain.Parametro;

public class ParametroDAO {
    private SQLiteDatabase db;
    private String tableName= "parametro";
    private String query;

    public ParametroDAO(SQLiteDatabase writableDatabase) {
        this.db= writableDatabase;
    }

    public void insertar(Parametro parametro){
        ContentValues row = new ContentValues();
        row.put("id", parametro.getId());
        row.put("nombre", parametro.getNombre());
        row.put("valor", parametro.getValor());
        db.insert(tableName, null, row);
    }

    public List<Parametro> listar(){
        List<Parametro> listaParametros = new ArrayList<>();
        query = "".concat("SELECT id, nombre, valor FROM "+tableName);
        Cursor cursor = db.rawQuery(query,null);
        Parametro parametro = null;
        if(cursor.moveToFirst()){
            do {
                parametro = new Parametro();
                parametro.setId(cursor.getInt(cursor.getColumnIndex("id")));
                parametro.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                parametro.setValor(cursor.getFloat(cursor.getColumnIndex("valor")));
                listaParametros.add(parametro);
            }while(cursor.moveToNext());
            cursor.close();
        }
        else{
            listaParametros.clear();
        }
        return listaParametros;
    }

}
