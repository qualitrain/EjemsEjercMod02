package mx.com.qtx.ejmsejrMod02.colecciones;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UtilCalendario {
    private final static Integer[] DIAS_X_MES = {
            31, 28, 31, 30,
            31, 30, 31, 31,
            30, 31, 30 ,31
    };
    private final static String[] MESES = {
            "enero", "febrero","marzo", "abril",
            "mayo", "junio", "julio", "agosto",
            "septiembre","octubre","noviembre","diciembre"
    };
    private List<Integer> diasXmes;
    private List<String> meses;

    public UtilCalendario(int anio) {
        this.diasXmes = List.of(DIAS_X_MES);
        this.meses = List.of(MESES);

        if(esBisiesto(anio)){
            this.diasXmes.set(1,29);
        }
    }
    public UtilCalendario(int anio, String tipoLista) {
        if(tipoLista.equalsIgnoreCase("ArrayList"))
            this.diasXmes = new ArrayList<>();
        else
            this.diasXmes = new LinkedList<>();

        for(Integer nDiasMesI:DIAS_X_MES)
            this.diasXmes.add(nDiasMesI);

        if(tipoLista.equalsIgnoreCase("ArrayList"))
            this.meses = new ArrayList<>();
        else
            this.meses = new LinkedList<>();

        for(String mesI: MESES)
            this.meses.add(mesI);

        if(esBisiesto(anio)){
            this.diasXmes.set(1,29);
        }
    }

    private boolean esBisiesto(int anio) {
        if(anio % 4 == 0)
            return true;
        return false;
    }

    public ArrayList<String> getMesesConNDias(int nDias) {
        ArrayList<String> mesesDeNdias = new ArrayList<>();

        for(int i=0;i<this.diasXmes.size();i++){
            if(this.diasXmes.get(i) == nDias){
                mesesDeNdias.add(this.meses.get(i));
            }
        }

        return mesesDeNdias;
    }

    public String[] getMesesConNDiasString(int nDias){
        return this.getMesesConNDias(nDias).toArray(new String[0]);
    }

    public int getDiasMes(String nombreMes) {
        if(nombreMes == null)
            return -2;
        int iMes =this.meses.indexOf(nombreMes.trim().toLowerCase());
        if(iMes == -1)
            return -1;
        return this.diasXmes.get(iMes);
    }
}
