import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matriz<E extends Comparable<E>> {
    private List<List<E>> matriz;

    // Crear vacía o desde un arreglo nativo E[][]
    public Matriz() {
        matriz = new ArrayList<>();
    }

    public Matriz(E[][] matriz) {
        this();
        inicializarColumnas(matriz[0].length);
        for (E[] fila : matriz) {
            // convierto E[] a List<E>
            List<E> nuevaFila = new ArrayList<>();
            Collections.addAll(nuevaFila, fila);
            agregarFila(nuevaFila);
        }
    }

    // Agregar fila/columna
    public void agregarFila(List<E> nuevaFila) {
        if (nuevaFila.size() != matriz.size()) {
            throw new IllegalArgumentException("El tamaño de la fila debe ser igual a la cantidad de columnas");
        }
        for (int columna = 0; columna < cantColumnas(); columna++) {
            matriz.get(columna).add(nuevaFila.get(columna));
        }
    }

    public void agregarColumna(List<E> nuevaColumna) {
        if (nuevaColumna.size() != cantFilas()) {
            throw new IllegalArgumentException("El tamaño de la columna debe ser igual al resto de las columnas");
        }
        matriz.add(nuevaColumna);
    }

    // Eliminar fila/columna por indice
    public void eliminarFila(int indice) {
        if (!indiceFilaValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (int columna = 0; columna < cantColumnas(); columna++) {
            matriz.get(columna).remove(indice);
        }
    }

    public void eliminarColumna(int indice) {
        if (!indiceColumnaValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        matriz.remove(indice);
    }

    // Cambiar orden de filas/columnas
    public void cambiarOrdenFilas(int indice1, int indice2) {
        if (!indiceFilaValido(indice1) || !indiceFilaValido(indice2)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (List<E> columna : matriz) {
            Collections.swap(columna, indice1, indice2);
        }
    }

    public void cambiarOrdenColumnas(int indice1, int indice2) {
        if (!indiceColumnaValido(indice1) || !indiceColumnaValido(indice2)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Collections.swap(matriz, indice1, indice2);
    }

    // Ordenar filas según valores en conjunto de columnas
    public void ordenarFilasPorColumnas(int[] columnas) {
        boolean huboCambio;
        int n = cantFilas();
        do {
            huboCambio = false;

            for (int i = 1; i < n; i++) {
                // obtener las dos filas
                Fila<E> filaPrevia = getFilaPorColumnas(i - 1, columnas);
                Fila<E> filaActual = getFilaPorColumnas(i, columnas);

                // compararlas y si es necesario intercambiar
                if (filaPrevia.compareTo(filaActual) > 0) {
                    cambiarOrdenFilas(i - 1, i);
                    huboCambio = true;
                }
            }

        } while (huboCambio);
    }

    // Proyección de la matriz (obtener submatriz)
    public Matriz<E> proyeccion(int filaInicio, int filaFin, int colInicio, int colFin){
        Matriz<E> submatriz = new Matriz<>();

        for (int fila = filaInicio ; fila <= filaFin ; fila++){
            //ir agregando por filas
            List<E> filaNueva = getFilaEntreColumnas(fila, colInicio, colFin);
            submatriz.agregarFila(filaNueva);
        }
        return submatriz;
    }

    // Imprimir matriz
    public void imprimirMatriz(){
        for (int fila = 0 ; fila < cantFilas() ; fila++){
            for (List<E> columna : matriz){
                System.out.print(columna.get(fila) + " | ");
            }
            System.out.println();
        }
    }


    private List<E> getFilaEntreColumnas(int fila, int colInicio, int colFin){
        List<E> filaEntreCol = new ArrayList<>();
        for (int col = colInicio ;  col <= colFin ; col++) {
            filaEntreCol.add(matriz.get(col).get(fila));
        }
        return filaEntreCol;
    }
    private Fila<E> getFilaPorColumnas(int fila, int[] columnas) {
        List<E> filaPorColumnas = new ArrayList<>();
        for (int columna : columnas) {
            filaPorColumnas.add(matriz.get(columna).get(fila));
        }
        return new Fila<E>(filaPorColumnas);
    }

    private boolean indiceFilaValido(int indice) {
        return indice >= 0 && indice < cantFilas();
    }

    private boolean indiceColumnaValido(int indice) {
        return indice >= 0 && indice < cantColumnas();
    }

    private int cantFilas() {
        return matriz.get(0).size();
    }

    private int cantColumnas() {
        return matriz.size();
    }

    private void inicializarColumnas(int cantColumnas) {
        for (int i = 0; i < cantColumnas; i++) {
            matriz.add(new ArrayList<>());
        }
    }
}
