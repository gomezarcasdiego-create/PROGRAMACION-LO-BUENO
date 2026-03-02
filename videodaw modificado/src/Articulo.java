import java.time.LocalDate;

public class Articulo {
    private String Cod;
    private String Titulo;
    private LocalDate FechaRegistro;
    private LocalDate FechaBaja;

    public Articulo(String cod, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja) {
        Cod = cod;
        Titulo = titulo;
        FechaRegistro = fechaRegistro;
        FechaBaja = fechaBaja;
    }

    public Articulo() {

    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String cod) {
        Cod = cod;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public LocalDate getfechaRegistro() {
        LocalDate fechaRegistro = null;
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return FechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        FechaBaja = fechaBaja;
    }
}