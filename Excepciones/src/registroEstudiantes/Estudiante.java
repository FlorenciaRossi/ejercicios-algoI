package registroEstudiantes;

public class Estudiante {
    private String nombre;
    private int edad;
    private double promedio;

    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante {" +
                "nombre='" + nombre + "'" +
                ", edad=" + edad +
                ", promedio=" + promedio +
                '}';
    }
}
