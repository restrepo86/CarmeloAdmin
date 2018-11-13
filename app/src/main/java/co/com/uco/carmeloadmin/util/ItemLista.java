package co.com.uco.carmeloadmin.util;

import android.graphics.Bitmap;

public class ItemLista {

    private Bitmap idImage;
    private String id;
    private String ancho;


    public ItemLista(Bitmap idImage, String id, String ancho) {

        this.idImage = idImage;
        this.id = id;
        this.ancho = ancho;

    }

    public Bitmap getIdImage() {
        return idImage;
    }

    public void setIdImage(Bitmap idImage) {
        this.idImage = idImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

}
