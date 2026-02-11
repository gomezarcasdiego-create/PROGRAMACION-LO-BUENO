import java.io.Serial;
import java.io.Serializable;

public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5730276595586163442L;


    int codigo;
    String nombre;
    int cantidad;
    double precio;

    public Producto(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String toString() {
        return "Código: " + codigo +
                " | Nombre: " + nombre +
                " | Cantidad: " + cantidad +
                " | Precio: " + precio;
    }
}
