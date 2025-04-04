public class Auto extends Vehiculo {
    public Auto(String modelo, String marca, Double precioBase){
        super(marca, modelo, precioBase);
    }

    public Auto(String modelo, String marca){
        super(marca, modelo, 150.0);
    }

    @Override
    public Double calcularCostoAlquiler(int dias) {
        return super.calcularCostoAlquiler(dias) * 1.2;
    }
}
