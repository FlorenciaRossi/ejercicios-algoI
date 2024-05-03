import java.util.Objects;

public class Estudiante {
    private String nombre;
    private int edad;
    private int matricula;
    private HistoriaAcademica historiaAcademica;

    public Estudiante(String nombre, int edad, int matricula){
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        historiaAcademica = new HistoriaAcademica();
    }

    public int getMatricula(){
        return matricula;
    }


    public HistoriaAcademica getHistoriaAcademica(){
        return historiaAcademica;
    }
    @Override
    public boolean equals(Object otro) {
        if ( this == otro){
            return true;
        }
        if ( otro == null || this.getClass() != otro.getClass()){
            return false;
        }
        Estudiante otro2 = (Estudiante)otro;
        return this.getMatricula() == otro2.getMatricula() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return historiaAcademica.toString();
    }
}
