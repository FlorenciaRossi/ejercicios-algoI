public class ReporteVenta extends Reporte implements ReporteImprimible, ReporteEditable {

  
    public ReporteVenta(String t, String c) {
        super(t, c);
    }

    @Override
    public void modificarContenido(String nuevoC) {
        contenido = nuevoC;
    }

   

}
