package ordenamiento.algoritmos;

import java.util.List;

import ordenamiento.ComparadorLista;

public class BubbleSort<T extends Comparable<T>> implements AlgoritmoOrdenamiento<T>{

    @Override
    public void ordenar(List<T> lista, boolean ascendente) {
        bubbleSort(lista, new ComparadorLista<>(ascendente));
    }

    public void bubbleSort(List<T> lista, ComparadorLista<T> comparador) {
        int n = lista.size();
        boolean huboCambio;
        do {
            huboCambio = false;
            for (int i = 1; i < n; i++) {
                if ( comparador.compare(lista.get(i - 1), lista.get(i)) > 0){
                    // Intercambia arreglo[i-1] y arreglo[i]
                    T aux = lista.get(i - 1);
                    lista.set(i - 1, lista.get(i));
                    lista.set(i, aux);
                    huboCambio = true;
                }
             }
            n--;
        } while (huboCambio);
    }
}

