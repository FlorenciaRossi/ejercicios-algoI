public class App {
    public static void main(String[] args) throws Exception {
        Escuela escuelita = new Escuela();
        Estudiante pepe = new Estudiante("Pepe", 20, 0002);
        Estudiante pepa = new Estudiante("Pepa", 20, 0001);
        
        Materia algo1 = new Materia("Algoritmos I", 01, true);
        Materia algo2 = new Materia("Algoritmos II", 02, true);
        Materia algo3 = new Materia("Algoritmos III", 03, false);

        escuelita.agregarEstudiante(pepa);
        escuelita.agregarMateria(algo1);
        escuelita.agregarMateria(algo2);

        //Registrar calificación

        //escuelita.registrarCalificacion(9.0, algo3, pepa); lanza error
        escuelita.registrarCalificacion(9.0, algo2, pepa);
        System.out.println(pepa);
        escuelita.registrarCalificacion(7.0, algo2, pepa);
        escuelita.registrarCalificacion(9.0, algo1, pepa);
        System.out.println(pepa);
        escuelita.registrarCalificacion(1.5, algo1, pepa);
        System.out.println(pepa);


    }
}
