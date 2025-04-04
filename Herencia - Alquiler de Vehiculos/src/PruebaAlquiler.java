import java.util.ArrayList;
import java.util.List;

public class PruebaAlquiler {
    public static void main(String[] args) throws Exception {
       
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Chevrolet", "Corsa 2012", 50.0));
        vehiculos.add(new Auto("Chevrolet", "Cruze 2020"));
        vehiculos.add(new Moto("Honda", "Tornado"));

        for (Vehiculo vehiculo : vehiculos){
            System.out.println(vehiculo);
            System.out.println("Precio del viaje " + vehiculo.calcularCostoAlquiler(2));
        }
    }
}
