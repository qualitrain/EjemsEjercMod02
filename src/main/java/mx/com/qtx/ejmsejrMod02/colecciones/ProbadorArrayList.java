package mx.com.qtx.ejmsejrMod02.colecciones;

import javax.lang.model.SourceVersion;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ProbadorArrayList {
    public static void main(String[] args) {
     //   probarMetodosBasicosArrayList();
     //   probarUtilCalendario();
        probarChequeoDeTipo();
    }

    private static void probarChequeoDeTipo() {
        int n = (int)(Math.random() * 1000);
        Object objeto;
        if(n % 2 == 0){
            objeto = "Una cadena";
        }
        else{
            objeto = new BigDecimal("505.05");
        }
        if(esString(objeto)){
            System.out.println("objeto es un String");
        }
        else{
            System.out.println("objeto no es un String");
        }
    }

    private static void probarUtilCalendario() {
//        UtilCalendario utilCalendario = new UtilCalendario(2025);
        UtilCalendario utilCalendario = new UtilCalendario(2025,"LinkedList");

        int nDias = 28;
        ArrayList<String> lstMeses = utilCalendario.getMesesConNDias(nDias);

        System.out.println("meses de " +
                nDias + " dias = " + lstMeses);
        String mes = "Abril ";
        int nDiasMes = utilCalendario.getDiasMes(mes);
        System.out.println("n Dias " +
                mes + " = " + nDiasMes);
    }

    private static boolean esString(Object objX){
        System.out.println("objX.getClass().getName() = " + objX.getClass().getName());
        System.out.println("objX = " + objX);
        if(objX instanceof String){
            return true;
        }
        return false;
    }

    private static void probarMetodosBasicosArrayList() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(55); //Lo agrega en la posición cero
        for(int i=0; i<50; i++){
            int numRandon= (int)(Math.random() * 1000);
            numeros.add(numRandon);
        }

        for(int i=0; i<numeros.size(); i++){
            System.out.println("numeros.get(" + i + ") = " + numeros.get(i));
        }
        System.out.println("numeros.size() = " + numeros.size());
        System.out.println("------------------------------------");
        numeros.add(0,9999);
        for(Integer numI:numeros){
            System.out.println("numeros.get(" + "?" + ") = " + numI);
        }
        System.out.println("numeros.size() = " + numeros.size());
        System.out.println("------------------------------------");

        numeros.set(2,777777);
        numeros.forEach(x -> System.out.println("numeros[?] = " + x));
        System.out.println("numeros.size() = " + numeros.size());

        System.out.println("------------------------------------");

        //   numeros.add(60,-1000); //Generar error porque sale de las fronteras físicas del arraylist
        numeros.remove(0);
        numeros.remove(0);
        numeros.remove(0);

        numeros.forEach(x -> System.out.println("numeros[?] = " + x));
        System.out.println("numeros.size() = " + numeros.size());
    }
}
