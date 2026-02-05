public class Producto {

    String Codigo;
    String Nombre;
    String Precio;
    String cantidad;

    public Producto(String codigo, String nombre, String precio, String cantidad) {
        Codigo = codigo;
        Nombre = nombre;
        Precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Codigo='" + Codigo + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Precio='" + Precio + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}