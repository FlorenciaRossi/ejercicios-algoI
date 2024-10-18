package hospital.estudios;

import hospital.Paciente;
import hospital.Profesional;
import hospital.Notificador;

public abstract class Estudio {
    private String nombre;
    private String descripcion;
    private Estado estado;

    public Estudio(String nombre, String descripcion, Estado estado){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public void realizarse(Paciente paciente, Profesional profesional){
        Notificador.notificar(paciente, profesional, this);
        estado = Estado.PROCESADA;
    }

    @Override
    public String toString() {
        return nombre + ": " + descripcion + "(" + estado + ")";
    }
    // RX: Estudio de imagen RX de columna (REALIZADO)
}
