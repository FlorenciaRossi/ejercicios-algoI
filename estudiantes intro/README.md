
# Ejercicio Estudiantes

Crear una clase llamada Estudiante que tenga los siguientes atributos:

- Nombre (String)
- Edad (int)
- Carrera (String)
- Materias (arreglo de String)
  
Luego, crear un objeto de tipo Estudiante con valores concretos para estos atributos e imprimir la información del estudiante en la consola.

TIP: Investigar el método toString y cómo puede utilizarse para mostrar en formato String la información del estudiante

## Segunda Parte

Modificar la clase Estudiante previa de forma que tenga los siguientes miembros:

- Un método que permita ver cúal es la materia con mejor **nota** del estudiante.
- Un atributo de clase llamado estudiantesTotales para realizar un seguimiento del número total de estudiantes.
- Dos atributos de instancia: nombre y edad.
- Un constructor que acepte un nombre y una edad como parámetros y los asigne a las variables de instancia correspondientes.
- Un método de instancia llamado presentarse() que imprima un mensaje que incluya el nombre y la edad.
- Un método de clase llamado getEstudiantesTotales() que devuelva el valor actual de estudiantesTotales.
- Un método de clase llamado agregarEstudiante(nombre, edad) que incremente estudiantesTotales en 1 cada vez que se llame y cree una nueva instancia de Estudiante con los parámetros proporcionados.
