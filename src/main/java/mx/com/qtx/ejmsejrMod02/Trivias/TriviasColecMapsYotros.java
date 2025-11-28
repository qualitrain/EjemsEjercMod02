package mx.com.qtx.ejmsejrMod02.Trivias;

import mx.com.qtx.ejmsejrMod02.colecciones.Persona;
import mx.com.qtx.ejmsejrMod02.streams.Gato;

import java.util.*;
import java.util.stream.Collectors;

record GatoCorto(String raza,String nombre){};
public class TriviasColecMapsYotros {

    private static List<Gato> lstMininos = List.of(
            new Gato(500,"Félix","Angora",5.3),
            new Gato(3,"Demóstenes","Angora",7.7),
            new Gato(7,"Panza","Siamés",6.5),
            new Gato(17,"Danilo","Criollo",6.2),
            new Gato(70,"Hermilo","Birmano",6.4),
            new Gato(34,"Cucho","Burmés",9.2),
            new Gato(65,"Benito","Abisinio",10.3),
            new Gato(200,"Micifuz","Persa",8.1)
    );
    private static List<Persona> lstPersonas = List.of(
            new Persona("Carlos","P-1","5511223344"),
            new Persona("Laura","P-20","55156723344"),
            new Persona("Manuel","P-230","72156723344"),
            new Persona("Jimena","P-11","5533423344")
    );

    public static void main(String[] args) {
        triviaSetsVsLists01();
    //    triviaSetsConLambdas();
    //    triviaSetsDistintosTipos();
    }

    private static void triviaSetsDistintosTipos() {
        Set<Gato> setGatos1 = new LinkedHashSet<>(lstMininos);
        setGatos1.addAll(lstMininos);
        var cadGats1 = setGatos1.stream().map(g->g.getNombre()).collect(Collectors.joining(","));
        System.out.println("cadGats1 = " + cadGats1);

        Set<Gato> setGatos2 = new TreeSet<>( (g1,g2)->( g1.getNombre() ).compareTo( g2.getNombre() ) < 0 ? -1 : 1);
        setGatos2.addAll(setGatos1);

        Set<Gato> setGatos3 = new LinkedHashSet<>();
        setGatos3.addAll(setGatos2);

        var cadGats2 = setGatos2.stream().map(g->g.getNombre()).collect(Collectors.joining(","));
        var cadGats3 = setGatos3.stream().map(g->g.getNombre()).collect(Collectors.joining(","));
        if(cadGats2.compareTo(cadGats3) == 0){
            System.out.println("Las cadenas cadGtas2 y cadGats3 son iguales");
        }
        else{
            System.out.println("Las cadenas cadGtas2 y cadGats3 son distintas");
        }

        System.out.println("cadGats2 = " + cadGats2);
        System.out.println("cadGats3 = " + cadGats3);
    }

    private static void triviaSetsConLambdas() {
        Set<Gato> setGatos = new TreeSet<>( (g1,g2)->( g1.getRaza()+g1.getNombre() ).compareTo( g2.getRaza()+g2.getNombre() ));
        setGatos.addAll(lstMininos);
        setGatos.stream()
                .map(g->new GatoCorto(g.getRaza(), g.getNombre()))
                .forEach(System.out::println);
    }

    private static void triviaSetsVsLists01() {
        List<Gato> gatillos = new ArrayList<>(lstMininos);
        Gato gatoMalo = new Gato(666,"Belcebú","Bengalí", 15.5);
        gatillos.add(new Gato(65,"Benito","Abisinio",10.3));
        gatillos.add(5,new Gato(65,"Benito","Abisinio",10.3));
        gatillos.add(0,gatoMalo);
        gatillos.add(gatoMalo);

        int nGatos = gatillos.size();
        System.out.println("hay " + nGatos + " gatos"); // ¿Cuantos gatos hay?

        Set<Gato> setGatitos = new LinkedHashSet<>(gatillos);
        desplegarGatos(setGatitos);
    }

    private static void desplegarGatos(Set<Gato> setGatitos) {
        int nGatos = setGatitos.size();
        System.out.println("\nhay " + nGatos + " gatos"); // ¿Cuantos gatos hay?
        
        var cad = setGatitos.stream()
                            .map(gatI -> gatI.getNombre())
                            .sorted()
                            .collect(Collectors.joining(", "));
        System.out.println("cad = " + cad); // ¿Qué muestra exactamente?


    }
}
