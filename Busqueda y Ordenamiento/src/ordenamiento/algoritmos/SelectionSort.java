package ordenamiento.algoritmos;

import java.util.List;

import ordenamiento.ComparadorLista;

public class SelectionSort <T extends Comparable<T>> implements AlgoritmoOrdenamiento<T>{

    @Override
    public void ordenar(List<T> lista, boolean ascendente) {
        selectionSort(lista, new ComparadorLista<>(ascendente));
    }

    public void selectionSort(List<T> lista, ComparadorLista<T> comparador) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int idxMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (comparador.compare(lista.get(j), lista.get(idxMinimo)) < 0) {
                    idxMinimo = j;
                }
            }
            // Intercambia el mínimo encontrado con el elemento en la posición i
            T temp = lista.get(i);
            lista.set(i, lista.get(idxMinimo));
            lista.set(idxMinimo, temp);
        }
    }

}
