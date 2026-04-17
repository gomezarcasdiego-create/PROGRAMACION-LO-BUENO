package org.example;

/**
 * Clase que representa un tipo o categoria de articulo
 *
 * Cada tipo tiene un identificador unico y un nombre descriptivo.
 */
public class Tipo {

    /** Contador estatico para generar los IDs automaticamente */
    private static int cont;

    /** Identificador unico del tipo */
    private int id;

    /**Nombre del tipo (ej: Accion, Comedia, Drama, etc.) */
    private String nombre;


    /**
     * Constructor con parametros.
     *
     * Aunque recibe un id, este se sobrescribe automaticamente
     * usando el contador estatico
     *
     * @param id identificador (no se usa realmente)
     * @param nombre Nombre del tipo
     */
    public Tipo(int id, String nombre) {
        this.id = cont++;
        this.nombre = nombre;
    }

    /**
     * Constructor que genera automaticamente el id.
     *
     * @param nombre Nombre del tipo
     */
    public Tipo(String nombre) {
        this.id = cont++;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del tipo
     *
     * @return id del tipo
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del tipo
     *
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Obtiene el nombre del tipo
     *
     * @return nombre del tipo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del tipo
     *
     * @param nombre nuevo Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una representacion en texto del objeto
     *
     * @return informacion del tipo en formato String
     */
    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}