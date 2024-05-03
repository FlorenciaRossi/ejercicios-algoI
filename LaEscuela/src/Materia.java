import java.util.Objects;

public class Materia {
    private String nombre;
    private int codigo;
    private boolean estado;

    public Materia(String nombre, int codigo, boolean estado){
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
    }

    public int getCodigo(){
        return codigo;
    }

    @Override
    public boolean equals(Object otro) {
        if ( this == otro){
            return true;
        }
        if ( otro == null || this.getClass() != otro.getClass()){
            return false;
        }
        Materia otro2 = (Materia)otro;
        return this.getCodigo() == otro2.getCodigo() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
