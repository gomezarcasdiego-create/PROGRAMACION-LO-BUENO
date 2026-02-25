import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String referencia;
    private String descripcion;
    private String tipo;
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    public Producto(String referencia, String descripcion, String tipo,
                    int cantidad, double precio, int descuento,
                    int iva, boolean aplicarDto) throws ProductoException {

        setReferencia(referencia);
        setDescripcion(descripcion);
        setTipo(tipo);
        setCantidad(cantidad);
        setPrecio(precio);
        setDescuento(descuento);
        setIva(iva);
        this.aplicarDto = aplicarDto;
    }

    public void setReferencia(String referencia) throws ProductoException {
        if (referencia == null || referencia.isEmpty())
            throw new ProductoException("Referencia inválida");
        this.referencia = referencia;
    }

    public void setCantidad(int cantidad) throws ProductoException {
        if (cantidad < 0)
            throw new ProductoException("Cantidad negativa");
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) throws ProductoException {
        if (precio < 0)
            throw new ProductoException("Precio negativo");
        this.precio = precio;
    }

    public void setDescuento(int descuento) throws ProductoException {
        if (descuento < 0 || descuento > 100)
            throw new ProductoException("Descuento inválido");
        this.descuento = descuento;
    }

    public void setIva(int iva) throws ProductoException {
        if (iva < 0 || iva > 100)
            throw new ProductoException("IVA inválido");
        this.iva = iva;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public double calcularPrecioFinal() {
        double precioFinal = precio;

        if (aplicarDto) {
            precioFinal -= precioFinal * descuento / 100.0;
        }

        precioFinal += precioFinal * iva / 100.0;

        return precioFinal;
    }

    @Override
    public String toString() {
        return referencia + " | " + descripcion + " | " + tipo +
                " | Cant: " + cantidad +
                " | Precio Final: " + calcularPrecioFinal();
    }
}