import java.util.Arrays;
import java.util.Objects;

public class Estudiante{
    private String[] materias;
    private String nombre;
    
    public Estudiante(String nombre, String[] materias){
        this.materias = Arrays.copyOf(materias, materias.length);
    }
    
    public String[] getMaterias(){
        return Arrays.copyOf(materias, materias.length);
    }

    public Estudiante cambiarNombre(String nombre){
        return new Estudiante(nombre, materias);
    }

    private String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object otro){
        if (this == otro){
            return true;
        }
        if( otro == null || this.getClass() != otro.getClass()){
            return false;
        }
        Estudiante otro2 = (Estudiante)otro;

        return this.getNombre() == otro2.getNombre(); 

    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }

}
