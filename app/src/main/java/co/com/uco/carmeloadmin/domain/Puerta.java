package co.com.uco.carmeloadmin.domain;

public class Puerta {
    private Integer id;
    private Float ancho;
    private Float alto;
    private String material;
    private Integer idImagen;

    public Puerta() {}

    public Puerta(Integer id, Float ancho, Float alto, String material, Integer idImagen) {
        this.id = id;
        this.ancho = ancho;
        this.alto = alto;
        this.material = material;
        this.idImagen = idImagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }
}
