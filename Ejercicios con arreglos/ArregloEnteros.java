import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class ArregloEnteros {

    public static int encontrarValorMasFrecuente(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo debe contener elementos");
        }

        // ¿dónde guardamos el par valor - frecuencia?
        Map<Integer, Integer> frecuencia = new HashMap<>();

        int frecuenciaMax = 0;
        int numMasFrecuente = numeros[0];

        // contamos la frecuencia
        for (int num : numeros) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);

            if (frecuencia.get(num) > frecuenciaMax) {
                frecuenciaMax = frecuencia.get(num);
                numMasFrecuente = num;
            }
        }
        return numMasFrecuente;
    }

    public static int encontrarElementoMayoria(int[] numeros) {
        // Podemos modificar el método encontrarValorMasFrecuente
        Map<Integer, Integer> frecuencia = new HashMap<>();

        int frecuenciaMax = 0;
        int numMasFrecuente = numeros[0];
        int numMayoria = -1;

        // contamos la frecuencia
        for (int num : numeros) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);

            if (frecuencia.get(num) > frecuenciaMax) {
                frecuenciaMax = frecuencia.get(num);
                numMasFrecuente = num;
            }
        }

        // comprobamos que se encuentre en la mayoría del arreglo
        if (frecuenciaMax > frecuencia.size() / 2 + 1) {
            numMayoria = numMasFrecuente;
        }

        return numMayoria;
    }

    public static void main(String[] args) {
        // int[] numeros = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int[] numeros = { 3, 3, 4, 3, 2 };
        int resultado = encontrarValorMasFrecuente(numeros);
        System.out.println("El valor más frecuente es: " + resultado);

        resultado = encontrarElementoMayoria(numeros);
        System.out.println("El valor con mayoría es: " + resultado);

    }

}
