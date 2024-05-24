package busquedas;
public class BusquedaBinaria {
    public void mergeSort(int[] arreglo) {
        mergeSortRec(arreglo, 0, arreglo.length - 1);
    }
    
    public void mergeSortRec(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSortRec(arreglo, inicio, medio);       // Ordena parte izquierda
            mergeSortRec(arreglo, medio + 1, fin);      // Ordena parte derecha
            merge(arreglo, inicio, medio, fin);         // Fusiona las partes
        }
    }
    
    public void merge(int[] arreglo, int inicio, int medio, int fin) {
        int[] izquierda = new int[medio - inicio + 1];
        int[] derecha = new int[fin - medio];
    
        for (int i = 0; i < izquierda.length; i++) {
            izquierda[i] = arreglo[inicio + i];
        }
        for (int i = 0; i < derecha.length; i++) {
            derecha[i] = arreglo[medio + 1 + i];
        }
    
        int i = 0, j = 0, k = inicio;
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }
    
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }
    
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }
}
