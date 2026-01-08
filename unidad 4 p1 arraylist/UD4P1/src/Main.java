import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> Producto = new ArrayList<>();
        Producto.add("a1");
        Producto.add("a2");
        Producto.add("a3");
        Producto.add("a4");
        Producto.add("a5");

        Iterator<Producto> itera = Producto.iterator();
        while(itera.hasNext()){
            System.out.println(itera.next());
        }
    }


}