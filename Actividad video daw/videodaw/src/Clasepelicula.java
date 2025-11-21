import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Clasepelicula {

    private String codigoIdentificador;
    private String titulo;
    public Enum Genero;
    LocalDate fechaRegistro;
    LocalDate fechaBaja;
    LocalDateTime fechaAlquiler;
    public boolean isAlquilada;

    public Clasepelicula(String codigoIdentificador, String titulo) {
        this.codigoIdentificador = codigoIdentificador;
        this.titulo = titulo;

    }

    public Clasepelicula(String codigoIdentificador, String titulo, Enum Genero, boolean isAlquilada){
        this.codigoIdentificador = codigoIdentificador;
        this.titulo = titulo;
        this.Genero = Genero;
        this.isAlquilada = isAlquilada;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }
        public void setCodigoIdentificador(String codigoIdentificador) {
            this.codigoIdentificador = codigoIdentificador;
        }

    public String getTitulo() {
        return titulo;
    }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

    public Enum getGenero() {
        return Genero;
    }

        public void setGenero(Enum genero) {
            this.Genero = genero;
        }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

        public void setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

        public void setFechaBaja(LocalDate fechaBaja) {
            this.fechaBaja = fechaBaja;
        }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

        public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
            this.fechaAlquiler = fechaAlquiler;
        }

    public boolean isAlquilada() {
        return isAlquilada;
    }

        public void setAlquilada(boolean alquilada) {
            isAlquilada = alquilada;
        }

    public void mostrarInfoPelicula() {
        System.out.println("Codigo de Identificador: " + this.codigoIdentificador);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Genero: " + this.Genero);
        System.out.println("Fecha Registro: " + this.fechaRegistro);
        System.out.println("Fecha Baja: " + this.fechaBaja);
        System.out.println("Fecha Alquiler: " + this.fechaAlquiler);
        System.out.println("Alquilada: " + this.isAlquilada);
    }
}


