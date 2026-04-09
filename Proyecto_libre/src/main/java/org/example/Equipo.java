package org.example;

import java.time.LocalDate;

public class Equipo {

    private int id_ciudad;
    private int id;
    private String nombre;
    private LocalDate fechaFundacion;
    private String nombreCampo;

    public Equipo(int id_ciudad, int id, String nombre, LocalDate fechaFundacion, String nombreCampo) {
        this.id_ciudad = id_ciudad;
        this.id = id;
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.nombreCampo = nombreCampo;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
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

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }
}
