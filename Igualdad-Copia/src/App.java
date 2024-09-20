public class App {
    public static void main(String[] args) {
        // Direcciones y personas
        Direccion dir1 = new Direccion("Calle Falsa 123", "Ciudad X");
        Persona persona1 = new Persona("Juan", dir1);

        Direccion dir2 = new Direccion("Calle Falsa 123", "Ciudad X");
        Persona persona2 = new Persona("Juan", dir2);

        // Comparación por identidad (==) y por valor (equals)
        System.out.println("Comparación por identidad (persona1 == persona2): " + (persona1 == persona2));
        System.out.println("Comparación por valor (persona1.equals(persona2)): " + persona1.equals(persona2));

        // Copia superficial
        Persona persona3 = persona1.copiaSuperficial();
        System.out.println("\nCopia superficial:");
        System.out.println("persona1 == persona3: " + (persona1 == persona3));  // Comparación de identidad
        System.out.println("persona1.equals(persona3): " + persona1.equals(persona3));  // Comparación por valor

        // Modificar la dirección de persona3
        persona3.getDireccion().setCalle("Calle Verdadera 456");
        System.out.println("Dirección de persona1 después de modificar persona3 (copia superficial): " + persona1.getDireccion());
        System.out.println("Dirección de persona3: " + persona3.getDireccion());

        // Copia profunda
        Persona persona4 = persona1.copiaProfunda();
        System.out.println("\nCopia profunda:");
        System.out.println("persona1 == persona4: " + (persona1 == persona4));  // Comparación de identidad
        System.out.println("persona1.equals(persona4): " + persona1.equals(persona4));  // Comparación por valor

        // Modificar la dirección de persona4
        persona4.getDireccion().setCalle("Calle Nueva 789");
        System.out.println("Dirección de persona1 después de modificar persona4 (copia profunda): " + persona1.getDireccion());
        System.out.println("Dirección de persona4: " + persona4.getDireccion());
    }
    }
    
