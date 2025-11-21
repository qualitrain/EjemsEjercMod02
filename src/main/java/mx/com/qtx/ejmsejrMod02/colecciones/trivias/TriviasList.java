package mx.com.qtx.ejmsejrMod02.colecciones.trivias;

import mx.com.qtx.ejmsejrMod02.colecciones.Departamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriviasList {
    public static void main(String[] args) {
//        trivia_listObjects();
//        trivia_listOf();
  //        trivia_inmutablesForEach();
   //     trivia_opersList();
    //      trivia_agregarElemsAlista();
        trivia_set();
    }

    private static void trivia_set() {
        ArrayList<String> meses = new ArrayList<>();
        meses.set(0,"enero");
        meses.set(1,"febrero");
        meses.set(2,"marzo");
        System.out.println("meses = " + meses);
    }

    private static void trivia_agregarElemsAlista() {
        ArrayList<String> meses = new ArrayList<>();
        meses.add(0,"enero");
        meses.add(1,"febrero");
        meses.add(2,"marzo");
        System.out.println("meses = " + meses);
    }

    private static void trivia_opersList() {
        List<String> diasLaborables = List.of("lunes","martes","miércoles","jueves","viernes");
        List<String> diasDescanso = List.of("sábado", "domingo");

        List<String> lstDias01 = new ArrayList<>(diasLaborables);
        List<String> lstDias02 = new ArrayList<>(diasDescanso);

        List<String> lstOtrosDias = lstDias01;

        List<String> lstDisAlReves = lstDias01.reversed();
        lstDisAlReves.forEach(diaI-> System.out.println("diaI = " + diaI)); // que despliega ?

        System.out.println("----------------------------");
        lstDias01.remove("Lunes");
        lstDias01.forEach(diaI-> System.out.println("diaI = " + diaI)); // que despliega ?

        System.out.println("----------------------------");
        lstDias01.addAll(List.of("sábado","domingo"));

        lstOtrosDias.forEach(diaI-> System.out.println("diaI = " + diaI));
    }

    private static void trivia_inmutablesForEach() {
        ArrayList<String> lstCads = new ArrayList<>(List.of("hola","a","todos"));
        lstCads.addAll(List.of("los", "colegas", "del","diplomado"));
        lstCads.addAll(0, Arrays.asList("Saludemos","a","todos"));

        String[] arrCads = lstCads.toArray(new String[0]);
        for(String cadI:arrCads)
            System.out.println("cadI = " + cadI);

        System.out.println("----------------------------");
        for(String cadI:lstCads)
            System.out.println("cadI = " + cadI);
    }

    private static void trivia_listObjects() {
        List<Object> lstObjetos = new ArrayList<>();
        lstObjetos.add(new BigDecimal("55.80"));
        lstObjetos.add(0,"Precio");
        lstObjetos.add("Cantidad");
        lstObjetos.add(5);

        lstObjetos.forEach(elemI-> System.out.print(elemI + ", "));

        BigDecimal precio = (BigDecimal) lstObjetos.get(1);
        int cantidad = (Integer)lstObjetos.get(3);
        BigDecimal cant = BigDecimal.valueOf(cantidad);
        BigDecimal total = precio.multiply(cant);
        lstObjetos.add(total);

        System.out.println();
        for(Object elemI:lstObjetos){
            System.out.print(elemI + ", ");
        }
    }

    private static void trivia_listOf() {
        List<Departamento> lstDeptos = List.of(new Departamento(400,false,"Disponible",15000),
                                               new Departamento(501,true,"Fito Paez",12000));

        System.out.println("lstDeptos = " + lstDeptos);
    }
}
//