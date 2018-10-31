package co.com.uco.carmeloadmin.domain;

import android.graphics.Bitmap;

public class ImagenPuerta {
    private Integer id;
    private String nombre;
    private Bitmap imagen;

    public ImagenPuerta(){}

    public ImagenPuerta(Integer id, String nombre, Bitmap imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
