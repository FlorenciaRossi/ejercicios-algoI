package hospital;

import hospital.estudios.Estudio;

public class Notificador {
    public static void notificar(Paciente paciente, Profesional profesional, Estudio estudio) {
        notificarPaciente(paciente, estudio);
        notificarProfesional(profesional, estudio);
    }

    private static void notificarProfesional(Profesional profesional, Estudio estudio) {
        System.out.println("Notificando a profesional " + profesional + " sobre " + estudio);      
    }

    private static void notificarPaciente(Paciente paciente, Estudio estudio) {
        System.out.println("Notificando a paciente " + paciente + " sobre " + estudio);
    }

}
// Notificando a paciente Pedro [35234111] sobre RX: Estudio de imagen RX de
// columna (REALIZADO)
// Notificando a profesional Juana [12345] sobre RX: Estudio de imagen RX de
// columna (REALIZADO)