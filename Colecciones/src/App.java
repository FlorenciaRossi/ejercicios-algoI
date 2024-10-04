import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Integer[][] array = {
            {1, 2, 3},
            {8, 1, 6},
            {7, 8, 9}
        };

        Matriz<Integer> matriz = new Matriz<>(array);
        matriz.imprimirMatriz();
        System.out.println("Agregamos una fila: ");
    
        matriz.agregarFila(new ArrayList<>(List.of(10, 11, 12)));
        matriz.imprimirMatriz();

        System.out.println("Agregamos una columna: ");
        matriz.agregarColumna(new ArrayList<>(List.of(10, 11, 12,5)));
        matriz.imprimirMatriz();


        System.out.println("Ordeno filas por la primera columna");
        
        matriz.ordenarFilasPorColumnas(new int[] {1});
        matriz.imprimirMatriz();
        // matriz.cambiarOrdenFilas(0, 1);
        // matriz.imprimirMatriz();
    }
    
}
