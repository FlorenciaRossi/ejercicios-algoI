public interface ReporteImprimible {
    public default void imprimir(){
        System.out.println(this);
    };
}
