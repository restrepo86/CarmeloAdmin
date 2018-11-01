package co.com.uco.carmeloadmin.domain;

public class Puerta {

    private Integer id;
    private String nombrePuerta;

    public Puerta() {}

    public Puerta(Integer id, String nombrePuerta) {

        this.id = id;
        this.nombrePuerta = nombrePuerta;

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
}
