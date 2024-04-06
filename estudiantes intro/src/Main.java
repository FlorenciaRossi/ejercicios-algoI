//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Estudiante pepa = new Estudiante("Pepa",20, "Ciencia de Datos", new Materia[]{new Materia("Algoritmos I", 9), new Materia("Matemática", 6)});
        System.out.println(pepa);
        System.out.println("Mejor materia de Pepa: ");
        System.out.println(pepa.mejorMateria());

        Estudiante matias = Estudiante.agregarEstudiantes("Matias", 23);
        matias.presentarse();
        System.out.println(matias);
    }
}