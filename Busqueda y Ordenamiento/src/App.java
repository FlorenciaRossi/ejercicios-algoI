import java.util.List;

import busquedas.BusquedaBinariaGenerica;
import busquedas.BusquedaLinealGenerica;
import ordenamiento.Ordenamiento;
import ordenamiento.algoritmos.BubbleSort;
import ordenamiento.algoritmos.InsertionSort;
import ordenamiento.algoritmos.MergeSort;
import ordenamiento.algoritmos.QuickSort;
import ordenamiento.algoritmos.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;


public class App {
    public static void main(String[] args) throws Exception {
        Integer[] miLista = {4, 6, 1, 8};
       int index = 0;

        System.out.println(miLista.toString());
        index = BusquedaLinealGenerica.busquedaLineal(miLista, Integer.valueOf(1));
        System.out.println("El elemento 1 se encuentra en la posición: " + index);

        List<Integer> miLista2 = new ArrayList<>();
        miLista2.add(7);
        miLista2.add(34);
        miLista2.add(2);
        miLista2.add(9);
        System.out.println(miLista2.toString());
        Ordenamiento.ordenar(miLista2, true, new QuickSort<>());
        System.out.println(miLista2.toString());

        index = BusquedaBinariaGenerica.busquedaBinaria(miLista2, Integer.valueOf(9));
        System.out.println("El elemento 1 se encuentra en la posición: " + index);



    }
}
