package mx.com.qtx.ejmsejrMod02.mapas;

import mx.com.qtx.ejmsejrMod02.colecciones.Persona;
import mx.com.qtx.ejmsejrMod02.streams.Gato;

import java.util.*;
import java.util.stream.Collectors;

public class ProbadorMaps {
    private static List<Gato> lstMininos = List.of(
            new Gato(500,"Félix","Angora",5.3),
            new Gato(3,"Demóstenes","Angora",7.7),
            new Gato(7,"Panza","Siamés",6.5),
            new Gato(17,"Danilo","Criollo",6.2),
            new Gato(70,"Hermilo","Criollo",6.4),
            new Gato(34,"Cucho","Abisinio",9.2),
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
    //    testMapaBasico();
    //    testMapObjVsObj();
    //    testMetodosCreacionMapas();
    //    testIteracionesDeMapas_forEachSobreLlaves();
    //    testIteracionesDeMapas_forEachSobreValores();
    //    testIteracionesDeMapas_forEachSobreEntry();

        ejercicioMapaGatosXraza();
    }

    private static void ejercicioMapaGatosXraza() {
        Map<Integer, Gato> mapGatos = getMapGatos();

        Map<String, Set<Gato>> mapGatosXRaza = getMapGatosXraza(mapGatos);
        for(String razaI:mapGatosXRaza.keySet()){
            Set<Gato> bolsaDeGatos = mapGatosXRaza.get(razaI);
            String nomGatos = bolsaDeGatos.stream()
                                          .map(gatoI->gatoI.getNombre())
                                          .collect(Collectors.joining(", "));
            System.out.println("Los gatos de raza " + razaI + " son:" + nomGatos);
        }
        /* Otra opcion: Me "caso" con List
        Map<String, List<Gato>> mapGatosXRaza = getMapGatosXraza(mapGatos);
         */

        /* Otar opción: No me "caso" ni con List ni con Set
        Map<String, Collection<Gato>> = getMapGatosXraza(mapGatos);
         */

        mapGatosXRaza.forEach((k,v)-> {
            System.out.print("raza = " + k );
            System.out.println(", gatos =  " + v.stream()
                                                .map(gatI->gatI.getNombre())
                                                .collect(Collectors.joining(", ")));
        });
    }

    private static Map<String, Set<Gato>> getMapGatosXraza(Map<Integer, Gato> mapGatos) {
        Map<String, Set<Gato>> mapGatosXraza = new HashMap<>();
        for(Gato gatoI: mapGatos.values()){
            String raza = gatoI.getRaza();
            Set<Gato> gatosDeRaza = mapGatosXraza.getOrDefault(raza, new HashSet<>());
            gatosDeRaza.add(gatoI);
            mapGatosXraza.put(raza,gatosDeRaza);
        }
        return mapGatosXraza;
    }

    private static void testIteracionesDeMapas_forEachSobreEntry() {
        Map<Integer, Gato> mapGatos = getMapGatos();
        for(var parOrdenadoI:mapGatos.entrySet()){
            System.out.println("llave:" + parOrdenadoI.getKey());
            System.out.println("valor:" + parOrdenadoI.getValue());
        }
    }

    private static void testIteracionesDeMapas_forEachSobreValores() {
        Map<Integer, Gato> mapGatos = getMapGatos();
        for(Gato gatoI :mapGatos.values()){
            System.out.println("gatoI  = " + gatoI.getNombre() );
        }
    }

    private static void testIteracionesDeMapas_forEachSobreLlaves() {
        Map<String,Persona> mapPersonas = getMapPersonas();
        System.out.println("Las llaves del mapa de personas son:");
        for(String llavePersonaI : mapPersonas.keySet()){
            System.out.println("llavePersonaI = " + llavePersonaI);
            Persona personaI = mapPersonas.get(llavePersonaI);
            System.out.println("personaI = " + personaI);
        }
        System.out.println();
        String cadLlaves = mapPersonas.keySet().stream()
                                               .sorted()
                                               .collect(Collectors.joining(", "));
        System.out.println("cadLlaves = " + cadLlaves);
    }

    private static void testMetodosCreacionMapas() {
        Map<String,Persona> mapPersonas = getMapPersonas();
        System.out.println("Personas:");
        mapPersonas.forEach((k,v)-> System.out.println(String.format("%5s",k) + ": " + v));

        System.out.println("\nGatos:");
        Map<Integer,Gato> mapGatos = getMapGatos();
        mapGatos.forEach((k,v)->System.out.println(String.format("%5d",k) + ": " + v));
    }

    private static Map<String, Persona> getMapPersonas() {
        Map<String,Persona> mapPersonas = new HashMap<>();
        for(Persona personaI:lstPersonas){
            mapPersonas.put(personaI.getId(),personaI);
        }
        return mapPersonas;
    }

    private static Map<Integer,Gato> getMapGatos(){
        return lstMininos.stream()
                         .collect(Collectors.toMap(gatoI->gatoI.getNumero(),gatoI->gatoI));
    }

    private static void testMapObjVsObj() {
        Map<Persona, Gato> mapMascotas = new HashMap<>();
        mapMascotas.put(lstPersonas.get(1),lstMininos.get(3));
        mapMascotas.put(lstPersonas.get(2),lstMininos.get(4));
        mapMascotas.put(lstPersonas.get(3),lstMininos.get(6));
        mapMascotas.put(lstPersonas.get(0),lstMininos.get(0));

        for(Persona perK:mapMascotas.keySet()){
            Gato mascotaI = mapMascotas.get(perK);
            System.out.println(perK.getNombre() + " es responsable de " + mascotaI.getNombre());
        }
    }

    private static void testMapaBasico() {
        Map<String,Integer> mapMeses = new HashMap<>();

        mapMeses.put("enero",31);
        mapMeses.put("febrero",28);
        mapMeses.put("marzo",31);
        mapMeses.put("abril",30);
        mapMeses.put("mayo",31);
        mapMeses.put("junio",30);

        int nDiasMes1 = mapMeses.get("enero");
        System.out.println("Enero tiene = " + nDiasMes1);
    }
}
