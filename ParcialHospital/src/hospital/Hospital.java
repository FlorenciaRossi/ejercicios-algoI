package hospital;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hospital.estudios.Estudio;
import hospital.excepciones.SystemException;

public class Hospital {
    private String nombre;
    private List<Profesional> profesionales;
    private List<Paciente> pacientes;
    private List<Receta> recetas;
    private static int idReceta;

    public Hospital(String nombre) {
        this.nombre = nombre;
        profesionales = new ArrayList<>();
        pacientes = new ArrayList<>();
        recetas = new ArrayList<>();
        idReceta = 0;
    }

    public Profesional registrarProfesional(String nombre, int matricula) {
        if (matriculaRegistrada(matricula)) {
            throw new SystemException("El profesional ya está registrado");
        }
        Profesional p = new Profesional(nombre, matricula);
        profesionales.add(p);
        return p;
    }

    public Paciente registrarPaciente(String nombre, int dni) {
        if (dniRegistrado(dni)) {
            throw new SystemException("El paciente ya está registrado");
        }
        Paciente p = new Paciente(nombre, dni);
        pacientes.add(p);
        return p;
    }

    public Receta cargarReceta(Profesional juana, Paciente pedro, Estudio[] estudios) {
        Receta r = new Receta(idReceta, estudios, pedro, juana);
        recetas.add(r);
        idReceta++;
        return r;
    }

    private boolean dniRegistrado(int dni) {
        for (Paciente p : pacientes) {
            if (p.getDNI() == dni) {
                return true;
            }
        }
        return false;
    }

    private boolean matriculaRegistrada(int matricula) {
        for (Profesional p : profesionales) {
            if (p.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    public void procesar(Receta receta) {
        if (receta.estaProcesada()) {
            throw new SystemException("La receta ya fue sido procesada");
        }
        receta.procesar();
    }

    public void mostrarRecetas() {
        for (Receta r : recetas) {
            System.out.println(r);
        }
    }

    public void mostrarRecetasProcesadas() {
        for (Receta r : recetas) {
            if (r.estaProcesada()) {
                System.out.println(r);
            }
        }
    }

    public void mostrarReceta(Receta r) {
        System.out.println("Receta ");
    }

    public void mostrarPacientesConEstudios(int cantEstudios) {

        for (Paciente p : getPacientesConEstudios(cantEstudios)) {
            System.out.println(p);
        }
    }

    private List<Paciente> getPacientesConEstudios(int cantEstudios) {
        Map<Integer, Integer> pacientesEstudios = new HashMap<>();
        for (Receta r : recetas) {
            Integer dniPaciente = r.getPaciente().getDNI();
            Integer cantidadEstudios = r.cantEstudios();
            pacientesEstudios.put(dniPaciente, cantidadEstudios);
        }
        List<Paciente> pacientes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entrada : pacientesEstudios.entrySet()) {
            if (entrada.getValue() >= cantEstudios) {
                pacientes.add(getPacienteByDNI(entrada.getKey()));
            }
        }
        return pacientes;
    }

    private Paciente getPacienteByDNI(int dni) {
        for (Paciente p : pacientes) {
            if (p.getDNI() == dni) {
                return p;
            }
        }
        throw new SystemException("No hay pacientes registrados con el DNI: " + dni);
    }

}
