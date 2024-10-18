import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
          Integer[][] array = {
            {1, 2, 3},
            {7, 9, 6},
            {7, 8, 9}
        };

        Matriz<Integer> matriz = new Matriz<>(array);
        matriz.imprimirMatriz();
        
        System.out.println("Agregar una fila: ");
        matriz.agregarFila(new ArrayList<>(List.of(10, 11, 12)));
        matriz.imprimirMatriz();

        System.out.println("Agregar una columna: ");
        matriz.agregarColumna(new ArrayList<>(List.of(10, 11, 12,5)));
        matriz.imprimirMatriz();


        System.out.println("Ordenar filas por la primera columna");
        matriz.ordenarFilasPorColumnas(new int[] {0,1});
        matriz.imprimirMatriz();

        System.out.println("Cambiar orden de las filas, 0 y 1");
        matriz.cambiarOrdenFilas(0, 1);
        matriz.imprimirMatriz();
    }
}
