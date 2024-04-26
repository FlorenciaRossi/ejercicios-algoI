public class App {
    public static void main(String[] args) throws Exception {
    
    String[] materias = {"algo1", "mate2"};
    Estudiante pepa = new Estudiante("pepa", materias); 
    
    //IGUALDAD vs IDENTIDAD
    // Estudiante pepa2 = pepa;
    // Estudiante pepaFalsa = new Estudiante("pepa");
    // System.out.println(pepa.equals(pepaFalsa));
    //System.out.println("" + pepa + pepaFalsa);
    
    //OBJETOS INMUTABLES
    for(int i = 0; i< pepa.getMaterias().length ; i++){
        System.out.println(pepa.getMaterias()[i]);
    }

    materias[0] = "biología";
    
    for(int i = 0; i< pepa.getMaterias().length ; i++){
        System.out.println(pepa.getMaterias()[i] );
    }
    
    pepa = pepa.cambiarNombre("Pepita");
    Estudiante pepita = pepa.cambiarNombre("Pepita");
    
}
}
