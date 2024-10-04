import java.util.List;

public class Fila <E extends Comparable<E>> implements Comparable<Fila<E>> {
    private List<E> celdas;

    public Fila(List<E> fila){
        celdas = fila;
    }

    @Override
    public int compareTo(Fila<E> o) {
        //¿como comparo dos filas??
        if (o == null){
            throw new NullPointerException();
        }
        //si this.celdas tiene más elementos que o.celdas seré mayor
        int comparacion = celdas.size() - o.celdas.size();
        int i = 0;
        while (comparacion == 0 && i < celdas.size()) {
            comparacion = celdas.get(i).compareTo(o.celdas.get(i));
            i++;            
        }
        return comparacion;
    }

    
}
