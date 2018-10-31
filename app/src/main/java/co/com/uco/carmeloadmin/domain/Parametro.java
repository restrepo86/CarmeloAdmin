package co.com.uco.carmeloadmin.domain;

public class Parametro {
    private Integer id;
    private String nombre;
    private Float valor;

    public Parametro(){}

    public Parametro(Integer id, String nombre, Float valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}

