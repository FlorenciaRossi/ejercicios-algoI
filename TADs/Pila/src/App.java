public class App {
    public static void main(String[] args) throws Exception {
        PilaEstatica p = new PilaEstatica(4);
    
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        p.apilar(4);
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        p.apilar(4);

        System.out.println("Desapilar: " + p.desapilar());
        System.out.println("Tope: " + p.tope());
        System.out.println(p.toString());
        
        //Dimámica
        Pila<Integer> p1 = new PilaDinamica<>();
        
        // Upper bounded wildcard <? extends T>: T o cualquier subtipo de T
        // solo podemos "leer" (como Number seguro) de p2 pero no "escribir" ya que java no puede garantizar el tipo exacto
        // p1 es subtipo de p2
        Pila<? extends Number> p2 = new PilaDinamica<Integer>();
        p2 = p1;

        // Lower bounded wildcard <? super T>: T o cualquier supertipo de T
        // en este caso puede ser Integer, Number u Object.
        // Solo podemos "escribir" en p3 (o leer Object),
        // podemos escribir ya que Integer es subtipo de cualquier p3 posible
        // p4 es subtipo de p3
        Pila<? super Integer> p3;
        Pila<Number> p4 = new PilaDinamica<>();
        p3 = p4;

        // Unbounded wildcard: solo podemos "leer" de p5 como Object
        // p5 es supertipo de p*
        Pila<?> p5;
        p5 = p3;
        //p5.apilar(3);

        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(4);
        p1.apilar(5);
        
        System.out.println("Desapilar: " + p1.desapilar());
        System.out.println("Tope: " + p1.tope());
        System.out.println(p1.toString());
    }
}
