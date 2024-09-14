import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // lista de objetos que implementan la interfaz Medible
        List<Medible> listaMedibles = new ArrayList<>();
        listaMedibles.add(new Termometro(0));
        listaMedibles.add(new CuentaBancaria());
        listaMedibles.add(new MedidorDePresion());

        Random random = new Random();
        int cont = 0;

        // Incrementar y decrementar arbitrariamente 100 veces
        for (int i = 0; i <= 100; i++) {
            for (Medible elemento : listaMedibles) {

                int incremento = random.nextInt(201) - 100; // Valor entre -100 y 100
                int decremento = random.nextInt(201) - 100; // Valor entre -100 y 100

                // Incrementar y decrementar
                elemento.incrementar(incremento);
                boolean huboError = elemento.decrementar(decremento);

                if (huboError) {
                    System.out.println("Error al decrementar " + decremento + " en " + elemento);
                }
            }

            cont++;

            // Imprimir medidas cada 10 iteraciones
            if (cont == 10) {
                for (Medible elemento : listaMedibles) {
                    System.out.println(elemento + " medida: " + elemento.getMedida());
                }
                cont = 0; 
            }
        }
    }
}
