import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Articulo implements Serializable {

    private String cod;
    private String titulo;
    private LocalDate fecharegistro;
    private LocalDate fechabaja;
    private boolean isAlquilada;
    private LocalDateTime fechaAlquiler;

    public Articulo(String cod, String titulo) {
        this.cod = cod;
        this.titulo = titulo;
        this.fecharegistro = LocalDate.now();
    }

    public LocalDate getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(LocalDate fechabaja) {
        this.fechabaja = fechabaja;
    }

    public LocalDate getFechaRegistro() {
        return fecharegistro;
    }

    public String getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "cod='" + cod + '\'' +
                ", Titulo='" + titulo + '\'' +
                ", FechaRegistro=" + fecharegistro +
                ", FechaBaja=" + fechabaja +
                '}';
    }


    public LocalDateTime getFechaAlquiler() {
        return this.fechaAlquiler;
    }
}