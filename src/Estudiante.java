import java.util.Arrays;

public class Estudiante {
    private String nombre;
    private int edad;
    private String carrera;
    private Materia[] materias;

    private static int estudiantesTotales = 0;

    public Estudiante(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public Estudiante( String nombre, int edad, String carrera, Materia[] materias){
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.materias = materias;
        estudiantesTotales ++;
    }

    public static int getEstudiantesTotales(){
        return estudiantesTotales;
    }

    public Materia mejorMateria(){
        Materia mejorM = materias[0];

        for(Materia m : materias){
            if ( mejorM.getNota() < m.getNota() ){
                mejorM = m;
            }
        }
        return mejorM;
    }
    public void presentarse(){
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }

    public static Estudiante agregarEstudiantes(String nombre, int edad){
        return new Estudiante(nombre, edad);
    }

    @Override
    public String toString(){
        return "\nNombre: "+ nombre +
                "\nEdad: " + edad +
                "\nCarrera: " + carrera +
                "\nMaterias: " + Arrays.toString(materias);
    }
}

