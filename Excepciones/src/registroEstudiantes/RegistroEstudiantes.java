package registroEstudiantes;

import java.util.ArrayList;
import java.util.List;
import registroEstudiantes.excepciones.EdadInvalidaException;
import registroEstudiantes.excepciones.NombreInvalidoException;
import registroEstudiantes.excepciones.PromedioInvalidoException;

public class RegistroEstudiantes {
    private List<Estudiante> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(String nombre, int edad, double promedio)
            throws NombreInvalidoException, EdadInvalidaException, PromedioInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreInvalidoException("El nombre no puede ser nulo o vacío.");
        }
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad debe ser entre 0 y 120.");
        }
        if (promedio < 0.0 || promedio > 10.0) {
            throw new PromedioInvalidoException("El promedio debe estar entre 0.0 y 10.0.");
        }
        estudiantes.add(new Estudiante(nombre, edad, promedio));
        System.out.println("Estudiante registrado con éxito.");
    }

    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }
}
