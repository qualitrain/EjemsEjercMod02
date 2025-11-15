package mx.com.qtx.ejmsejrMod02.colecciones;

public class TestDepartamento {
    public static void main(String[] args) {
        Departamento deptoA = new Departamento(5,true,"José Mora Luna",7000);
        Departamento clonDeptoA;
        
 //       clonDeptoA = deptoA; // ERROR y HORROR
        System.out.println("deptoA.hashCode() = " + deptoA.hashCode());
        clonDeptoA = deptoA.clonar();
        System.out.println("clonDeptoA.hashCode() = " + clonDeptoA.hashCode());

        Departamento deptoC = new Departamento();

        // ¿Cual es la mejor opción? ¿Todas son válidas?
        deptoA.copiarA(deptoC); //Dice Héctor que vota por esta
        deptoC.copiarDesde(deptoA);
        // deptoA.copiar(deptoA,deptoC); //Dice Vini que esta NO
        Departamento.copiar(deptoA,deptoC); // Fue anticipada por Víctor
    }
}
