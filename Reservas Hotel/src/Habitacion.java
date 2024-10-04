public class Habitacion {
    private int id;
    private int capacidad;

    public Habitacion(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
       return capacidad;
    }

    // public int getId() {
    //    return id;
    // }

    @Override
    public String toString() {
        return "Habitacion n° " + id;
    }
}
