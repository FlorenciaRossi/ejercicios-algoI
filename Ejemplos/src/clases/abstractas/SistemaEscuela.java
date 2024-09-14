package clases.abstractas;

abstract class Persona {
    protected String nombre;

    public Persona(String n){
        nombre = n;
    }

    public String getNombre(){
        return nombre;
    }

    public abstract void controlarAsistencia();
}

class Estudiante extends Persona {
    private int matricula;

    public Estudiante(String n, int m) {
        super(n);
        matricula = m;
    }
    
    public int getMatricula(){
        return matricula;
    }

    @Override
    public String getNombre() {
        return nombre + " (E)";
    }
    @Override
    public void controlarAsistencia() {
        System.out.println("Controlar asistencia de estudiante");
    }
}

class Docente extends Persona {
    private int legajo;

    public Docente(String n, int legajo) {
        super(n);
        this.legajo = legajo;
    }


    int getLegajo(){
        return legajo;
    }


    @Override
    public void controlarAsistencia() {
        System.out.println("Controlar asistencia de Docente.");
    }

}

public class SistemaEscuela {
    private final static int LONG_ARREGLO = 2;
    
    public static void main(String[] args) {
        Persona[] personas = new Persona[LONG_ARREGLO];

        //personas[0] = new Persona("Nombre");
        personas[0] = new Estudiante("Pedro", 1000);
        personas[1] = new Docente("Laura", 700);

        for(int i = 0 ; i < personas.length ; i++){
            System.out.println(personas[i].getNombre());
            personas[i].controlarAsistencia();  //dynamic binding
            //personas[i].getMatricula();
        }
    }
}
