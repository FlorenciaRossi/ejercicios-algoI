public class Moto extends Vehiculo {
    public Moto(String marca, String modelo, Double precioBase){
        super(marca, modelo, precioBase);
    }
    public Moto(String marca, String modelo){
        super(marca, modelo, 100.0);
    }

    @Override
    public Double calcularCostoAlquiler(int dias) {
        Double costo = super.calcularCostoAlquiler(dias);
        return costo * 0.85;
    }
}
