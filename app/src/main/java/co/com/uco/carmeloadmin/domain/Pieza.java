package co.com.uco.carmeloadmin.domain;

public class Pieza {
    private Integer id;
    private Float ancho;
    private Float alto;
    private String material;

    public Pieza(){}

    public Pieza(Integer id, Float ancho, Float alto, String material) {
        this.id = id;
        this.ancho = ancho;
        this.alto = alto;
        this.material = material;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Float getAncho() {
        return ancho;
    }

    public void setAncho(Float ancho) {
        this.ancho = ancho;
    }

    public Float getAlto() {
        return alto;
    }

    public void setAlto(Float alto) {
        this.alto = alto;
    }
}
