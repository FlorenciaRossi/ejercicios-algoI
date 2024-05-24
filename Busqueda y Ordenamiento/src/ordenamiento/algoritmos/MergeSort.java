package ordenamiento.algoritmos;

import java.util.ArrayList;
import java.util.List;

import ordenamiento.ComparadorLista;

public class MergeSort<T extends Comparable<T>> implements AlgoritmoOrdenamiento<T>{

    @Override
    public void ordenar(List<T> lista, boolean ascendente) {
        mergeSort(lista, ascendente);
    }

    public static<T extends Comparable<T>> void mergeSort(List<T> arreglo, boolean ascendente) {
        mergeSortRec(arreglo, 0, arreglo.size() - 1, ascendente);
    }
    
    public static<T extends Comparable<T>> void mergeSortRec(List<T> arreglo, int inicio, int fin, boolean ascendente) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSortRec(arreglo, inicio, medio, ascendente);       // Ordena parte izquierda
            mergeSortRec(arreglo, medio + 1, fin, ascendente);      // Ordena parte derecha
            merge(arreglo, inicio, medio, fin, new ComparadorLista<>(ascendente));         // Fusiona las partes
        }
    }
    public static <T extends Comparable<T>> void merge(List<T> arreglo, int inicio, int medio, int fin, ComparadorLista<T> comparador) {
        List<T> izquierda = new ArrayList<>();
        List<T> derecha = new ArrayList<>();

        for (int i = 0; i < (medio - inicio + 1); i++) {
            izquierda.add(i, arreglo.get(inicio + i));
        }
        for (int i = 0; i < (fin - medio); i++) {
            derecha.add(i, arreglo.get(medio + 1 + i) );
        }
    
        int i = 0, j = 0, k = inicio;
        while (i < izquierda.size() && j < derecha.size()) {
            
           //if ((izquierda.get(i).compareTo(derecha.get(j)) < 1 || izquierda.get(i).compareTo(derecha.get(j)) == 0)) {
            if (comparador.compare(izquierda.get(i), derecha.get(j)) < 0 || comparador.compare(izquierda.get(i), derecha.get(j)) == 0) {
                arreglo.set(k++, izquierda.get(i++));
            } else {
                arreglo.set(k++, derecha.get(j++));
            }
        }
    
        while (i < izquierda.size()) {
            arreglo.set(k++, izquierda.get(i++));
        }
    
        while (j < derecha.size()) {
            arreglo.set(k++, derecha.get(j++));
        }
    }
}


