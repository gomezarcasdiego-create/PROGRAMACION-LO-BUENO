import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Clasepelicula extends Articulo{
    private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
    private Clasepelicula.Genero genero;


    public enum Genero { ACCION, COMEDIA, TERROR, DRAMA, AVENTURA }

    private Genero Genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Clasepelicula(String cod, String titulo, LocalDate fechaAlta,
                         LocalDate fechaBaja, Genero genero,
                         Genero genero1, LocalDateTime fechaAlquiler,
                         boolean isAlquilada) {
        super(cod, titulo, fechaAlta, fechaBaja);
        this.genero = genero;
        Genero = genero1;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    public Clasepelicula(Genero genero, Genero genero1, LocalDateTime fechaAlquiler, boolean isAlquilada) {
        this.genero = genero;
        Genero = genero1;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }


    public void mostrarInfoPelicula() {
        System.out.println("\n--- PELÍCULA ---");
        System.out.println("Género: " + genero);
        System.out.println("Alquilada: " + (isAlquilada ? "Sí" : "No"));
        System.out.println("Fecha alquiler: " + fechaAlquiler);
    }
}