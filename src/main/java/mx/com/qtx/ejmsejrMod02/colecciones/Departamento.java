package mx.com.qtx.ejmsejrMod02.colecciones;

/**
 * Responsabilidad: Administrar los datos de cada departamento
 */
public class Departamento {
    private int numero;
    private boolean ocupado;
    private String nombreInquilino;
    private double rentaMensual;

    private Persona inquilino;

    public Departamento() {
    }

    public Departamento(int numero, boolean ocupado, String nombreInquilino, double rentaMensual) {
        this.numero = numero;
        this.ocupado = ocupado;
        this.nombreInquilino = nombreInquilino;
        this.rentaMensual = rentaMensual;
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNombreInquilino() {
        if(this.inquilino == null)
            return nombreInquilino;
        return this.inquilino.getNombre();
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public double getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(double rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "numero=" + numero +
                ", ocupado=" + ocupado +
                ", nombreInquilino='" + this.getNombreInquilino() + '\'' +
                ", rentaMensual=" + rentaMensual +
                ", inquilino=" + inquilino +
                '}';
    }

    public Departamento clonar() {
    //    System.out.println("el hashcode de this es " + this.hashCode());
        Departamento clon;
        clon = new Departamento();
        clon.setNumero(this.numero);
        clon.setOcupado(this.ocupado);
        clon.setNombreInquilino(this.nombreInquilino);
        clon.setRentaMensual(this.rentaMensual);
    //    System.out.println("clon.hashCode() = " + clon.hashCode());
        return clon;

    }

    public void copiarDesde(Departamento deptoOrigen) {
        this.numero = deptoOrigen.numero;
        this.nombreInquilino = deptoOrigen.nombreInquilino;
        this.ocupado = deptoOrigen.ocupado;
        this.rentaMensual = deptoOrigen.rentaMensual;
    }

    public void copiarA(Departamento deptoDestino) {
        deptoDestino.numero = this.numero;
        deptoDestino.ocupado = this.ocupado;
        deptoDestino.nombreInquilino = this.nombreInquilino;
        deptoDestino.rentaMensual = this.rentaMensual;
    }

    public static void copiar(Departamento origen, Departamento destino) {
        destino.numero = origen.numero;
        destino.rentaMensual = origen.rentaMensual;
        destino.nombreInquilino = origen.nombreInquilino;
        destino.ocupado = origen.ocupado;
    }

    public void alquilarA(Persona persona) {
        this.inquilino = persona;
        persona.setDepto(this);
    }
}
