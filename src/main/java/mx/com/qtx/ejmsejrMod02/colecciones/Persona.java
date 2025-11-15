package mx.com.qtx.ejmsejrMod02.colecciones;

public class Persona {
    private String nombre;
    private String id;
    private String telefono;
    private Departamento depto;
    private Condominio condomonioAdministrado;


    public Persona(String nombre, String id, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.depto = null;
        this.condomonioAdministrado = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    public Condominio getCondomonioAdministrado() {
        return condomonioAdministrado;
    }

    public void setCondomonioAdministrado(Condominio condomonioAdministrado) {
        this.condomonioAdministrado = condomonioAdministrado;
    }

    public Persona clonar(){
        return new Persona(this.nombre,this.id,this.telefono);
    }

    /**
     *  Advertencia: No clona el condominio para evitar un clonado circular
     * @param perFte
     */
    public void copiarDesde(Persona perFte){
        this.id = perFte.id;
        this.nombre = perFte.nombre;
        this.telefono = perFte.telefono;
        if(this.depto != null)
            this.depto.copiarDesde(perFte.depto);
    }

    @Override
    public String toString() {
        String condominio = "";
        if(this.condomonioAdministrado != null){
            condominio = "Condominio en " + this.condomonioAdministrado.getDireccion();
        }
        String depto = "No tiene asignado ningun departamento";
        if(this.depto != null){
            depto = "" + this.depto.getNumero();
        }
        String cadPersona = "Persona{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", telefono='" + telefono + '\'' +
                ", depto=" + depto +
                ", condominio=" + condominio +
                '}';
        return cadPersona;
    }
}
