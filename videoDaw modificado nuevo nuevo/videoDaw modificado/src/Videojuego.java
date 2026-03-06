import java.io.Serializable;
import java.time.LocalDateTime;

public class Videojuego extends Articulo implements Serializable {

    public enum Genero {FIFA, CSGO, VALORANT, NBA, FORTNITE}
    private Genero Genero;

    public Videojuego(String cod, String titulo, Genero genero) {
        super(cod, titulo);
        this.Genero = genero;
    }

}
