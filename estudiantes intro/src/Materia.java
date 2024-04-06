public class Materia {
    private String nombre;
    private int nota;

    public Materia(String nombre, int nota){
        this.nombre = nombre;
        this.nota = nota;
    }
    public String getNombre(){
        return nombre;
    }
    public int getNota(){
        return nota;
    }

    @Override
    public String toString(){
        return  nombre + ": " + nota;
    }

}
