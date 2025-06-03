public class App {
        public static void main(String[] args) {
        Integer[][] m1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {7, 3, 5, 10}
        };
        String[] cols = {"A", "B", "C", "D"};
        String[] filas = {"x", "y", "z"};
        Matriz<Integer> miMatriz = new Matriz<>(m1, cols, filas);
        // Matriz<Integer> miMatriz = Matriz.crearDesdeMatriz(m1);
        //miMatriz.setCelda(0, 0, 9);
        System.out.println(miMatriz);
        //System.out.println(miMatriz.getCelda("x", "C"));
    
        //System.out.println(miMatriz.filtrar("A", '<', 6));
        //System.out.println(miMatriz.filtrarAnd("B", '>', 2, '<', 8));
        System.out.println(miMatriz.filtrar("A", '>', 2, "and", '>', 6));
    }
}
