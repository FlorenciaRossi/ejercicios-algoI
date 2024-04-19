public class Sort {

    public static void ordenar(Comparable[] arreglo) {
        Comparable aux;

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 1; j < (arreglo.length - i); j++) {
                if (arreglo[j-1].compareTo(arreglo[j]) > 0) {
                    aux = arreglo[j-1];
                    arreglo[j-1] = arreglo[j];
                    arreglo[j] = aux;
                }
            }
        }
    }
}
