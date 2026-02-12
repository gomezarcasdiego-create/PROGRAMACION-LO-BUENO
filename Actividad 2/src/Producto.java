import java.io.Serial;
import java.io.Serializable;

public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(int codigo, String nombre, int cantidad, double precio) {

        if (cantidad < 0)
            throw new IllegalArgumentException("Cantidad no puede ser negativa");

        if (precio < 0)
            throw new IllegalArgumentException("Precio no puede ser negativo");

        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format(
                "Código: %d | Nombre: %s | Cantidad: %d | Precio: %.2f€",
                codigo, nombre, cantidad, precio
        );
    }


}
