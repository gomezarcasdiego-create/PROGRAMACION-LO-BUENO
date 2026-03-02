import java.time.LocalDate;
import java.time.LocalDateTime;

public class Videojuego extends Articulo{
    public Videojuego(String cod, String titulo, LocalDate fechaAlta, LocalDate fechaBaja) {
        super(cod, titulo, fechaAlta, fechaBaja);
    }

    private Clasepelicula.Genero Genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Videojuego(Clasepelicula.Genero genero,
                      LocalDateTime fechaAlquiler, boolean isAlquilada) {
        Genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    public Clasepelicula.Genero getGenero() {
        return Genero;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setGenero(Clasepelicula.Genero genero) {
        Genero = genero;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "Genero=" + Genero +
                ", fechaAlquiler=" + fechaAlquiler +
                ", isAlquilada=" + isAlquilada +
                '}';
    }
}