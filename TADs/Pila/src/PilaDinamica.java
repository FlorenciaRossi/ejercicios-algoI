import java.util.ArrayList;
import java.util.List;

public class PilaDinamica<T> implements Pila<T>{
    private List<T> elementos;
    
    public PilaDinamica() {
        elementos = new ArrayList<>();
    }

    @Override
    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public T tope() {
        if (esVacia()){
            throw new RuntimeException("Pila vacía");
        }
        return elementos.getLast();
    }

    @Override
    public T desapilar() {
        return elementos.removeLast();
    }

    @Override
    public boolean esVacia() {
       return elementos.isEmpty();
    }

    @Override
    public String toString() {
        String pila = "";
        for (T e : elementos){
            pila += e.toString() + " ";
        }
        return pila;
    }
}
