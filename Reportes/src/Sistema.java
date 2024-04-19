public class Sistema {
    
    public static void main(String[] args) {
        
        ReporteVenta repoVenta1 = new ReporteVenta("Venta 1", "3 lapiceras");
        ReporteVenta repoVenta2 = new ReporteVenta("Venta 2", "5 lapiceras");
        
        ReporteCompra repoCompra1 = new ReporteCompra("Compra 1", "1 lapiz");
        
        ReporteImprimible colaImpresion[] = { repoVenta1, repoVenta2 , repoCompra1};
        for (int i = 0; i < colaImpresion.length; i++){
            colaImpresion[i].imprimir();
        }
    }
}
