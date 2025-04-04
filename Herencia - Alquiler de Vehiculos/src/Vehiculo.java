public class Vehiculo{
    private String marca;
    private String modelo;
    private Double precioBase;

    public Vehiculo(String marca, String modelo, Double precioBase){
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }

    public Double calcularCostoAlquiler(int dias){
        return precioBase * dias;
    }

    @Override
    public String toString() {
        return "Modelo " + modelo +
                "\nMarca " + marca + 
                "\nPrecio base " + precioBase;
    }
}