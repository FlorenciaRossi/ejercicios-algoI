public class App {
    public static void main(String[] args) throws Exception {

        // de -128 a 127 java usa caché para reutilizar las mismas instancias de los objetos Integer
        int a = 10;
        Integer b = Integer.valueOf(10);
        System.out.println(a == b);      // unboxing true (mismo int 10)
        System.out.println(b.equals(a)); // autoboxing true (el mismo objeto en caché)
    
        Integer c = 10;
        Integer d = 10;
        System.out.println(c == d);      // true (el mismo objeto en caché)
        System.out.println(c.equals(d)); // true (mismo valor)
    
        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);      // false (no utiliza cache a partir de 127)
        System.out.println(e.equals(f)); // true 

        // ESTUDIANTE MUTABLE
        String[] materias = { "algo1", "mate2" };
        Estudiante pepa = new Estudiante("pepa", materias);
        Estudiante pepa2 = pepa;
        System.out.println("pepa == pepa2: " +  (pepa == pepa2));
        System.out.println("pepa.equals(pepa2): " + pepa.equals(pepa2) + "\n");

        Estudiante pepaFalsa = new Estudiante("pepa", materias);
        System.out.println("pepa == pepaFalsa: " +  (pepa == pepaFalsa));
        System.out.println("pepa.equals(pepaFalsa): " +  pepa.equals(pepaFalsa) + "\n");

        pepaFalsa.cambiarNombre("pepe");
        System.out.println("pepaFalsa se cambia el nombre por pepe");
        System.out.println("pepa == pepaFalsa: " +  (pepa == pepaFalsa));
        System.out.println("pepa.equals(pepaFalsa): " + pepa.equals(pepaFalsa) + "\n");
        
        System.out.println("Materias de pepa");
        String materiasPepa[] = pepa.getMaterias();
        for (int i = 0; i < pepa.getMaterias().length; i++) {
            System.out.println(pepa.getMaterias()[i]);
        }

        materiasPepa[0] = "biología";

        System.out.println("\nMaterias de pepa luego de modificarle una materia");
        for (int i = 0; i < pepa.getMaterias().length; i++) {
            System.out.println(pepa.getMaterias()[i]);
        }

        //ESTUDIANTE INMUTABLE
        EstudianteInmutable epe = new EstudianteInmutable("epe", materias);
        EstudianteInmutable epe2 = epe;
        System.out.println("\nepe == epeFalso: " +  (epe == epe2));
        System.out.println("epe.equals(epeFalso): " +  epe.equals(epe2) + "\n");

        epe2 = epe2.cambiarNombre("pepe");
        System.out.println("epe2 se cambia el nombre por pepe");
        System.out.println("epe2 == epe: " +  (epe == epe2));
        System.out.println("epe.equals(epe2): " + epe.equals(epe2) + "\n");

        System.out.println("Materias de epe");
        String materiasEpe[] = epe.getMaterias();
        for (int i = 0; i < epe.getMaterias().length; i++) {
            System.out.println(epe.getMaterias()[i]);
        }

        materiasEpe[0] = "biología";

        System.out.println("\nMaterias de epe luego de modificarle una materia");
        for (int i = 0; i < epe.getMaterias().length; i++) {
            System.out.println(epe.getMaterias()[i]);
        }

    }
}
