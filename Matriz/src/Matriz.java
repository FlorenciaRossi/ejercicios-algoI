import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Matriz<E extends Comparable<E>> {
    private List<List<E>> columnas;
    private Map<String, Integer> colLabels;
    private Map<String, Integer> rowLabels; 

    // Crear vacía o desde un arreglo nativo E[][]
    public Matriz() {
        columnas = new ArrayList<>();
        colLabels = new LinkedHashMap<>();
        rowLabels = new LinkedHashMap<>();
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

    // Crear copia de la matriz
    public Matriz<E> copiaProfunda() {
        Matriz<E> nuevaMatriz = new Matriz<>();
        for(Map.Entry<String, Integer> entrada : colLabels.entrySet()){
            List<E> nuevaColumna = new ArrayList<>(columnas.get(entrada.getValue()));
            nuevaMatriz.agregarColumna(nuevaColumna, entrada.getKey());
        }
        nuevaMatriz.rowLabels = new LinkedHashMap<>(rowLabels);
        return nuevaMatriz;
    }
    
    // Agregar fila/columna
    public void agregarFila(List<E> nuevaFila) {
        if ( nuevaFila.size() != columnas.size()) {
            throw new IllegalArgumentException("El tamaño de la fila debe ser igual a la cantidad de columnas");
        }
        for (int columna = 0; columna < cantColumnas(); columna++) {
            columnas.get(columna).add(nuevaFila.get(columna));
        }
        rowLabels.put("fila " + cantFilas(), cantFilas() - 1);
    }

    public void agregarColumna(List<E> nuevaColumna) {
        if (cantFilas() != 0 && nuevaColumna.size() != cantFilas()) {
            throw new IllegalArgumentException("El tamaño de la columna debe ser igual al resto de las columnas");
        }
        columnas.add(nuevaColumna);
        colLabels.put("columna " + cantColumnas(), cantColumnas() - 1);
    }

    public void agregarColumna(List<E> nuevaColumna, String label){
        if (cantFilas() != 0 && nuevaColumna.size() != cantFilas()) {
            throw new IllegalArgumentException("El tamaño de la columna debe ser igual al resto de las columnas");
        }
        columnas.add(nuevaColumna);
        colLabels.put(label, cantColumnas() - 1);
    }

    // Eliminar fila/columna por label
    public void eliminarFila(String label) {
        if (!rowLabels.containsKey(label)) {
            throw new IllegalArgumentException("La fila no existe");
        }
        Integer indice = rowLabels.get(label);
        if (!indiceFilaValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (List<E> columna : columnas) {
            columna.remove(indice.intValue());
        }
        rowLabels.remove(label);
        for(Map.Entry<String, Integer> entrada : rowLabels.entrySet()){
            if(entrada.getValue() > indice){
                rowLabels.put(entrada.getKey(), entrada.getValue() - 1);
            }
        }
    }

    public void eliminarColumna(String label) {
        if( !colLabels.containsKey(label)){
            throw new IllegalArgumentException("La columna no existe");
        }
        Integer indice = colLabels.get(label);
        if (!indiceColumnaValido(indice)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        columnas.remove(indice.intValue());
        colLabels.remove(label);

        for(Map.Entry<String, Integer> entrada : colLabels.entrySet()){
            if(entrada.getValue() > indice){
                colLabels.put(entrada.getKey(), entrada.getValue() - 1);
            }
        }
    }

    // Cambiar orden de filas/columnas
    public void cambiarOrdenFilas(int indice1, int indice2) {
        if (!indiceFilaValido(indice1) || !indiceFilaValido(indice2)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (List<E> columna : columnas) {
            Collections.swap(columna, indice1, indice2);
        }
    }

    public void cambiarOrdenColumnas(int indice1, int indice2) {
        if (!indiceColumnaValido(indice1) || !indiceColumnaValido(indice2)) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Collections.swap(columnas, indice1, indice2);
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
        System.out.print("        ");
        for(String label : colLabels.keySet()){
            System.out.print(label + " | ");
        }
        System.out.println();
        for (Map.Entry<String, Integer> entrada : rowLabels.entrySet()){
            System.out.print(entrada.getKey() + " |   ");
            int fila = entrada.getValue();
            for (List<E> columna : columnas){
                System.out.print(columna.get(fila) + "     |     ");
            }
            System.out.println();
        }
    }

    // Filtrar filas según condición
    public Matriz<E> filtrar( int columna, char operador, E valor){
        Map<Character, Predicate<E>> operadores = new HashMap<>();
        operadores.put('<', e -> e.compareTo(valor) < 0);
        operadores.put('>', e -> e.compareTo(valor) > 0);
        operadores.put('=', e -> e.compareTo(valor) == 0);
        operadores.put('!', e -> e.compareTo(valor) != 0);

        Predicate<E> condicion = operadores.get(operador);
        
        Matriz<E> matrizFiltrada = copiaProfunda();

        if(condicion == null){
            throw new IllegalArgumentException("Operador no válido. Los operaadores válidos son '<', '>', '=', '!'");
        }
        for(Map.Entry<String, Integer> entrada : rowLabels.entrySet()){
            E valorAComparar = columnas.get(columna).get(entrada.getValue());
            if(!condicion.test(valorAComparar)){
                matrizFiltrada.eliminarFila(entrada.getKey());
            }
        }
        return matrizFiltrada;
    }
        
    private Fila<E> getFila(String label){
        List<E> filaNueva = new ArrayList<>();
        for(List<E> columna : this.columnas){
            filaNueva.add(columna.get(rowLabels.get(label)));
        }
        return new Fila<E>(filaNueva);
    }
    
    private List<E> getColumna(String label){
        return columnas.get(colLabels.get(label));
    }

    private List<E> getFilaEntreColumnas(int fila, int colInicio, int colFin){
        List<E> filaEntreCol = new ArrayList<>();
        for (int col = colInicio ;  col <= colFin ; col++) {
            filaEntreCol.add(columnas.get(col).get(fila));
        }
        return filaEntreCol;
    }
    
    private Fila<E> getFilaPorColumnas(int fila, int[] col) {
        List<E> filaPorColumnas = new ArrayList<>();
        for (int columna : col) {
            filaPorColumnas.add(columnas.get(columna).get(fila));
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
        if( columnas.isEmpty()){
            return 0;
        }
        return columnas.get(0).size();
    }

    private int cantColumnas() {
        if(columnas.isEmpty()){
            return 0;
        }
        return columnas.size();
    }

    private void inicializarColumnas(int cantColumnas) {
        for (int i = 0; i < cantColumnas; i++) {
            columnas.add(new ArrayList<>());
            colLabels.put("colmuna " + i, i);
        }
    }

    private void inicializarColumnas( String[] colLabels){
        for (int i = 0; i < colLabels.length; i++) {
            columnas.add(new ArrayList<>());
            this.colLabels.put(colLabels[i], i);
        }
    }
}
