package org.example;

/**
 * Clase que representa un producto del inventario.
 *
 * Contiene informacion basica como referencia, nombre, tipo,
 * cantidad, precio, impuestos y descuentos
 */
public class Producto {
    /** Contador estático para generar IDs automáticamente */
    private static int cont;

    /** Identificador único del producto */
    private int id;

    /** Referencia única del producto */
    private String referencia;

    /** Nombre del producto */
    private String nombre;

    /** Descripción del producto */
    private String descripcion;

    /** Tipo o categoría del producto */
    private Tipo tipo;

    /** Cantidad disponible en stock */
    private int cantidad;

    /** Precio del producto */
    private double precio;

    /** Porcentaje de descuento */
    private int descuento;

    /** Porcentaje de IVA */
    private int iva;

    /** Indica si se aplica descuento */
    private boolean aplicarDto;

    /**
     * Constructor sin id (se genera automaticamente).
     *
     * @param referencia
     * @param nombre
     * @param descripcion
     * @param tipo
     * @param cantidad
     * @param precio
     * @param descuento
     * @param iva
     * @param aplicarDto
     */
    public Producto(String referencia, String nombre, String descripcion, Tipo tipo, int cantidad,
                    double precio, int descuento, int iva, boolean aplicarDto) {
        this.id = cont++;
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    /**
     * Constructor con id (normalmente usado al recuperar de BD).
     *
     * Actualmente ignora el id recibido (error de diseño).
     *
     * @param id
     * @param referencia
     * @param nombre
     * @param descripcion
     * @param tipo
     * @param cantidad
     * @param precio
     * @param descuento
     * @param iva
     * @param aplicardto
     */
    public Producto(int id, String referencia, String nombre, String descripcion, Tipo tipo,
                    int cantidad, double precio, int descuento, int iva, boolean aplicardto) {
        this.id = cont++;
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    /** @return contador global de productos */
    public static int getCont() {
        return cont;
    }

    /** @param cont nuevo valor del contador */
    public static void setCont(int cont) {
        Producto.cont = cont;
    }

    /** @return id del producto */
    public int getId() {
        return id;
    }

    /** @param id nuevo id */
    public void setId(int id) {
        this.id = id;
    }

    /** @return referencia */
    public String getReferencia() {
        return referencia;
    }

    /** @param referencia nueva referencia */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /** @return nombre */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return descripción */
    public String getDescripcion() {
        return descripcion;
    }

    /** @param descripcion nueva descripción */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** @return tipo */
    public Tipo getTipo() {
        return tipo;
    }

    /** @param tipo nuevo tipo */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /** @return cantidad */
    public int getCantidad() {
        return cantidad;
    }

    /** @param cantidad nueva cantidad */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /** @return precio */
    public double getPrecio() {
        return precio;
    }

    /** @param precio nuevo precio */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /** @return descuento */
    public int getDescuento() {
        return descuento;
    }

    /** @param descuento nuevo descuento */
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    /** @return IVA */
    public int getIva() {
        return iva;
    }

    /** @param iva nuevo IVA */
    public void setIva(int iva) {
        this.iva = iva;
    }

    /** @return true si aplica descuento */
    public boolean isAplicarDto() {
        return aplicarDto;
    }

    /** @param aplicarDto nuevo valor */
    public void setAplicarDto(boolean aplicarDto) {
        this.aplicarDto = aplicarDto;
    }

    /**
     * Representacion en texto del producto.
     *
     * @return informacion del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", referencia='" + referencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo=" + tipo +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", descuento=" + descuento +
                ", iva=" + iva +
                ", aplicarDto=" + aplicarDto +
                '}';
    }
}
