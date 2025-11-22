package mx.com.qtx.ejmsejrMod02.colecciones.sets;

import java.util.*;

public class EjercicioSets {
    // Crear una lista inmutable de perros con: id entero, nombre y raza. Usando Records
    // Formarla con los perros Firulais, Nubecita, Killer, Campeón, Rey, Frijol y Trapito.
    // Proponiendo razas e identificador (repita algunas razas)
    // Ordene los perros:
    // a) por Id
    // b) Por nombre;
    // c) Por raza
    public static void main(String[] args) {
        List<Perro> lstPerros = List.of(
                new Perro(21, "Firulais" ,"Dálmata"),
                new Perro(2, "Nubecita" ,"Boxer"),
                new Perro(25, "Killer" ,"French Poodle"),
                new Perro(33, "Campeón" ,"Pastor Alemán"),
                new Perro(17, "Rey" ,"Dálmata"),
                new Perro(4, "Frijol" ,"Boxer"),
                new Perro(1, "Trapito" ,"Chihuahua")
                );

        Set<Perro> setPerros1 = new HashSet<>(lstPerros);
        Set<Perro> setPerros2 = new LinkedHashSet<>(lstPerros);

        Set<Perro> setPerros3 = new TreeSet<>(new ComparadorPerrosXId());

        Comparator<Perro> comparador = (p1, p2)->{
            return p1.nombre().compareToIgnoreCase(p2.nombre());
        };

        // Notacion lambda súper breve
        Comparator<Perro> comparadorBreve = (p1, p2) ->  p1.nombre().compareToIgnoreCase(p2.nombre());

        Set<Perro> setPerros4 = new TreeSet<>(comparador);
        setPerros4.addAll(lstPerros);

        mostrarPerros(setPerros1);
        mostrarPerros(setPerros2);
        mostrarPerros(setPerros3);
        mostrarPerros(setPerros4);
    }

    private static void mostrarPerros(Set<Perro> setPerros) {
        System.out.println("\n------------------------------");
        System.out.println("Implementación de Set utilizada:" + setPerros.getClass().getSimpleName());
        for(Perro perroI:setPerros){
            System.out.println("perroI = " + perroI);
        }
    }
}
