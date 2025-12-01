import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Clasepelicula {
    private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
    private Clasepelicula.Genero genero;

    public enum Genero { ACCION, COMEDIA, TERROR, DRAMA, AVENTURA }

    private String cod;
    private String titulo;
    private Genero Genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Clasepelicula(String cod, String titulo, String genero) {
        this.cod = cod;
        this.titulo = titulo;
        this.Genero = Genero;
        this.fechaRegistro = LocalDate.now();
        this.fechaBaja = null;
        this.fechaAlquiler = null;
        this.isAlquilada = false;
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

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void mostrarInfoPelicula() {
        System.out.println("\n--- PELÍCULA ---");
        System.out.println("Código: " + cod);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Fecha registro: " + fechaRegistro);
        System.out.println("Fecha baja: " + fechaBaja);
        System.out.println("Alquilada: " + (isAlquilada ? "Sí" : "No"));
        System.out.println("Fecha alquiler: " + fechaAlquiler);
    }
}
