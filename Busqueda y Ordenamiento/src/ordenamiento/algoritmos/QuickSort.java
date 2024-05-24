package ordenamiento.algoritmos;

import java.util.List;

import ordenamiento.ComparadorLista;

public class QuickSort<T extends Comparable<T>> implements AlgoritmoOrdenamiento<T>{

    @Override
    public void ordenar(List<T> lista, boolean ascendente) {
        quickSort(lista, new ComparadorLista<>(ascendente));
    }

    public void quickSort(List<T> lista, ComparadorLista<T> comparador) {
        quickSortRec(lista, 0, lista.size() - 1, comparador);
    }
    
    public void quickSortRec(List<T> lista, int inicio, int fin, ComparadorLista<T> comparador) {
        if (inicio < fin) {
            int indicePivot = partition(lista, inicio, fin, comparador);
            quickSortRec(lista, inicio, indicePivot - 1, comparador);
            quickSortRec(lista, indicePivot + 1, fin, comparador);
        }
    }
    
    public int partition(List<T> lista, int inicio, int fin, ComparadorLista<T> comparador) {
        T pivot = lista.get(fin);   // El último elemento como pivote
        int i = inicio;
        int j = fin - 1;
    
        while (i <= j) {        
            while (i <= j && comparador.compare(lista.get(i), pivot) <= 0) {
                i++;
            }
            while (i <= j && comparador.compare(lista.get(j), pivot) > 0) {
                j--;
            }
            if (i < j) {
                // Intercambiamos arreglo[i] y arreglo[j]
                T temp = lista.get(i);
                lista.set(i++, lista.get(j));
                lista.set(j--, temp);
            }
        }
        
        // Intercambiamos arreglo[fin] y arreglo[i]
        T temp = pivot;
        lista.set(fin, lista.get(i));
        lista.set(i, temp);
        return i; // Devolvemos la posición del pivote después de la partición
    }

}
