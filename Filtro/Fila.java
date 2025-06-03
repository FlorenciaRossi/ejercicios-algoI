import java.util.List;

public class Fila<T extends Comparable<T>> implements Comparable<Fila<T>> {
    private final List<T> celdas;

    public Fila(List<T> celdas) {
        this.celdas = celdas;
    }

    public List<T> getCeldas() {
        return celdas;
    }

    @Override
    public int compareTo(Fila<T> o) {
        if (o == null)
            throw new NullPointerException();
        
        int comparacion = 0, i = 0;
        while(comparacion == 0 && i < celdas.size() && i < o.celdas.size()) {
            comparacion = celdas.get(i).compareTo(o.celdas.get(i));
            i++;
        }
        return comparacion;
    }
    
}
