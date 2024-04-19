public class App {
    public static void main(String[] args) throws Exception {
        Persona pepa = new Persona("pepa", 23);
        Persona pepe = new Persona("pepe", 24);
        Persona personas[] = {pepe, pepa}; 
        
        Comparable<Persona> com[];
        for (int i = 0 ; i< personas.length; i++){
            System.out.println(personas[i].getNombre());
        }

        Sort.ordenar(personas);

        System.out.println("Arreglo ordenado:");

        for (int i = 0 ; i< personas.length; i++){
            System.out.println(personas[i].getNombre());
        }

    }
}
