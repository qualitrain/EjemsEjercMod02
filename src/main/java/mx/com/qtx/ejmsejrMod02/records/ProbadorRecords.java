package mx.com.qtx.ejmsejrMod02.records;

import java.util.List;

public class ProbadorRecords {

    public static void main(String[] args) {
        List<Mes> lstMeses = List.of(new Mes("enero",31),
                new Mes("febrero",28),
                new Mes("marzo",31),
                new Mes("abril",30)
        );
        for(Mes mesI:lstMeses){
            System.out.println( mesI.nombre() + " tiene " + mesI.nDias() + " dias");
        }
    }

}
