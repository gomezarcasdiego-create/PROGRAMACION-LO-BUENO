package org.example;

import java.time.LocalDateTime;

public class EquipoJugador {

    private int id;
    private int idEquipo;
    private int idJugador;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int dorsal;

    public EquipoJugador(int id, int idEquipo, int idJugador, LocalDateTime fechaInicio, LocalDateTime fechaFin, int dorsal) {
        this.id = id;
        this.idEquipo = idEquipo;
        this.idJugador = idJugador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dorsal = dorsal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
}
