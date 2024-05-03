import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HistoriaAcademica {
    Map<Materia, Set<Double>> materias;

    public HistoriaAcademica(){
        materias = new HashMap<>();
    }

    public double promedio(){
        double suma = 0;
        int contador = 0;
        for( Set<Double> calificaciones : materias.values()){
            for( Double calificacion: calificaciones){
                suma += calificacion;
                contador++;
            }
        }
        return suma / contador;
    }

    public int cantidadAplazos(){
        int contador = 0;
        for( Set<Double> calificaciones : materias.values()){
            for( Double calificacion: calificaciones){
                if ( calificacion < 2){
                    contador++;
                }
            }
        }
        return contador;
    }

    public int cantidadMaterias(){
        return materias.size();
    }

    public void registrarCalificacion(Double c, Materia m) {
        if (materias.keySet().contains(m) ){
            agregarCalificacion(c, m);
        }
        else{
            materias.put(m, new HashSet<>(Set.of(c)));
        }
    }

    private void agregarCalificacion(Double c, Materia m) {
        materias.get(m).add(c);
    }

    @Override
    public String toString() {
        return "\nMaterias: " + materias.toString() +
               "\nPromedio: " + promedio() +
               "\nCantidad de aplazos: " + cantidadAplazos() +
               "\nCantidad de materias: " + cantidadMaterias();
    }
}
