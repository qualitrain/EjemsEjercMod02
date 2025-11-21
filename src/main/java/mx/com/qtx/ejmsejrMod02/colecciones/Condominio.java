package mx.com.qtx.ejmsejrMod02.colecciones;

import java.util.ArrayList;

/**
 * Responsabilidad: Administrar datos de un Condominio
 */
public class Condominio {
    public static final int DEPTO_NO_DISPONIBLE = -1;

    private String direccion;

    private ArrayList<Departamento> deptos;

    private Persona administrador;


    @Deprecated
    public Condominio(String direccion, String nombreAdministrador) {
        this(direccion,new Persona(nombreAdministrador,"indefinido","indefinido"));
    }

    public Condominio(String direccion, Persona administrador) {
        this.direccion = direccion;
        this.administrador = administrador;

        this.deptos = new ArrayList<>();

    }

    public Persona getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Persona administrador) {
        this.administrador = administrador;
        this.administrador.setCondomonioAdministrado(this);
    }

    public void setDepartamento(int numDepto, boolean ocupado, String inquilino, double renta, int pos){
        Departamento nvoDepto = new Departamento(numDepto,ocupado,inquilino,renta);
        this.deptos.set(pos,nvoDepto);
     }

    public Condominio() {
        this.direccion = "indefinida";
        this.administrador = null;

        this.deptos = new ArrayList<>();
        for(int i=0;i<4;i++)
         this.deptos.add(new Departamento());
      }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreAdministrador() {
        if(this.administrador == null)
            return null;
        return this.administrador.getNombre();
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        if(this.administrador == null)
            return;
        this.administrador.setNombre(nombreAdministrador);
    }

    @Override
    public String toString() {
        String nombreAdministrador = "No hay administrador";
        if(this.administrador != null) {
            nombreAdministrador = this.administrador.getNombre();
        }
        String cadCondominio = "Deptos:{" + this.deptos +
                ", nombreAdministrador='" + nombreAdministrador + '\'' +
                '}';
        return cadCondominio;
    }

    public void registrarInquilino(int numDepto, String inquilino) {
        Departamento depto =  this.buscarDepartamento(numDepto);
        if(depto == null){
            System.out.println("Ese departamento NO EXISTE");
            return;
        }
        depto.setOcupado(true);
        depto.setNombreInquilino(inquilino);
    }

    private Departamento buscarDepartamento(int numDeptoBuscado) {
        for(Departamento deptoI:this.deptos){
            if(numDeptoBuscado == deptoI.getNumero())
                return deptoI;
        }
        return null;
    }

    public int getNumDeptoDisponible() {
        for(Departamento deptoI : this.deptos){
            if(deptoI.isOcupado() == false)
                return deptoI.getNumero();
        }
        return Condominio.DEPTO_NO_DISPONIBLE;
    }

    public Condominio clonar() {
        Condominio clon = new Condominio();
        clon.direccion = this.direccion;
        for(Departamento deptoI:this.deptos){
            clon.deptos.add(deptoI.clonar());
        }
        if(this.administrador != null)
            clon.administrador = this.administrador.clonar();
        return clon;
    }

    public void copiarA(Condominio cndDestino) {
        cndDestino.direccion = this.direccion;
        if(this.administrador != null)
            administrador.copiarDesde(this.administrador);
        for(int i=0;i<this.deptos.size();i++){
            cndDestino.deptos.get(i).copiarDesde(this.deptos.get(i));
        }
    }

    public void alquilarDepartamento(Persona persona, int numDepto) {
        Departamento depto = this.buscarDepartamento(numDepto);
        if (depto == null){
            System.out.println("Número de departamento solicitado NO EXISTE");
            return;
        }
        depto.alquilarA(persona);

    }
}
