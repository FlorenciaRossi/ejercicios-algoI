class School {
    public void ringBell() {
      System.out.println("Ringing the school bell...");
    }
  }
  class Classroom extends School {
    @Override
    public void ringBell() {
      System.out.println("Ringing the classroom bell...");
    }
  }
  public class BindingDinamico {
    public static void main(String[] args) {
      School s1 = new School(); // Es de tipo School y el objeto es de tipo School
      s1.ringBell();
      Classroom c1 = new Classroom(); // Es de tipo Classroom y el objeto es de tipo Classroom
      c1.ringBell();
      School s2 = new Classroom(); // Es de tipo School y el objeto es de tipo Classroom
      s2.ringBell();
    }
  }
  

