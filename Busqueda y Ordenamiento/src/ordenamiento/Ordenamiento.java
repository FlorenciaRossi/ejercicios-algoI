package ordenamiento;
import java.util.List;

import ordenamiento.algoritmos.AlgoritmoOrdenamiento;
import ordenamiento.algoritmos.MergeSort;

public class Ordenamiento {

    public static <T extends Comparable<T>> void ordenar(List<T> lista){
        ordenar(lista, false);
    }

    public static <T extends Comparable<T>> void ordenar(List<T> lista, boolean ascendente){
        ordenar(lista, ascendente, new MergeSort<>());
    }

    public static <T extends Comparable<T>> void ordenar(List<T> lista, AlgoritmoOrdenamiento<T> algoritmo){
        ordenar(lista, true, algoritmo);
    }

    public static <T extends Comparable<T>> void ordenar(List<T> lista, boolean ascendente, AlgoritmoOrdenamiento<T> algoritmo){
        algoritmo.ordenar(lista, ascendente);
    }

}

   