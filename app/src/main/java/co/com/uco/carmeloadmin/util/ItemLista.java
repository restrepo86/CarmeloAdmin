package co.com.uco.carmeloadmin.util;

public class ItemLista {

    private int idImage;
    private String id;
    private String ancho;
    private String alto;
    private String material;

    public ItemLista(int idImage, String id, String ancho, String alto, String material) {
        this.idImage = idImage;
        this.id = id;
        this.ancho = ancho;
        this.alto = alto;
        this.material = material;
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

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
