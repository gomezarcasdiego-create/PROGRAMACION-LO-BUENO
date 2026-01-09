import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Producto a = new Producto("a", 1);
        Producto b = new Producto("a", 2);
        Producto c = new Producto("a", 3);
        Producto d = new Producto("a", 4);
        Producto e = new Producto("a", 5);



        ArrayList<Producto> Producto = new ArrayList<>();
        Producto.add(a);
        Producto.add(b);
        Producto.add(c);
        Producto.add(d);
        Producto.add(e);

        Iterator<Producto> iterator = Producto.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            System.out.println(producto);
        }

        Producto.remove(a);
        Producto.remove(e);

        Iterator<Producto> iterator2 = Producto.iterator();
        while (iterator2.hasNext()) {
            Producto producto = iterator2.next();
            System.out.println(producto);
        }

        Producto.add(2, e);

        Iterator<Producto> iterator3 = Producto.iterator();
        while (iterator3.hasNext()) {
            Producto producto = iterator3.next();
            System.out.println(producto);
        }

        Collections.sort(Producto);

        Producto.clear();

        Iterator<Producto> iterator4 = Producto.iterator();
        while (iterator4.hasNext()) {
            Producto producto = iterator4.next();
            System.out.println(producto);
        }


    }


}