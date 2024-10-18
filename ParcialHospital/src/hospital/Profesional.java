package hospital;

public class Profesional {
    private String nombre;
    private int matricula;

    public Profesional(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;   
    }

    public int getMatricula(){
        return matricula;
    }

    @Override
    public String toString() {
        return nombre + " ["+  matricula +"]";
    }
    // Juana [12345]

}
