import java.time.LocalDateTime;

public class Videojuego extends Articulo {

    public enum Genero { SHOOTERS, RPG, SANDBOX, MOBA, AVENTURA }
    private Genero Genero;

    public Videojuego(String cod, String titulo, Genero genero) {
        super(cod, titulo);
        this.Genero = genero;
    }
}