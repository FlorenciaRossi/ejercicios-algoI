package binding;

class Escuela {
   public void ringBell(){
      System.out.println("Ringing the shool bell...");
   }
}

class Clase extends Escuela {
   @Override
   public void ringBell() {
       System.out.println("Ringing the classroom bell...");
   }
}
public class BindingDinamico {
   public static void main(String[] args) {
      Escuela s1 = new Escuela(); // Es de tipo School y el objeto es de tipo School
      s1.ringBell();
      Clase c1 = new Clase(); // Es de tipo Classroom y el objeto es de tipo Classroom
      c1.ringBell();
      Escuela s2 = new Clase(); // Es de tipo School y el objeto es de tipo Classroom
      s2.ringBell();
    }
}
