import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Matriz<E extends Comparable<E>> {
    private List<List<E>> matriz;

    // Crear vacía o desde un arreglo nativo E[][]
    public Matriz(){
        matriz = new ArrayList<>();
    }

    public Matriz(E[][] matriz){
        this();
        inicializarColumnas(matriz[0].length);
        for (E[] fila : matriz) {
            // Conviero E[] a List<E>
            List<E> nuevaFila = new ArrayList<>();
            Collections.addAll(nuevaFila, fila);
            agregarFila(nuevaFila);
        }
    }

    // Agregar fila/columna
    public void agregarColumna(List<E> columna){
        if (columna.size() == matriz.get(0).size()){
            matriz.add(columna);
        }else{
            throw new IllegalArgumentException("el tamaño de la columna deve ser igual al resto de las columnas");
        }
    }

    public void agregarFila(List<E> fila){
        if (fila.size() != matriz.size() && matriz.size() != 0) {
            throw new IllegalArgumentException("El tamaño de la fila debe ser igual al tamaño de las columnas");
        }
        for (int i = 0 ; i< matriz.size(); i++){
            matriz.get(i).add(fila.get(i));
        }
    }

    // Eliminar fila/columna por indice
    public void eliminarFila(int indice){
        if (!indiceFilaValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (int i = 0 ; i< matriz.size(); i++){
            matriz.get(i).remove(indice);
        }
    }

    public void eliminarColumna(int indice){
        if (!indiceColumnaValido(indice)){
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        matriz.remove(indice);
    }

    // Cambiar orden de filas/columnas
    public void cambiarOrdenFilas(int indice1, int indice2){
        if (!indiceFilaValido(indice2) || !indiceFilaValido(indice2)){
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (List<E> fila : matriz) {
            Collections.swap(fila, indice1, indice2);
        }
    }
    
    public void cambiarOrdenColumnas(int indice1, int indice2){
        if (!indiceColumnaValido(indice2) || !indiceColumnaValido(indice2)){
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Collections.swap(matriz, indice1, indice2);
    }
    // public void cambiarOrdenColumnas(int indice1, int indice2){
    //     try{
    //         Collections.swap(matriz, indice1, indice2);
    //     }
    //     catch (IndexOutOfBoundsException e){
    //         System.out.println("No se pudo realizar la operación. " + e);
    //     }
    // }

    // Ordenar filas según valores en conjunto de columnas
    public void ordenarFilasPorColumnas(int[] columnas){
        int n = matriz.get(0).size();
        boolean huboCambio;

        do {
            huboCambio = false;
            for (int i = 1; i < n; i++){
                //obtengo las  dos filas
                Fila<E> filaPrevia = getFilaPorColumnas(i - 1, columnas);
                Fila<E> filaActual = getFilaPorColumnas(i, columnas);
                // comparo
                boolean com = filaPrevia.compareTo(filaActual) > 0;
                System.out.println(filaPrevia + " actual: " + filaActual + com);
                if (filaPrevia.compareTo(filaActual) > 0) {
                    cambiarOrdenFilas(i - 1, i);
                    huboCambio = true;
                }
            }


        } while (huboCambio);

    }

    // Proyección de la matriz (obtener submatriz)
    public Matriz<E> proyeccion(int filaInicio, int filaFin, int colInicio, int colFin){
        Matriz<E> subMatriz = new Matriz<>();
        for (int i = filaInicio -1 ; i< filaFin - 1; i++){
            //voy agrgando filas por columnas a la nueva matriz
            List<E> filaNueva = getFilaEntreColumnas(i, colInicio, colFin);
            subMatriz.agregarFila(filaNueva);
        }
        return subMatriz;
    }

    // Imprimir matriz
    public void imprimirMatriz() {
        for (int fila = 0 ; fila < cantFilas()  ; fila++){
            for (List<E> col : matriz){
                System.out.print(col.get(fila) + " | ");
            }
            System.out.println();
        }
    }

    private void inicializarColumnas(int cantColumnas){
        for (int i = 0 ;i < cantColumnas; i++){
            matriz.add(new ArrayList<>());
        }
    }
    private int cantFilas() {
        return matriz.get(0).size();
    }
    private Fila<E> getFilaPorColumnas(int fila, int[] columnas){
        List<E> filaPorColumnas = new ArrayList<>();
        for (int columna : columnas) {
            filaPorColumnas.add(matriz.get(columna).get(fila));
        }
        return new Fila<E>(filaPorColumnas);
    }

    private List<E> getFilaEntreColumnas(int fila, int colInicio, int colFin){
        return new ArrayList<>(matriz.get(fila).subList(colInicio, colFin));
    }
    
    private boolean indiceFilaValido(int indice){
        return indice >  0 && indice < matriz.get(0).size(); 
    }
    private boolean indiceColumnaValido(int indice){
        return indice >  0 && indice < matriz.size(); 
    }




}
