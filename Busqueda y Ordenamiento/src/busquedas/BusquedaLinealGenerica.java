package busquedas;
public class BusquedaLinealGenerica {

    public static<T> int busquedaLineal(T[] arreglo, T elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].equals(elemento)) {
                return i;   // Elemento encontrado, se devuelve la posición
            }
        }
        return -1;          // Elemento no encontrado, se devuelve -1
    }
}
