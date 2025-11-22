package mx.com.qtx.ejmsejrMod02.colecciones.sets;

import java.util.Comparator;

public class ComparadorPerrosXId implements Comparator<Perro> {
    @Override
    public int compare(Perro perro1, Perro perro2) {
        if(perro1.id() < perro2.id())
            return -1;
        if(perro1.id() == perro2.id())
            return 0;
        return 1;
    }
}
