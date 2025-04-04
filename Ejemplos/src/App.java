import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Integer[] numbers = {10, 20, 30, 40, 50, 10, 30, 60, 70, 10};
        Integer[] p = bla(numbers);
        for ( Integer i : p ){
            System.out.println(i);
        }
        
    }

    public static Integer[] bla(Integer[] xs){    
        Set<Integer> aux = new HashSet<>();
    
        for (int x : xs) {
            aux.add(x);
        }
    
        List<Integer> ys= new ArrayList<>(aux); 
        Collections.sort(ys);
        return ys.toArray(new Integer[0]);
    }
}
