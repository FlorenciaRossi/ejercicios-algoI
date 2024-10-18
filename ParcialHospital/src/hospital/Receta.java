package hospital;

import hospital.estudios.Estado;
import hospital.estudios.Estudio;

public class Receta {
    private int id;
    private Estudio[] estudios;
    private Paciente paciente;
    private Profesional profesional;
    private Estado estado;

    public Receta(int id, Estudio[] estudios, Paciente paciente, Profesional profesional) {
        this.id = id;
        this.estudios = estudios;
        this.paciente = paciente;
        this.profesional = profesional;
        estado = Estado.PENDIENTE;
    }

    public boolean estaProcesada() {
        if (estado == Estado.PENDIENTE) {
            return false;
        }
        return true;
    }

    public void procesar() {
        for (Estudio e : estudios) {
            e.realizarse(paciente, profesional);
        }
        estado = Estado.PROCESADA;
    }

    @Override
    public String toString() {
        String salida =  "Receta " + id + 
                "\n- Profesional: "+ profesional + 
                "\n- Paciente: " + paciente + 
                "\n- Estado: " + estado + 
                "\n- Estudios: ";
        for (Estudio e : estudios){
            salida += "\n- " + e;
        }
        return salida;
    }
    // Receta 1:
    // - Profesional: Juana [12345]
    // - Paciente: Pedro [35234111]
    // - Estado: PROCESADA
    // - Estudios:
    // - RX: Estudio de imagen RX de columna (REALIZADO)
    // - RX: Estudio de imagen RX de torax (REALIZADO)

    public Paciente getPaciente() {
        return paciente;
    }

    public Integer cantEstudios() {
        return estudios.length;
    }
}
