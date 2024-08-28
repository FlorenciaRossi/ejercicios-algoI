import java.util.Arrays;

public class PilaEstatica implements Pila<Integer> {

    private static final int AUMENTO_CAPACIDAD = 5;
    private Integer[] elementos;
    private int tamaño;

    public PilaEstatica() {
        this(10);
    }
    public PilaEstatica(int capacidad) {
        elementos = new Integer[capacidad];
        tamaño = 0;
    }
    @Override
    public void apilar(Integer e) {
        if (estaLlena()) {
            elementos = Arrays.copyOf(elementos, tamaño + AUMENTO_CAPACIDAD);
        }
        elementos[tamaño++] = e;

    }
    private boolean estaLlena() {
       return tamaño >= elementos.length;
    }

    @Override
    public Integer tope() {
        if (esVacia()) {
            throw new RuntimeException("Pila vacía");
        }
        return elementos[tamaño-1];
    }

    @Override
    public Integer desapilar() {
        Integer tope = tope();
        tamaño--;
        // reduce la capacidad del arreglo de ser necesario
        if (tamaño < elementos.length / 2) {
            elementos = Arrays.copyOf(elementos, tamaño + AUMENTO_CAPACIDAD);
        }
        return tope;
    }

    @Override
    public boolean esVacia() {
      return tamaño == 0;
    }      

    @Override
    public String toString() {
        String pila = "";
        for (int i = 0; i < tamaño; i++){
            pila += elementos[i] + " ";
        }
        return pila;
    }
}