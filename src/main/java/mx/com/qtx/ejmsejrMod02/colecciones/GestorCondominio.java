package mx.com.qtx.ejmsejrMod02.colecciones;

/**
 *  Ofrecer los servicios que permiten administrar un Condominio
 */
public class GestorCondominio {

    public static void main(String[] args) {
        testFuncionesBasicas();
        testRentarDepartamento();
        testAsignarAdminitradorAcondominio();
    }

    private static void testAsignarAdminitradorAcondominio() {
        Condominio condAngeles = new Condominio("Av. Insurgentes Norte 255","Julio Pérez Domínguez");
        Persona persona = new Persona("Efraín Méndez Pérez","345-2","55-1122-3245");
        condAngeles.setAdministrador(persona);
        System.out.println("condAngeles = " + condAngeles);
        System.out.println("persona = " + persona);
    }

    private static void testRentarDepartamento() {
        Condominio condAngeles = new Condominio("Av. Insurgentes Norte 255","Julio Pérez Domínguez");
        Persona persona = new Persona("Efraín Méndez Pérez","345-2","55-1122-3245");
        condAngeles.alquilarDepartamento(persona,1);

        System.out.println("persona = " + persona);
        System.out.println("condAngeles = " + condAngeles);
    }

    private static void testFuncionesBasicas() {
        Condominio condAngeles = new Condominio("Av. Insurgentes Norte 255","Julio Pérez Domínguez");
        int nDepto = condAngeles.getNumDeptoDisponible();
        if(nDepto == Condominio.DEPTO_NO_DISPONIBLE){
            System.out.println("Lo sentimos, de momento no hay departamentos disponibles");
            return;
        }
        condAngeles.registrarInquilino(2,"Laura Fernández Mora");
        System.out.println("condAngeles = " + condAngeles);

        System.out.println("---------------------------------------");

        Condominio clonCondominio = condAngeles.clonar();
        System.out.println("clonCondominio = " + clonCondominio);


        Condominio condCopiado = new Condominio();
        condAngeles.copiarA(condCopiado);

        System.out.println("condCopiado = " + condCopiado);
        condAngeles.setDepartamento(2, true,"Rosario Luna Paz",8000, 0);

        System.out.println("\n-------------------------------------\n");
        System.out.println("condAngeles = " + condAngeles);
        System.out.println("condCopiado = " + condCopiado);
    }


}
