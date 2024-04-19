public abstract class Reporte {
    protected String titulo;
    protected String contenido;

    public Reporte(String t, String c){
         titulo = t;
         contenido = c;
    }

    @Override
    public String toString(){
        return titulo;
    }
}
