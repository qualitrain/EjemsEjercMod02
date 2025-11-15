package mx.com.qtx.ejmsejrMod02.colecciones;

/**
 * Responsabilidad: Administrar datos de un Condominio
 */
public class Condominio {
    public static final int DEPTO_NO_DISPONIBLE = -1;

    private String direccion;
    private Departamento depto1;
    private Departamento depto2;
    private Departamento depto3;
    private Departamento depto4;
//    private String nombreAdministrador;
    private Persona administrador;

    @Deprecated
    public Condominio(String direccion, String nombreAdministrador) {
        this.direccion = direccion;
    //    this.nombreAdministrador = null;

        this.depto1 = new Departamento(1,false,null,7500.00);
        this.depto2 = new Departamento(2,false,null,8500.00);
        this.depto3 = new Departamento(3,false,null,9000.00);
        this.depto4 = new Departamento(4,false,null,8000.00);
     }
    public Condominio(String direccion, Persona administrador) {
        this.direccion = direccion;
        this.administrador = administrador;
    //    this.nombreAdministrador = null;

        this.depto1 = new Departamento(1,false,null,7500.00);
        this.depto2 = new Departamento(2,false,null,8500.00);
        this.depto3 = new Departamento(3,false,null,9000.00);
        this.depto4 = new Departamento(4,false,null,8000.00);
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
        switch(pos + 1){
            case 1 -> {
                this.depto1 = nvoDepto;
            }
            case 2 ->{
                this.depto2 = nvoDepto;
            }
            case 3 ->{
                this.depto3 = nvoDepto;
            }
            case 4 ->{
                this.depto4 = nvoDepto;
            }
            default -> {
                System.out.println("Número de departamento solicitado NO EXISTE");
            }
        }
     }

    public Condominio() {
        this.depto1 = new Departamento();
        this.depto2 = new Departamento();
        this.depto3 = new Departamento();
        this.depto4 = new Departamento();
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
//        this.nombreAdministrador = nombreAdministrador;
    }

    @Override
    public String toString() {
        String nombreAdministrador = "No hay administrador";
        if(this.administrador != null){
            nombreAdministrador = this.administrador.getNombre();
        }
        String cadCondominio = "Condominio{" +
                "direccion='" + direccion + '\'' +
                ", depto1=" + depto1 +
                ", depto2=" + depto2 +
                ", depto3=" + depto3 +
                ", depto4=" + depto4 +
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
        if(numDeptoBuscado == this.depto1.getNumero())
            return this.depto1;
        if(numDeptoBuscado == this.depto2.getNumero())
            return this.depto2;
        if(numDeptoBuscado == this.depto3.getNumero())
            return this.depto3;
        if(numDeptoBuscado == this.depto4.getNumero())
            return this.depto4;
        return null;
    }

    public int getNumDeptoDisponible() {
        if(this.depto1.isOcupado() == false)
            return this.depto1.getNumero();
        if(this.depto2.isOcupado() == false)
            return this.depto2.getNumero();
        if(this.depto3.isOcupado() == false)
            return this.depto3.getNumero();
        if(this.depto4.isOcupado() == false)
            return this.depto4.getNumero();
        return Condominio.DEPTO_NO_DISPONIBLE;
    }

    public Condominio clonar() {
        Condominio clon = new Condominio();
        clon.direccion = this.direccion;
//        clon.nombreAdministrador = this.nombreAdministrador;
        clon.depto1 = this.depto1.clonar();
        clon.depto2 = this.depto2.clonar();
        clon.depto3 = this.depto3.clonar();
        clon.depto4 = this.depto4.clonar();
        if(this.administrador != null)
            clon.administrador = this.administrador.clonar();
        return clon;
    }

    public void copiarA(Condominio cndDestino) {
        cndDestino.direccion = this.direccion;
        if(this.administrador != null)
            administrador.copiarDesde(this.administrador);
 //       cndDestino.nombreAdministrador = this.nombreAdministrador;
        cndDestino.depto1.copiarDesde(this.depto1);
        cndDestino.depto2.copiarDesde(this.depto2);
        cndDestino.depto3.copiarDesde(this.depto3);
        cndDestino.depto4.copiarDesde(this.depto4);
    }

    public void alquilarDepartamento(Persona persona, int numDepto) {
        switch(numDepto){
            case 1-> {
                this.depto1.alquilarA(persona);
            }
            case 2-> {
                this.depto2.alquilarA(persona);
            }
            case 3-> {
                this.depto3.alquilarA(persona);
            }
            case 4-> {
                this.depto4.alquilarA(persona);
            }
            default -> {
                System.out.println("Número de departamento solicitado NO EXISTE");
            }

        }
    }
}
