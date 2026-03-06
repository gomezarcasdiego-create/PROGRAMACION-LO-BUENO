import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
public class Pelicula extends Articulo implements Serializable {
    private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
    private Pelicula.Genero genero;

    public enum Genero { ACCION, COMEDIA, TERROR, DRAMA, AVENTURA }


    private Genero Genero;

    public Pelicula(String cod, String titulo, String genero) {
        super(cod, titulo);
        this.Genero = Genero;
    }


    public void mostrarInfoPelicula() {
        System.out.println(super.toString());
        System.out.println("\n--- PELÍCULA ---");
        System.out.println("Género: " + genero);
        System.out.println("Fecha alquiler: " + super.getFechaAlquiler());
    }
}
