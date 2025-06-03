import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Matriz<T extends Comparable<T>> {
    List<List<T>> columnas;
    Map<String, Integer> colLabels;
    Map<String, Integer> rowLabels;

    public Matriz(int cantidadColumnas) {
        if (cantidadColumnas < 1)
            throw new IllegalArgumentException("La longitud de columnas debe ser mayor a 0.");

        columnas = new ArrayList<>();
        colLabels = new HashMap<>();
        rowLabels = new HashMap<>();

        for (int j = 0; j < cantidadColumnas; j++) {
            columnas.add(j, new ArrayList<>());
            colLabels.put(String.valueOf(j), j);
        }
    }

    public Matriz(int cantidadColumnas, String[] etiquetas) {
        this(cantidadColumnas);
        if (cantidadColumnas != etiquetas.length)
            throw new IllegalArgumentException("La longitud de etiquetas no coincide.");
        setEtiquetasColumnas(etiquetas);
    }

    public Matriz(T[][] matriz) {
        this(matriz[0].length);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas) {
        this(matriz[0].length, etiquetasColumnas);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas, String[] etiquetasFilas) {
        this(matriz, etiquetasColumnas);
        if (columnas.get(0).size() != etiquetasFilas.length)
            throw new IllegalArgumentException("La longitud de etiquetas de filas no coincide.");
        setEtiquetasFilas(etiquetasFilas);
    }

    public Matriz(Matriz<T> m) {
        columnas = m.columnas;
        colLabels = new LinkedHashMap<String, Integer>();
        colLabels.putAll(m.colLabels);
        rowLabels = new LinkedHashMap<String, Integer>();
        rowLabels.putAll(m.rowLabels);
    }

    public Matriz<T> copia() {
        Matriz<T> matrizOrigen = this;  // solo para aclarar
        Matriz<T> nueva = new Matriz<>(matrizOrigen);

        nueva.columnas = new ArrayList<>();
        for(List<T> columna : matrizOrigen.columnas) {
            List<T> columnaNueva = new ArrayList<>();
            nueva.columnas.add(columnaNueva);
            for(T celda : columna) {
                columnaNueva.add(celda);
            }
        }

        return nueva;
    }

    public void setEtiquetasFilas(String[] etiquetas) {
        rowLabels.clear();
        for (int i = 0; i < columnas.get(0).size(); i++) {
            rowLabels.put(etiquetas[i], i);
        }
    }

    public void setEtiquetasColumnas(String[] etiquetas) {
        colLabels.clear();
        for (int j = 0; j < columnas.size(); j++) {
            colLabels.put(etiquetas[j], j);
        }
    }

    private void inicializarDesdeMatriz(T[][] matriz) {
        for (int j = 0; j < columnas.size(); j++) {
            for (int i = 0; i < matriz.length; i++) {
                columnas.get(j).add(i, matriz[i][j]);
            }
        }
        for (int i = 0; i < columnas.get(0).size(); i++) {
            rowLabels.put(String.valueOf(i), i);
        }
    }

    public static <T extends Comparable<T>> Matriz<T> crearDesdeMatriz(T[][] matriz) {
        return new Matriz<>(matriz);
    }

    public T getCelda(String fila, String columna) {
        return columnas.get(colLabels.get(columna)).get(rowLabels.get(fila)); // columnas[columna][fila]
    }

    public void setCelda(int fila, int columna, T valor) {
        columnas.get(columna).set(fila, valor);
    }

    public Fila<T> getFila(String fila) {
        List<T> celdas = new ArrayList<>();
        if (!rowLabels.containsKey(fila)) {
            throw new IllegalArgumentException();
        }
        for (Integer indiceCol : colLabels.values()) {
            celdas.add(columnas.get(indiceCol).get(rowLabels.get(fila)));
        }
        return new Fila<>(celdas);
    }

    public Fila<T> getFila(String fila, String[] columnas) {
        List<T> retorno = new ArrayList<>();
        if (!rowLabels.containsKey(fila)) {
            throw new IllegalArgumentException();
        }
        for (String etiquetaCol : columnas) {
            if (!rowLabels.containsKey(fila))
                throw new IllegalArgumentException();

            retorno.add(this.columnas.get(
                colLabels.get(etiquetaCol)
            ).get(rowLabels.get(fila)));
        }
        return new Fila<>(retorno);
    }

    public List<Fila<T>> seleccion(String[] filas, String[] columnas) {
        List<Fila<T>> retorno = new ArrayList<>();
        for(String fila : filas) {
            retorno.add(getFila(fila, columnas));
        }
        return retorno;
    }

    // public List<Fila<T>> getColumnas(String[] columnas) {
    //     return seleccion(orden, columnas);
    // }

    public Matriz<T> ordernarPorColumnas(String[] columnasOrden) {
        String[] orden = rowLabels.keySet().toArray(new String[0]);
        int n = orden.length;
        boolean huboCambio;
        
        do {
            huboCambio = false;
            for (int i = 1; i < n; i++) {
                String etiquetaPrevia = orden[i - 1];
                String etiquetaActual = orden[i];

                // Obtener filas con seleccion de columnas a ordenar
                Fila<T> filaPrevia = getFila(etiquetaPrevia, columnasOrden);
                Fila<T> filaActual = getFila(etiquetaActual, columnasOrden);

                if (filaPrevia.compareTo(filaActual) > 0) {
                    orden[i - 1] = orden[i];
                    orden[i] = etiquetaPrevia;
                    huboCambio = true;
                }
            }
            n--;
        } while (huboCambio);

        Matriz<T> nueva = new Matriz(this);
        nueva.generarRowLabelsOrdenado(orden);
        return nueva;
    }

    private void generarRowLabelsOrdenado(String[] orden) {
        for(String etiqueta : orden) {
            Integer indiceFila = rowLabels.get(etiqueta);
            rowLabels.remove(etiqueta);
            rowLabels.put(etiqueta, indiceFila);
        }
    }

    private void generarRowLabelsFiltrado(List<String> filas) {
        Map<String, Integer> nuevas = new LinkedHashMap<>();
        for(String fila : filas) {
            nuevas.put(fila, rowLabels.get(fila));
        }
        rowLabels.clear();  // se ocupa el GC
        rowLabels = nuevas;
    }


    @Override
    public String toString() {
        String out = "  | ";
        String sep = " | ";
        for (String label : colLabels.keySet()) {
            out += label + sep;
        }
        out += "\n";
        for (String fila : rowLabels.keySet()) {
            out += fila + sep;
            for (String columna : colLabels.keySet()) {
                out += getCelda(fila, columna);
                out += sep;
            }
            out += "\n";
        }
        return out;
    }

    //filtar and exclusivamente
    public Matriz<T> filtrarAnd( String col, char op1, T valor1, char op2, T valor2){
        Predicate<T> condicion1 = predicado(op1, valor1);
        Predicate<T> condicion2 = predicado(op2, valor2);

        List<String> salida = new ArrayList<>();

        if (condicion1 != null && condicion2 != null){
            for( String rowLabel : rowLabels.keySet()){
                T valorAcomparar = columnas.get(colLabels.get(col)).get(rowLabels.get(rowLabel));
                if ( condicion1.and(condicion2).test(valorAcomparar)){
                    salida.add(rowLabel);
                }
            }
        }else{
            throw new IllegalArgumentException();
        }

        Matriz<T> nueva = new Matriz(this);
        nueva.generarRowLabelsFiltrado(salida);
        return nueva;
    }
    //filtar AND o OR
    public Matriz<T> filtrar( String col, char op1, T valor1, String cond, char op2, T valor2){
        Predicate<T> condicion1 = predicado(op1, valor1);
        Predicate<T> condicion2 = predicado(op2, valor2);
        Map<String, Predicate<T>> condicion = new HashMap<>();
        condicion.put("and", condicion1.and(condicion2));
        condicion.put("or", condicion1.or(condicion2));
       
        Predicate<T> miPredicate = condicion.get(cond);
        List<String> salida = new ArrayList<>();

        if (condicion1 != null && condicion2 != null){
            for( String rowLabel : rowLabels.keySet()){
                T valorAcomparar = columnas.get(colLabels.get(col)).get(rowLabels.get(rowLabel));
                if ( miPredicate.test(valorAcomparar)){
                    salida.add(rowLabel);
                }
            }
        }else{
            throw new IllegalArgumentException();
        }

        Matriz<T> nueva = new Matriz(this);
        nueva.generarRowLabelsFiltrado(salida);
        return nueva;
    }
    
    public  Predicate<T> predicado( char operador, T valor){
        Map<Character, Predicate<T>> operadores = new HashMap<>();
        operadores.put('<', e -> e.compareTo(valor) < 0);
        operadores.put('>', e -> e.compareTo(valor) > 0);
        operadores.put('=', e -> e.compareTo(valor) == 0);
        operadores.put('!' , e-> e.compareTo(valor) != 0 );
        Predicate<T> condicion = operadores.get(operador);

        return condicion;
    }


    public Matriz<T> filtrar( String col , char operador, T valor ){
       
        Map<Character, Predicate<T>> operadores = new HashMap<>();
        operadores.put('<', e -> e.compareTo(valor) < 0);
        operadores.put('>', e -> e.compareTo(valor) > 0);
        operadores.put('=', e -> e.compareTo(valor) == 0);
        operadores.put('!' , e-> e.compareTo(valor) != 0 );

        Predicate<T> condicion = operadores.get(operador);
        List<String> salida = new ArrayList<>();

        if (condicion != null){
            for( String rowLabel : rowLabels.keySet()){
                T valorAcomparar = columnas.get(colLabels.get(col)).get(rowLabels.get(rowLabel));
                if ( condicion.test(valorAcomparar) ){
                    salida.add(rowLabel);
                }
            }
        }else{
            throw new IllegalArgumentException();
        }

        Matriz<T> nueva = new Matriz(this);
        nueva.generarRowLabelsFiltrado(salida);
        return nueva;
    }
}
