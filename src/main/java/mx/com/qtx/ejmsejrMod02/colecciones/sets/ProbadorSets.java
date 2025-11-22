package mx.com.qtx.ejmsejrMod02.colecciones.sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ProbadorSets {
    public static void main(String[] args) {
        List<String> lstDias = new ArrayList<>(List.of(
                "lunes","martes","miércoles","jueves","viernes","sábado", "domingo"));
        
        Set<String> setDias = new TreeSet<>();
        setDias.addAll(lstDias);
        for(String diaI:setDias){
            System.out.println("diaI = " + diaI);
        }
    }
}
