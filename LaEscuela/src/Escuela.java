import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Escuela {
    private List<Estudiante> estudiantes;
    private Set<Materia> materias;

    public Escuela(){
        estudiantes = new ArrayList<>();
        materias = new HashSet<>();
    }

    public void agregarEstudiante(Estudiante e){
        if ( estudiantes.contains(e) ){
            throw new IllegalArgumentException("El estudiante ya está registrado.");
        }
        estudiantes.add(e);
    }

    public void agregarMateria(Materia m){
        materias.add(m);
    }

    public void registrarCalificacion(Double c, Materia m, Estudiante e){
        if ( !materias.contains(m) ){
            throw new IllegalArgumentException("La materia no existe.");
        }
        e.getHistoriaAcademica().registrarCalificacion(c, m);
    }
    
}
