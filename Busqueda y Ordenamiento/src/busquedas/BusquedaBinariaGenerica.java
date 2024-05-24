package busquedas;
import java.util.List;

public class BusquedaBinariaGenerica {
    public static<T extends Comparable<T>> int busquedaBinaria(List<T> arreglo, T elemento) {
        int inicio = 0;
        int fin = arreglo.size() - 1;
    
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arreglo.get(medio).compareTo(elemento) == 0) {
                return medio;   // Elemento encontrado, se devuelve la posición
            }
            if(arreglo.get(medio).compareTo(elemento) < 1){
                inicio = medio + 1;
            } else { 
                fin = medio - 1;
            }
        }
    
        return -1;              // Elemento no encontrado, se devuelve -1
    }

   
}
