package mx.com.qtx.ejmsejrMod02.streams;

public class Gato {
    private int numero;
    private String nombre;
    private String raza;
    private Double pesoEnKg;

    public Gato(int numero, String nombre, String raza, Double pesoEnKg) {
        this.numero = numero;
        this.nombre = nombre;
        this.raza = raza;
        this.pesoEnKg = pesoEnKg;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Double getPesoEnKg() {
        return pesoEnKg;
    }

    public void setPesoEnKg(Double pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", pesoEnKg=" + pesoEnKg +
                '}';
    }
}
