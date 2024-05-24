package ordenamiento.algoritmos;

import java.util.List;

import ordenamiento.ComparadorLista;

public class InsertionSort <T extends Comparable<T>> implements AlgoritmoOrdenamiento<T> {

    @Override
    public void ordenar(List<T> lista, boolean ascendente) {
       insertionSort(lista, new ComparadorLista<>(ascendente));
    }

    public void insertionSort(List<T> lista, ComparadorLista<T> comparador) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            T aInsertar = lista.get(i);
            int j = i - 1;
            while (j >= 0 && comparador.compare(aInsertar, lista.get(j)) < 0) {
                // Movemos a la derecha el elemento actual
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, aInsertar);

        }
    }

}
