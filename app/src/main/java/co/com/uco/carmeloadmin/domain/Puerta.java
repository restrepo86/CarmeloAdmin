package co.com.uco.carmeloadmin.domain;

public class Puerta {

    private Integer id;
    private String nombrePuerta;
    private byte[] imagenPuerta;

    public Puerta() {}

    public Puerta(Integer id, String nombrePuerta, byte[] imagenPuerta) {

        this.id = id;
        this.nombrePuerta = nombrePuerta;
        this.imagenPuerta = imagenPuerta;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePuerta() {
        return nombrePuerta;
    }

    public void setNombrePuerta(String nombrePuerta) {
        this.nombrePuerta = nombrePuerta;
    }

    public void setImagenPuerta(byte[] imagenPuerta) {
        this.imagenPuerta = imagenPuerta;
    }
    public byte[] getImagenPuerta() {
        return imagenPuerta;
    }
}
