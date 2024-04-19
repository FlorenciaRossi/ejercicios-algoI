public class Persona implements Comparable<Persona>{

    private int edad;
    private String nombre;

    public Persona(String n ,int e){
        edad = e;
        nombre = n;
    }

    public int getEdad() {
    return edad;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public int compareTo(Persona obj2) {
    return this.edad - obj2.getEdad();
    }
}

