package registroEstudiantes;

import java.util.Scanner;

import registroEstudiantes.excepciones.EdadInvalidaException;
import registroEstudiantes.excepciones.NombreInvalidoException;
import registroEstudiantes.excepciones.PromedioInvalidoException;

public class MainRegistroEstudiantes {
public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();
        Scanner s = new Scanner(System.in);

        boolean continuar = true;
       

        while (continuar) {
            try {
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = s.nextLine();

                System.out.print("Ingrese la edad del estudiante: ");
                int edad = Integer.parseInt(s.nextLine());

                System.out.print("Ingrese el promedio del estudiante: ");
                double promedio = Double.parseDouble(s.nextLine());

                
                registro.registrarEstudiante(nombre, edad, promedio);

            } catch (NombreInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (EdadInvalidaException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (PromedioInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("¿Desea registrar otro estudiante? (si/no): ");
            continuar = s.nextLine().equalsIgnoreCase("si");
        }

        System.out.println("\nLista de estudiantes registrados:");
        registro.mostrarEstudiantes();
    }
}
