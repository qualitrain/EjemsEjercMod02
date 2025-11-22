package mx.com.qtx.ejmsejrMod02.mapas;

import mx.com.qtx.ejmsejrMod02.colecciones.Persona;
import mx.com.qtx.ejmsejrMod02.streams.Gato;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProbadorMaps {
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
    //    testMapaBasico();
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
