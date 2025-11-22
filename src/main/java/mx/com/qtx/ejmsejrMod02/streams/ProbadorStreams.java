package mx.com.qtx.ejmsejrMod02.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProbadorStreams {
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
    public static void main(String[] args) {
    //    test_BasicosDeStream();
     //   testStreamConMapRecord();
          testSorted();

    }

    private static void testSorted() {
        record GatoFlaco(String nombre,Double peso){}
        ;
        List<Gato> lstGatos1 = new ArrayList<>(lstMininos);

        List<GatoFlaco> lstGatosFlacos = lstGatos1.stream()
                .filter(gatoI -> gatoI.getPesoEnKg() < 7)
                .map(gatoI -> new GatoFlaco(gatoI.getNombre(), gatoI.getPesoEnKg()))
                .sorted((gf1,gf2)-> (gf1.peso() < gf2.peso ? -1 : 1))
                .toList();
        System.out.println("lstGatosFlacos = " + lstGatosFlacos);
    }

    private static void testStreamConMapRecord() {
        record GatoFlaco(String nombre,Double peso){}
        ;
        List<Gato> lstGatos1 = new ArrayList<>(lstMininos);

        List<GatoFlaco> lstGatosFlacos = lstGatos1.stream()
                    .filter(gatoI -> gatoI.getPesoEnKg() < 7)
                    .map(gatoI -> new GatoFlaco(gatoI.getNombre(), gatoI.getPesoEnKg()))
                    .toList();
        System.out.println("lstGatosFlacos = " + lstGatosFlacos);

        Stream<GatoFlaco> streamGatosFlacos = lstGatos1.stream()
                .filter(gatoI -> gatoI.getPesoEnKg() < 7)
                .map(gatoI -> new GatoFlaco(gatoI.getNombre(), gatoI.getPesoEnKg()));
        int nGatosFlacos = (int) streamGatosFlacos.count();
        System.out.println("\nnGatosFlacos = " + nGatosFlacos);
    }

    private static void test_BasicosDeStream() {
        List<Gato> lstGatos1 = new ArrayList<>(lstMininos);
        Stream<Gato> streamGatos = lstGatos1.stream();
        Stream<String> streamCads = streamGatos.map(gatoI -> gatoI.getNombre() + " pesa "
                                  + String.format("%4.2f", gatoI.getPesoEnKg()) + " Kg.");
        List<String> lstCads = streamCads.toList(); //Operacion terminal
        System.out.println(lstCads);

        List<String> lstCads2 = lstGatos1.stream()
                                    .map(gatoI -> gatoI.getNombre() + " pesa "
                                             + String.format("%4.2f", gatoI.getPesoEnKg()) + " Kg.")
                                    .toList();
        System.out.println("\nlstCads2 = " + lstCads2);

        List<Gato>  lstGatosFlacos = lstGatos1.stream()
                .filter(gatoI -> gatoI.getPesoEnKg() < 7)
                .toList();
        System.out.println("\nlstGatosFlacos = " + lstGatosFlacos);
    }
}
