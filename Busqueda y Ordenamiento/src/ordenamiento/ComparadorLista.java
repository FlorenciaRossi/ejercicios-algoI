package ordenamiento;
import java.util.Comparator;

public class ComparadorLista<T extends Comparable<T>> implements Comparator<T>{
    private int multiplicador;
    public ComparadorLista(boolean ascendente){
        if(ascendente){ multiplicador  = 1;}
        else{ multiplicador = -1; }
    }
    @Override
    public int compare(T o1, T o2) {
        return multiplicador*(o1.compareTo(o2));
    }

}
