package binding;

class School {
    public static void ringBell() {
      System.out.println("Ringing the school bell...");
    }
}
  
class Classroom extends School {
  public static void ringBell() {
    System.out.println("Ringing the classroom bell...");
  }
}

public class BindingEstatico {
    public static void main(String[] args) {
        School s1 = new School(); // Es de tipo School
        s1.ringBell();
        Classroom c1 = new Classroom(); // Es de tipo Classroom
        c1.ringBell();
        School s2 = new Classroom(); // Es de tipo School
        s2.ringBell();
      }
}
