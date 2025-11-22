package mx.com.qtx.ejmsejrMod02.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProbadorIterator {
    public static void main(String[] args) {
        List<String> lstDias =  new ArrayList<>(List.of("lunes","martes","miércoles","jueves","viernes"));
        Iterator<String> itDias = lstDias.iterator();
        System.out.println("itDias.getClass().getName() = " + itDias.getClass().getName());
        lstDias.add("sábado");
        while(itDias.hasNext()){
            String cadI = itDias.next();
            System.out.println("cadI = " + cadI);
        }

        
    }
}
