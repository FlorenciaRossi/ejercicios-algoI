import java.util.Arrays;
import java.util.Objects;

public class EstudianteInmutable {
    private String[] materias;
    private String nombre;
    
    public EstudianteInmutable(String nombre, String[] materias){
        this.nombre = nombre;
        this.materias = Arrays.copyOf(materias, materias.length);
    }
    
    public String[] getMaterias(){
        return Arrays.copyOf(materias, materias.length);
    }

    public EstudianteInmutable cambiarNombre(String nombre){
        return new EstudianteInmutable(nombre, materias);
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
        EstudianteInmutable otro2 = (EstudianteInmutable)otro;

        return this.getNombre() == otro2.getNombre(); 

    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }
}
