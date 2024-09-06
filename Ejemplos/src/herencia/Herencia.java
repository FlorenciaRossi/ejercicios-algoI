package herencia;

class A{
    private String campo1 = "campo 1 de A" ;
    protected String campo2 = "campo 2 de A";

    public String getCampo1() {
        return campo1;
    }

    protected void metodo1() {
        System.out.println("Hola soy el método 1 de A");
    }

    private void metodo2() {
        System.out.println("Hola soy el método 2 de A");
    }
}

class B extends A {
    private String campo1 = "campo 1 de B";
    private String campo2 = "campo 2 de B";

   
    public void getCampos(){
        System.out.println("this.campo1: " + this.campo1);
        System.out.println("getCampo1(): " + getCampo1());
        System.out.println("this.campo2: " + this.campo2);
        System.out.println("super.campo2: " + super.campo2);
    }

   @Override
   protected void metodo1() {
       System.out.println("Hola soy el método 1 de B (sobreescrito)");
   }

   public void metodo2(){
        System.out.println("Hola soy el método 2 de B (exclusivo)");
   }

   public void metodo3(){
        System.out.println("Hola soy el método 3 de B (exclusivo)");
   }
}

class C extends A {
    private String campo3 = "campo 3 de C";

    
    public void metodo1(int cant) {
        System.out.println("Hola soy el método 1 de C (sobrecargado)");
    }
    public void metodo3(){
        System.out.println("Hola soy el método 3 de C");
    }
}

public class Herencia {
    public static void main(String[] args) {
        B objB = new B();
        objB.getCampos();
        
        C objC = new C();
        objC.metodo1();          // binding estático
        objC.metodo1(1);    // binding estático

        A objA = new B();
        objA.metodo1();         // binding dinámico
    }
}

