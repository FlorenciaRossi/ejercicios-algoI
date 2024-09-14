package interfaces;

interface I1 {
    void metodo1();
}

interface I2 extends I1{
    @Override
    default void metodo1() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'metodo1'");
    }
   

}

interface I3 extends I1{
    void metodo1();
   
}

interface I4 extends I3, I2{

}

public class Prueba implements Comparable<Prueba>{
    public static void main(String[] args) {
        Prueba  p =new Prueba();
        
    }

    @Override
    public int compareTo(Prueba o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}