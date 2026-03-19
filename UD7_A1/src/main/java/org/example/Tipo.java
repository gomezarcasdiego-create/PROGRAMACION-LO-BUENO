package org.example;

public class Tipo {
    private static int cont;
    private int id;
    private String nombre;

    public Tipo(int id, String nombre) {
        this.id = cont++;
        this.nombre = nombre;
    }

    public Tipo(String nombre) {
        this.id = cont++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
