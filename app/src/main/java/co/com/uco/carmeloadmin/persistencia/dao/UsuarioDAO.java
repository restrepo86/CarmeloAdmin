package co.com.uco.carmeloadmin.persistencia.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import co.com.uco.carmeloadmin.domain.Usuario;


public class UsuarioDAO {

    private SQLiteDatabase db;
    private String tableName= "usuario";
    private String query;

    public UsuarioDAO(SQLiteDatabase writableDatabase) {
        this.db= writableDatabase;
    }

    public void insertar(Usuario usuario){
        ContentValues row= new ContentValues();
        row.put("id", usuario.getId());
        row.put("nombreUsuario", usuario.getNombreUsuario());
        row.put("contrasenia", usuario.getContrasenia());
        db.insert(tableName, null, row);
    }

    public Usuario consultarPorNombreYContrasenia(String nombreUsuario, String contrasenia){

        query = "".concat("SELECT * FROM ").concat(tableName).concat(" WHERE nombreUsuario=").concat("'").concat(nombreUsuario).concat("'").concat(" AND contrasenia=").concat("'").concat(contrasenia).concat("'");
        Usuario usuario = null;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setNombreUsuario(cursor.getString(cursor.getColumnIndex("nombreUsuario")));
                usuario.setContrasenia(cursor.getString(cursor.getColumnIndex("contrasenia")));
            }while(cursor.moveToNext());
            cursor.close();
        }
        return usuario;
    }

    public  Usuario consultarPorId(Integer id) {
        query = "".concat("SELECT * FROM ").concat(tableName).concat(" WHERE id=").concat("'").concat(id+"'");
        Usuario usuario = null;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setNombreUsuario(cursor.getString(cursor.getColumnIndex("nombreUsuario")));
                usuario.setContrasenia(cursor.getString(cursor.getColumnIndex("contrasenia")));
            }while(cursor.moveToNext());
            cursor.close();
        }
        return usuario;
    }

    public Usuario consultarPorNombreUsuario(String nombreUsuario) {
        query = "".concat("SELECT * FROM ").concat(tableName).concat(" WHERE nombreUsuario=").concat("'").concat(nombreUsuario+"'");
        Usuario usuario = null;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                usuario = new Usuario();
                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setNombreUsuario(cursor.getString(cursor.getColumnIndex("nombreUsuario")));
                usuario.setContrasenia(cursor.getString(cursor.getColumnIndex("contrasenia")));
            }while(cursor.moveToNext());
            cursor.close();
        }
        return usuario;
    }
}