package co.com.uco.carmeloadmin.util;

public class ItemLista {

    private int idImage;
    private String id;
    private String ancho;


    public ItemLista(int idImage, String id, String ancho) {

        this.idImage = idImage;
        this.id = id;
        this.ancho = ancho;

    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
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
